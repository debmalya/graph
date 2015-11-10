/**
 * 
 */
package deb.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 * Coder has not enough money. But have to arrange birthday party. His friends
 * has different circles. In a circle each friends know each other. A list will
 * be given for the friends who know each other. Task is to arrange the birthday
 * party with minimum attendees.
 * 
 * @author debmalyajash
 *
 */
public class BirthdayParty {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			// The first line will contain two integers, N and D, where N
			// denotes the number of friends, while D denotes the number of
			// dependency relations.
			String[] ND = scanner.nextLine().split(" ");
			int n = Integer.parseInt(ND[0]);
			int d = Integer.parseInt(ND[1]);

			// The next D lines will contain two integers, a and b - which would
			// represent that friend a wouldn't come to the party until and
			// unless friend b is also invited.
			int minimumDependency = Integer.MAX_VALUE;
			Map<Integer, List<Integer>> dependencyMap = new HashMap<>();
			for (int j = 0; j < d; j++) {
				String[] dd = scanner.nextLine().split(" ");
				int x = Integer.parseInt(dd[0]);
				int y = Integer.parseInt(dd[1]);

				prepareDependencyMap(dependencyMap, x, y);
				prepareDependencyMap(dependencyMap, y, x);

			}
			
			Set<Entry<Integer, List<Integer>>> dependencyEntrySet = dependencyMap.entrySet();
			Iterator<Entry<Integer, List<Integer>>> dependencyIterator = dependencyEntrySet.iterator();
			while (dependencyIterator.hasNext()) {
				Entry<Integer, List<Integer>> nextEntry = dependencyIterator.next();
				System.out.println(nextEntry.getValue());
				minimumDependency = Math.min(minimumDependency, nextEntry.getValue().size()+1);
			}
			System.out.println(minimumDependency);
		}
	}

	public static void prepareDependencyMap(
			Map<Integer, List<Integer>> dependencyMap, int x, int y) {
		List<Integer> dependencyList = dependencyMap.get(x);
		if (dependencyList == null) {
			dependencyList = new ArrayList<Integer>();
		}
		if (!dependencyList.contains(y) && x != y) {
			dependencyList.add(y);
		}
		dependencyMap.put(x, dependencyList);
	}

}
