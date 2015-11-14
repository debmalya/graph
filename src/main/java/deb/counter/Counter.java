/**
 * 
 */
package deb.counter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author debmalyajash
 *
 */
public class Counter {
	/**
	 * Count will be incremented by increment method.
	 */
	private AtomicInteger count;
	
	/**
	 * 
	 */
	private String id;
	
	public Counter(String id){
		this.id = id;
		this.count = new AtomicInteger();
	}
	/**
	 * number of increments since creation.
	 * @return integer.
	 */
	public int tally() {
		return count.get();
	}
	
	/**
	 * increment the counter
	 * @return the incremented count.
	 */
	public int increment() {
		return count.incrementAndGet();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Counter [count=" + count + ", id=" + id + "]";
	}
	
	
}
