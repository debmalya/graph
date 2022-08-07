/**
 * 
 */
package deb.graph;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author debmalyajash
 *
 */
public class GoldMineTest {

	/**
	 * Test method for {@link deb.graph.GoldMine#getMax(int, int[], int[])}.
	 */
	@Test
	public final void testGetMax() {
		int[] team = new int[]{0,2,3,1,0};
		int[] A = new int[]{0,1,2,3,5};
		
		int actual = GoldMine.getMax(team.length - 1, team, A);
		assertEquals(6, actual);
		
		team = new int[]{0,2,3,4,0};
		A = new int[]{0,1,2,3,5};
		actual = GoldMine.getMax(team.length - 1, team, A);
		assertEquals(11, actual);
		
		team = new int[]{0,2,3,0,0};
		A = new int[]{0,1,2,3,5};
		actual = GoldMine.getMax(team.length - 1, team, A);
		assertEquals(6, actual);
		
		team = new int[]{0,2,0,4,0};
		A = new int[]{0,1,2,3,5};
		actual = GoldMine.getMax(team.length - 1, team, A);
		assertEquals(8, actual);
		
		team = new int[]{0,0,0,0,0};
		A = new int[]{0,1,2,3,5};
		actual = GoldMine.getMax(team.length - 1, team, A);
		assertEquals(5, actual);
		
		team = new int[]{0,4,0,0,0};
		A = new int[]{0,1,2,3,5};
		actual = GoldMine.getMax(team.length - 1, team, A);
		assertEquals(6, actual);
		
		team = new int[]{0,0,4,0,0};
		A = new int[]{0,1,2,3,5};
		actual = GoldMine.getMax(team.length - 1, team, A);
		assertEquals(7, actual);
	}

}
