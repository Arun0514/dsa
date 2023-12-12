package stack_expressions;

import java.util.Stack;

//1.traverse the expression till the end
//2.If operands, push it into the stack,
/*3.if operator, pop two operands and perform the operation
    (first popped element must be second operand while solving,second popped be first operand)
    push the result of above operation into the stack*/
//4.repeat 2 and 3 till we get the final result
//5.pop the final result

public class PostfixEvalutionMain {

	private static int calc(int num1, int num2, char op) {
		switch (op) {
		case '+':
			return num1 + num2;
		case '-':
			return num1 - num2;
		case '/':
			return num1 / num2;
		case '*':
			return num1 * num2;
		case '$':
			return (int) Math.pow(num1, num2);

		default:
			break;
		}
		return 0;
	}

	private static int solvePostfix(String postfix) {
        // empty stack creation
		Stack<Integer> stack = new Stack<Integer>();
		//traverse till the last
		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			//if char is digit push
			if (Character.isDigit(c)) {
				//convert char to int  char('5')->string("5")->int(5)
				String operand= Character.toString(c);
				stack.push(Integer.parseInt(operand));//parseInt- to parse string into its integer value
				//System.out.println(stack.peek());
			} else {
				//if char is operator pop two elements
				int num2 = stack.pop();
				int num1 = stack.pop();
				//perform operation
				int result = calc(num1, num2, c);
				//pus result
				stack.push(result);
			}
		}
		//pop the final element and return the result
		return stack.pop();
	}

	public static void main(String[] args) {
		String postfix = "59+4862/-*-173-$+";
		int result = solvePostfix(postfix);
		System.out.println(result);
	}

}
