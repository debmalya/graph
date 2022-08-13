package deb.string;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class StringComparatorTest {

	StringComparator stringComparator = new StringComparator();

	@Test
	void test() {
		String[] words = new String[] { "first", "last" };
		List<String> sortedWords = Arrays.asList(words);
		Collections.sort(sortedWords, stringComparator.compareByLength);
		assertAll(() -> assertEquals("first", sortedWords.get(1)), () -> assertEquals("last", sortedWords.get(0)));
	}
	
	@Test
	void testSameLength() {
		String[] words = new String[] { "first", "frost" };
		List<String> sortedWords = Arrays.asList(words);
		Collections.sort(sortedWords, stringComparator.compareByLength);
		assertAll(() -> assertEquals("frost", sortedWords.get(1)), () -> assertEquals("first", sortedWords.get(0)));
	}

}
