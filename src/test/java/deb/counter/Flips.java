/**
 * 
 */
package deb.counter;

import java.util.Random;

/**
 * @author debmalyajash
 *
 */
public class Flips {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length > 0) {
			int T = Integer.parseInt(args[0]);

			Random random = new Random(System.currentTimeMillis());

			Counter heads = new Counter("heads");
			Counter tails = new Counter("tails");

			for (int t = 0; t < T; t++) {
				if (random.nextInt() % 2 == 0) {
					heads.increment();
				} else {
					tails.increment();
				}
			}
			
			System.out.println("Heads :" + heads.tally());
			System.out.println("Tails :" + tails.tally());
			
			

		} else {
			System.err.println("Usage: java deb.counter.Flips <<number>>");
		}

	}

}
