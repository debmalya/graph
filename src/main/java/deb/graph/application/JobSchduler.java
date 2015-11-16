/**
 * 
 */
package deb.graph.application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author debmalyajash
 *
 */
public class JobSchduler {
	/**
	 * Takes a list of Jobs and puts them in an order that does not violate
	 * dependencies. e.g. A -> B, C Job A has dependency on B and C. B -> D B
	 * has dependency on D. C -> [] C has no dependency. D -> [] D has no
	 * dependency. E -> [] E has no dependency. A valid schedule might be,
	 * EDCBA, or DBCEA.
	 * 
	 * ABCDE is not valid.
	 * 
	 * @param jobList
	 *            list of job and with their dependencies.
	 * @return scheduled job list.
	 */
	public List<Job> schedule(List<Job> jobList) {
		List<Job> scheduledJobs = new ArrayList<Job>();

		// Maintain a link for the dependent jobs.
		// Key is the job (A)
		// Value is a list of dependent jobs (B,C).
		Map<Job, List<String>> jobDependency = new ConcurrentHashMap<Job, List<String>>(
				jobList.size());

		for (Job eachJob : jobList) {
			if (eachJob.getDeps() != null && !eachJob.getDeps().isEmpty()) {
				// can create some dependency tree here
				jobDependency.put(eachJob, eachJob.getDeps());
			} else {
				// This job does not have any dependency they can be added.
				scheduledJobs.add(eachJob);
			}
		}

		while (!jobDependency.isEmpty()) {
			Set<Entry<Job, List<String>>> oset = jobDependency.entrySet();
			Iterator<Entry<Job, List<String>>> myIterator = oset.iterator();

			while (myIterator.hasNext()) {
				Entry<Job, List<String>> nextEntry = myIterator.next();
				boolean canAdd = true;

				// Now check all the dependent jobs are scheduled or not
				for (String eachDep : nextEntry.getValue()) {
					if (scheduledJobs.stream().filter(job->job.getName().equals(eachDep)).count() == 0) {
						canAdd = false;
						break;
					}
				}
				
				if (canAdd) {
					scheduledJobs.add(nextEntry.getKey());
					jobDependency.remove(nextEntry.getKey());
					break;
				}
			}
		}

		return scheduledJobs;
	}

}
