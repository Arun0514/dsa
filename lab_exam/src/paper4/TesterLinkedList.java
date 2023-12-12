package paper4;

import java.util.Scanner;

public class TesterLinkedList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList list = new LinkedList();
		boolean exit = false;
		while (!exit) {
			System.out.println(
					"0.exit\n" + "1.Add\n" + "2.find\n" + "3.toString\n" + "4.isSorted\n" + "Enter your choice");
			try {
				switch (sc.nextInt()) {
				case 0:
					exit = false;
					break;
				case 1:
					System.out.println("enter element :");
					int element = sc.nextInt();
					list.add(element);

					break;
				case 2:
					System.out.println("enter the element");
					element = sc.nextInt();
					System.out.println("positin of element is :" + list.find(element));

					break;
				case 3:

					list.display();

					break;
				case 4:
					System.out.println(list.isSorted());

					break;

				default:
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}

class LinkedList {
	private Node head;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			next = null;

		}
	}

	public void add(int element) {
		Node newNode = new Node(element);
		if (head == null) {
			head = newNode;
			System.out.println("head node added");
		} else {
			Node trav = head;
			while (trav.next != null) {
				trav = trav.next;

			}
			trav.next = newNode;
			System.out.println("node added successfully in the end ");

		}

	}

	public String isSorted() {
		
		Node trav= head,prev=null;
	
		while(trav.next!= null) {
			prev=trav;
			trav=trav.next;
			if(prev.data>trav.data)
				return "list is not sorted";
			
		}
		return "list is sorted";
	}

	public void display() {
		System.out.println("list is :");
		Node trav = head;
		if (head == null) {
			System.out.println("list is empty ");
			return;
		}
		while (trav != null) {
			System.out.println(trav.data + ",");
			trav = trav.next;
		}

	}
//	private int find(int val) {
//
//		Node trav = head;
//		for (int i = 1; trav != null; i++) {
//			if (trav.data == val)
//				return i;
//			trav = trav.next;
//		}
//
//		return -1;
//	}

	public int find(int element) {
		if (head == null) {
			System.out.println("list is empty");
			return -1;
		}
		int count = 1;
		Node trav = head;

		while (trav.data != element) {
			trav = trav.next;
			if (trav == null)
				return -1;
			++count;

		}
		return count;

	}

}
