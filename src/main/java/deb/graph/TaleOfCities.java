/**
 * 
 */
package deb.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class TaleOfCities {

	/**
	 * Coders want to buy some cities. To buy two cities there must be a
	 * connector. How many cities coders can buy ?
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			// First line contains an integer T, denoting the number of test
			// cases.
			int T = scanner.nextInt();
			int[] result = new int[T];

			for (int i = 0; i < T; i++) {
				// The first line of each test case contains an integer E,
				// denoting the number of roads.
				int numberOfRoads = scanner.nextInt();
				scanner.nextLine();

				Map<Integer, List<Integer>> connectedCityMap = new HashMap<>();

				for (int j = 0; j < numberOfRoads; j++) {
					// The next E lines contain two space separated integers X
					// and
					// Y, denoting that there is an road between city X and city
					// Y.
					String[] XY = scanner.nextLine().split(" ");
					int x = Integer.parseInt(XY[0]);
					int y = Integer.parseInt(XY[1]);

					cityConnectivity(result, i, connectedCityMap, x, y);
					cityConnectivity(result, i, connectedCityMap, y, x);

				}
				// scanner.nextLine();
			}

			for (int i = 0; i < T; i++) {
				System.out.println(result[i]);
			}
		}

	}

	public static void cityConnectivity(int[] result, int i,
			Map<Integer, List<Integer>> connectedCityMap, int x, int y) {
		List<Integer> cityOne = connectedCityMap.get(x);
		if (cityOne == null) {
			cityOne = new ArrayList<Integer>();
		}
		if (!cityOne.contains(y)) {
			cityOne.add(y);
			// Added 1 for the city itself.
			result[i] = Math.max(result[i], cityOne.size() + 1);
		}
		connectedCityMap.put(x, cityOne);
	}

}
