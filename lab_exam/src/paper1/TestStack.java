package paper1;

import java.util.Iterator;
import java.util.Scanner;

public class TestStack {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size of stack");
		int size = sc.nextInt();
		Stack stack = new Stack(size);
		boolean exit = false;
		while (!exit) {
			System.out.println("Enter your choice \n" + "0.exit\n" + "1.push\n" + "2.pop\n" + "3.top\n" + "4.get max\n"
					+ "5.display stack\n" + "choose an option:\n ");
			try {
				switch (sc.nextInt()) {
				case 0:
					exit = true;

					break;
				case 1:
					System.out.println("enter element :");
					int element = sc.nextInt();
					stack.push(element);

					break;
				case 2:
					stack.pop();

					break;
				case 3:
					stack.peek();

					break;
				case 4:
					stack.getMax();

					break;
				case 5:
					System.out.println("display stack");
					stack.display();
					break;

				default:
					break;
				}

			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

}

class Stack {
	int[] stackArray;
	int top;
	int max;

	public Stack(int size) {
		this.stackArray = new int[size];
		top = -1;

	}

	public void getMax() throws StackCustomException {
		if (top==-1)
			throw new StackCustomException("empty stack");
		System.out.println("max element in stack is :"+ max);
		
	}

	public void peek() throws StackCustomException {
		if (top != -1)
			System.out.println("top element in stack is :" + stackArray[top]);
		else
			throw new StackCustomException("can't peek , empty stack");

	}

	public void pop() throws StackCustomException {
		if (isEmpty())
			throw new StackCustomException("empty stack");
		else {
			top--;
			System.out.println("element popped successfully");
		}

	}

	public boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		return false;

	}

	public boolean isFull() {
		if (top == stackArray.length - 1) {
			return true;
		}
		return false;

	}

	public void push(int element) throws StackCustomException {
		if (isFull()) {
			throw new StackCustomException("full stack, can't add elements");
		}
        
		
		
		top++;
		stackArray[top] = element;
		System.out.println("element pushed successully");
		if (top == 0) {
			max=stackArray[top];
			return;
		}
		
		if(stackArray[top]>max) {
			max=stackArray[top];
		}
		

	}

	public void display() {
		for (int i = 0; i <= top; i++) {
			System.out.println(stackArray[i]);
		}
	}

}
