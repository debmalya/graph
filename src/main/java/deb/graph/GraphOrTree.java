/**
 * 
 */
package deb.graph;

import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class GraphOrTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int numberOfVertices = scanner.nextInt();
			scanner.nextLine();
			isTree(scanner);
		}

	}

	public static void isTree(Scanner scanner) {
		String[] degrees = scanner.nextLine().split(" ");
		for (int i = 0; i < degrees.length; i++) {
			int d = Integer.parseInt(degrees[i]);
			if (d< 1 && d > 2) {
				System.out.println("No");
				System.exit(0);
			}
		}
		System.out.println("Yes");
	}

}
