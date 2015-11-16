/**
 * 
 */
package deb.graph.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class JobSchdulerTest {

	/**
	 * Test method for {@link deb.graph.application.JobSchduler#schedule(java.util.List)}.
	 */
	@Test
	public final void testSchedule() {
		List<Job> jobList = new ArrayList<Job>();

		createJob(jobList, "A", new String[] { "B", "C" });
		createJob(jobList, "B", new String[] { "D" });
		createJob(jobList, "C", null);
		createJob(jobList, "D", null);
		createJob(jobList, "E", null);
		
		JobSchduler scheduler = new JobSchduler();
		List<Job> scheduledJobs = scheduler.schedule(jobList);
		Assert.assertNotNull(scheduledJobs);
		Assert.assertEquals(5, scheduledJobs.size());
		System.out.println(scheduledJobs);
	}
	
	private void createJob(List<Job> jobList, String jobName, String[] deps) {
		Job job = new Job(jobName);
		
		if (deps != null) {
			job.setDependency(Arrays.asList(deps));
		}

		jobList.add(job);
	}

}
