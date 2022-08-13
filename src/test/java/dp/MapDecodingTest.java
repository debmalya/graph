package dp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MapDecodingTest {

	MapDecoding mapDecoding = new MapDecoding();

	@Test
	void testSolution() {
		assertAll(() -> assertEquals(3, mapDecoding.solution("123")));
	}

}
