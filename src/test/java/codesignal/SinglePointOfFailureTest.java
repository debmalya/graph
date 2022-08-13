package codesignal;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SinglePointOfFailureTest {
	static SinglePointOfFailure singlePointOfFailure;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		singlePointOfFailure = new SinglePointOfFailure();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testSolution() {

		Assertions.assertAll(

				() -> {
					int[][] connections = new int[][] { { 0, 1 }, { 1, 0 } };
					Assertions.assertSame(1, singlePointOfFailure.solution(connections));
				}, () -> {
					int[][] connections = new int[][] { { 0, 1, 1 }, { 1, 0, 1 }, { 1, 1, 0 } };
					Assertions.assertSame(3, singlePointOfFailure.solution(connections));
				});
	}

}
