package stack_array;

import java.util.Scanner;

class Stack {
	private int[] arr;
	private int top;

	public Stack(int size) {
		arr = new int[size];
		top = -1;
	}

	public void push(int element) {
		if (!isFull()) {
			top++;
			arr[top] = element;
			System.out.println("element pushed.");
		} else {
			System.out.println("stack is full, can't push");
		}

	}

	public void pop() {
		if (!isEmpty()) {
			System.out.println("top element " + arr[top] + " is popped");
			top--;

		} else {
			System.out.println("stack is empty, can't pop");
		}

	}

	public void peek() {
		System.out.println("top is : " + arr[top]);

	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top == -1;
	}

	public boolean isFull() {
		return top == arr.length - 1;

	}
}

public class StackArrayMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter size of stack");
		int size = sc.nextInt();
		Stack s = new Stack(size);

		boolean exit = false;
		while (!exit) {
			System.out.println("Menu: \n" + "0.exit\n" + "1.push\n" + "2.pop\n" + "3.peek\n" + "4.empty\n" + "5.full\n"
					+ "enter choice");
			try {
				switch (sc.nextInt()) {
				case 1:
					System.out.println("enter element:");
					int element = sc.nextInt();
					s.push(element);
					break;
				case 2:
					s.pop();
					break;
				case 3:
					s.peek();

					break;
				case 4:
					boolean empty = s.isEmpty();
					if (empty)
						System.out.println("stack is empty");
					else
						System.out.println("stak is not empty");
					break;
				case 5:
					boolean full = s.isFull();
					if (full)
						System.out.println("stack is full");
					else
						System.out.println("stak is not full");
					break;
				default:
					break;
				}

			} catch (Exception e) {
				System.out.println(e);
			}
		}
		sc.close();
	}

}
