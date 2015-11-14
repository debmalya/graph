/**
 * 
 */
package deb.stack.application;

import java.util.Stack;

/**
 * @author debmalyajash
 *
 */
public class HTMLStringProcessor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 
	 * @param htmlString to be processed for correctness.
	 * @return true if proper HTML string false otherwise.
	 */
	public static boolean processHTML(String htmlString) {
		Stack<String> htmlElement = new Stack<>();
		
		// look for HTML element
		int i = htmlString.indexOf("<");
		while (i > 0) {
			if (i + 1 < htmlString.length()){
				htmlElement.push(htmlString.substring(i+1, i+2));
			}
		}
		
		return false;
	}

}
