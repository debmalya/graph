/**
 * 
 */
package deb.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * @author debmalyajash
 *
 */
public class TaleOfCitiesTest {

	/**
	 * Test method for {@link deb.graph.TaleOfCities#cityConnectivity(int[], int, java.util.Map, int, int)}.
	 */
	@Test
	public final void testCityConnectivity() {
		Map<Integer,List<Integer>> connectedCityMap = new HashMap<Integer,List<Integer>>();
		int[] result = new int[1];
		TaleOfCities.cityConnectivity(result,0, connectedCityMap, 1, 2);
		TaleOfCities.cityConnectivity(result,0, connectedCityMap, 2, 1);
		TaleOfCities.cityConnectivity(result,0, connectedCityMap, 2, 3);
		TaleOfCities.cityConnectivity(result,0, connectedCityMap, 3, 2);
		
		assertEquals(3, result[0]);
	}

}
