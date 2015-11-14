/**
 * 
 */
package deb.stack.application;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author debmalyajash
 *
 */
public class Parantheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Enter text :");
		try (Scanner scanner = new Scanner(System.in)) {
			String text = scanner.nextLine();
			System.out.println(isProperlyBalanced(text));
		}

	}

	/**
	 * Use a stack to determine whether is parentheses are properly balanced.
	 * 
	 * @param textStream
	 *            text stream
	 * @return true if properly balanced, false otherwise.
	 */
	public static boolean isProperlyBalanced(String textStream) {
		Stack<Character> brackets = new Stack<Character>();

		for (int i = 0; i < textStream.length(); i++) {
			char c = textStream.charAt(i);
			switch (c) {
			case '{':
			case '[':
			case '(':
				brackets.push(c);
				break;
			case '}':
				if (brackets.peek() != '{') {
					return false;
				} else if (brackets.peek() == '{') {
					brackets.pop();
				}
				break;
			case ')':
				if (brackets.peek() != '(') {
					return false;
				} else if (brackets.peek() == '(') {
					brackets.pop();
				}
				break;
			case ']':
				if (brackets.peek() != '[') {
					return false;
				} else if (brackets.peek() == '[') {
					brackets.pop();
				}
				break;

			}
		}

		if (brackets.isEmpty())
			return true;
		return false;
	}

}
