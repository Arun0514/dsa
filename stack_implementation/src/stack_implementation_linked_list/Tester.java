package stack_implementation_linked_list;

import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		Stack s = new Stack();
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		while (!exit) {
			System.out.println("Menu: \n" + "0.exit\n" + "1.push\n" + "2.pop\n" + "3.peek\n" + "4.empty\n"
					+ "enter choice");
			try {
				switch (sc.nextInt()) {
				case 1:
					System.out.println("enter element:");
					String data = sc.next();
					s.push(data);
					break;
				case 2:
					s.pop();
					break;
				case 3:
					s.peek();
					
					break;
				case 4:
					boolean empty=s.isEmpty();
					if(empty)
						System.out.println("stack is empty");
						else
							System.out.println("stak is not empty");
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
