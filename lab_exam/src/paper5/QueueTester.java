package paper5;

import java.util.Scanner;

public class QueueTester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size of queue");
		int size= sc.nextInt();
		Queue q= new Queue(size);
		boolean exit= false;
		while(!exit) {
			System.out.println("\n0.exit\n"
					+ "1.add\n"
					+ "2.remove\n"
					+ "3.size(number of elements stored in queue)\n"
					+ "4.tostring\n"
					+ "Enter choice");
			try {
			switch(sc.nextInt()) {
			case 1:
				System.out.println("enter the element : ");
				q.add(sc.nextInt());
				
				break;
			case 2:
				q.remove();
				
				break;
			case 3:
				q.size();
				
				break;
			case 4:
				q.display();
				break;
			case 5:
				break;
			}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
