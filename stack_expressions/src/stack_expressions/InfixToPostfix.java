package stack_expressions;

import java.util.Stack;

//1.traverse infix string from left to right
//2.if operand, directly append it to postfix string
/*3.if operator, push it into the stack
 *  (if topmost operator in stack has priority >= current priority,then 
 *  pop topmost operator and append it to postfix)*/
/*4.if operator is opening parenthesis, directly push it into stack,if 
 *  closing parenthesis pop all the operators in stack and append
    it till we get closing parenthesis,pop closing parenthesis and and discard opening and closing 
    parenthesis */
//5.when infix traversal is complete, pop remaining operators one by one and append it to postfix.
public class InfixToPostfix {
	private static String infixToPostfix(String infix) {
		StringBuilder postfix = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			if (Character.isDigit(c)) {
				postfix.append(c);
			} else if (c == '(') {
				stack.push(c);
				//System.out.println(stack.peek());
			} else if (c == ')') {
				while (stack.peek() != '(') {
					postfix.append(stack.pop());
					
				}
				stack.pop();// to discard Closing parenthesis.
			} else {
				while (!stack.isEmpty() && pri(stack.peek()) >= pri(c)) {
					postfix.append(stack.pop());
				}
				stack.push(c);

			}
		}
		while(!stack.isEmpty()) {
			postfix.append(stack.pop());
		}
		return postfix.toString();
	}

	private static int pri(Character c) {
		switch (c) {
		case '$':
			return 10;
		case '*':
			return 9;
		case '/':
			return 9;
		case '%':
			return 9;
		case '+':
			return 8;
		case '-':
			return 8;

		default:
			break;
		}
		return 0;
	}

	public static void main(String[] args) {
		String infix = "5+9-4*(8-6/2)+1$(7-3)";
		String postfix = infixToPostfix(infix);
		System.out.println(postfix.toString());
	}

}
