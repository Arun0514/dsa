package singly_circular_linked_list;

import java.util.Scanner;

public class TestSCLL {

	public static void main(String[] args) {
		SCLL list= new SCLL();
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			while (!exit) {
				System.out.println("Menu\n" + "0.exit\n" + "1.Add first\n" + "2.Add last\n" + "3.Add at pos\n"
						+ "4.Delete first\n" + "5.Delete last\n" + "6.Delete at pos\n" + "7.Display list\n");
				System.out.println("Enter choice...");
				try {
					switch (sc.nextInt()) {
					case 0:
						exit=true;
						break;
					case 1:
						System.out.println("Enter element...");
						String data=sc.next();
						list.addFirst(data);
						break;
					case 2:
						System.out.println("Enter element...");
						data=sc.next();
						list.addLast(data);
						
						break;
					case 3:
						System.out.println("Enter element pos..");
						int pos= sc.nextInt();
						System.out.println("Enter element...");
						data=sc.next();
						list.addAtPos(data,pos);
						
						break;
					case 4:
						list.deleteFirst();
						break;
					case 5:
						list.deleteLast();
						break;
					case 6:
						System.out.println("Enter position");
						pos=sc.nextInt();
						list.deleteAtPos(pos);
						break;
					case 7:
						list.displyAll();
						break;
					default:
						break;
					}

				} catch (Exception e) {
					sc.nextLine();
					System.out.println(e);
				}
			}

		}

	}

}
