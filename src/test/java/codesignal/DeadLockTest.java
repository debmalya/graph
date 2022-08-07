package codesignal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DeadLockTest {

	DeadLock deadLock = new DeadLock();

	@Test
	void testHasDeadLock() {
		int[][] connections = new int[][] { { 1 }, { 2 }, { 3, 4 }, { 4 }, { 0 } };
		assertTrue(deadLock.hasDeadLock(connections));
		
		connections = new int[][] { { 1, 2 }, { 2 }, {}, { 4 }, { 3 } };
		assertTrue(deadLock.hasDeadLock(connections));
		
		connections = new int[][] { { 2, 3, 5 }, { 0, 2, 5, 4, 3 }, { 3 }, { 5 }, { 3, 5 }, {} };
		assertFalse(deadLock.hasDeadLock(connections));
		
		connections = new int[][] { { 1, 4, 3 }, {}, { 1, 4, 3 }, { 1 }, { 3 } };
		assertFalse(deadLock.hasDeadLock(connections));

	}

}
