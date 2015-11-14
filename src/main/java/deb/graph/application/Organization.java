/**
 * 
 */
package deb.graph.application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is an organization. For each employee we can assign boss. Then try to
 * find out common boss for two employees. If there are no common boss, then
 * returns null.
 *
 * @author debmalya jash
 */
public class Organization {

	private static Map<String, String> subordinates = new HashMap<String, String>();

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		Organization organization = new Organization();
		// T->A (T reports to A)
		organization.setBoss("T", "A");
		// S->T (S reports to T)
		organization.setBoss("S", "T");
		// D->S (D reports to S)
		organization.setBoss("D", "S");
		// G->T (G reports to T)
		organization.setBoss("G", "T");
		// F->G (F reports to G)
		organization.setBoss("F", "G");
		// K->I (K reports to I)
		organization.setBoss("K", "I");

		// Reporting hierarchy
		// D->S->T->A
		// F->G->T->A
		// K->I
		System.out.println("Common boss of D and F :" + getCommonBoss("D", "F"));
		System.out.println("Common boss of D and S :" + getCommonBoss("D", "S"));
		System.out.println("Common boss of D and A :" + getCommonBoss("D", "A"));
		System.out.println("Common boss of D and T :" + getCommonBoss("D", "T"));
		// D and K do not have a common boss
		System.out.println("Common boss of D nad K :" + getCommonBoss("D", "K"));

	}

	public void setBoss(String employeeName, String boss) {
		subordinates.put(employeeName, boss);
	}

	public static String getCommonBoss(String employee1, String employee2) {
		List<String> bossList1 = getListOfBosses(employee1);
		if (bossList1.contains(employee2)) {
			return employee2;
		}

		String boss = null;
		while ((boss = subordinates.get(employee2)) != null) {
			if (bossList1.contains(boss) || boss.equals(employee1)) {
				return boss;
			}
			employee2 = boss;

		}

		return null;
	}

	public static List<String> getListOfBosses(String employee) {
		List<String> listOfBoss = new ArrayList<>();

		String boss = null;
		while ((boss = subordinates.get(employee)) != null) {
			listOfBoss.add(boss);
			employee = boss;

		}
		return listOfBoss;
	}
}
