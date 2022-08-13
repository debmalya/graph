package dp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LongestCommonSubsequenceTest {

	static LongestCommonSubsequence longestCommonSubsequence;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		longestCommonSubsequence = new LongestCommonSubsequence();
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
	void testLongestCommonSubsequence() {
		String first = "AGGTAB";
		String second = "GXTXAYB";
		assertEquals(4, longestCommonSubsequence.longestCommonSubsequence(first.toCharArray(), second.toCharArray(),
				first.length(), second.length()));
	}

}
