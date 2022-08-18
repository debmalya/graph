package aax;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
	private int size;
	private Queue<Integer> windowedNumbers;
	private long sum = 0;

	public MovingAverage(int size) {
		this.size = size;
		windowedNumbers = new LinkedList<Integer>();
	}

	public double next(int value) {
		sum += value;
		if (windowedNumbers.size() == size) {
			sum -= windowedNumbers.poll();
		}
		windowedNumbers.add(value);

		return (double) sum / windowedNumbers.size();
	}
}
