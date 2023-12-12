package stack_expressions;

import java.util.Stack;

//1.traverse the expression till the end
//2.If operands, push it into the stack,
/*3.if operator, pop two operands and perform the operation
    (first popped element must be 1st operand while solving,second popped be 2nd operand)
    push the result of above operation into the stack*/
//4.repeat 2 and 3 till we get the final result
//5.pop the final result

public class PrefixEvalutionMain {

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

	private static int solveprefix(String prefix) {
        // empty stack creation
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = prefix.length()-1; i>=0; i--) {
			char c = prefix.charAt(i);//charAt- String method to return character value at given index
			if (Character.isDigit(c)) {//isDigit- to check whether given character is digit or not
				String operand= Character.toString(c);
				stack.push(Integer.parseInt(operand));//parseInt- to parse string into its integer value
				//System.out.println(stack.peek());
			} else {
				int num1 = stack.pop();
				int num2 = stack.pop();
				int result = calc(num1, num2, c);
				stack.push(result);
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		String prefix = "+-+59*4-8/62$1-73";
		int result = solveprefix(prefix);
		System.out.println(result);
	}

}
