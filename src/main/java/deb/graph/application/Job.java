/**
 * 
 */
package deb.graph.application;

import java.util.List;

/**
 * @author debmalyajash
 *
 */
public class Job {
	
	private String name;
	private List<String> deps;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Job [name=" + name + ", deps=" + deps + "]";
	}
	
	/**
	 * Constructor
	 * @param jobName name of the job.
	 */
	public Job(String jobName) {
		name = jobName;
	}
	/**
	 * Add dependent jobs.
	 * @param dependentJobs dependent jobs
	 */
	public void setDependency(List<String> dependentJobs) {
		deps = dependentJobs;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the deps
	 */
	public List<String> getDeps() {
		return deps;
	}
	
	

}
