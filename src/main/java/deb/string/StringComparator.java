package deb.string;

import java.util.Comparator;
import java.util.Objects;

public class StringComparator  {

	Comparator<String> compareByLength = (a,b) -> {
		Objects.nonNull(a);
		Objects.nonNull(b);
		return a.length() - b.length();
	};

}
