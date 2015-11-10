/**
 * 
 */
package deb.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

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
		
		Assert.assertEquals(3, result[0]);
	}

}
