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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Job other = (Job) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
