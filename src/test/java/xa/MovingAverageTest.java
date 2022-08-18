package xa;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import aax.MovingAverage;

class MovingAverageTest {

	@Test
	void testNext() {
		MovingAverage movingAverage = new MovingAverage(3);
		
		assertAll(
				() -> assertEquals(3.00,movingAverage.next(3)),
				() -> assertEquals(6.50,movingAverage.next(10)),
				() -> assertEquals(6.333333333333333,movingAverage.next(6)),
				() -> assertEquals(8.0,movingAverage.next(8))
		);
	}

}
