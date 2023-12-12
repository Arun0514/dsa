package paper2;

import java.util.Scanner;

public class TestLinkedList {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		while (!exit) {
			System.out.println("0.exit\n" + "1.Add element X at the end of list\n" + "2.Add element X at index i\n"
					+ "3.Remove all occurences of X from the list\n" + "4.Display all elements\n"
					+ "5.Reverse the linked list\n" + "Enter your choice\n ");
			try {
				switch (sc.nextInt()) {
				case 1:
					System.out.println("Enter element X :");
					int element = sc.nextInt();
					list.addLast(element);

					break;
				case 2:
					System.out.println("Enter element X ");
					element = sc.nextInt();
					System.out.println("Enter index i");
					int pos = sc.nextInt();
					list.addAtIndexI(element, pos);

					break;
				case 3:
					System.out.println("enter element X, to remove it's all occurences");
					list.removeAllX(sc.nextInt());

					break;
				case 4:
					list.display();
					break;
				case 5:
					list.reverse();

					break;

				default:
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				sc.nextLine();
			}
		}

	}

}

class LinkedList {
	private Node head;

	class Node {
		private int element;
		private Node next;

		public Node(int element) {
			this.element = element;
			this.next = null;
		}
	}

	public void addLast(int element) {
		Node newNode = new Node(element);
		if (head == null)
			head = newNode;
		else {
			Node trav = head;
			while (trav.next != null) {
				trav = trav.next;
			}
			trav.next = newNode;
		}
		System.out.println("Node added succesfully at the end");
	}

	public void addAtIndexI(int element, int index) {
		Node newNode = new Node(element);
		if (head == null) {
			head = newNode;
		} else {
			Node trav = head;
			for (int i = 0; i < index - 1; i++) {
				if (trav.next == null)
					break;
				trav = trav.next;
			}
			newNode.next = trav.next;
			trav.next = newNode;
			}
		System.out.println("Node added succesfully at the index " + index);
	}

	public void removeAllX(int element) {
		Node trav = head, prev = null;
		while (trav != null && trav.element == element) {
			head = trav.next;
			trav = head;
		}

		while (trav != null) {
			while (trav != null && trav.element != element) {
				prev = trav;
				trav = trav.next;
			}
			if (trav == null) {

				return;
			}
			prev.next = trav.next;
			trav = prev.next;
		}

	}

	public void display() {
		// System.out.println("displaying linked list");
		if (head == null) {
			System.out.println("linked list is empty");
		}
		Node trav = head;
		while (trav != null) {
			System.out.print(trav.element + " ");
			trav = trav.next;
		}
		System.out.println();
	}

	public void reverse() {
		Node trav = head;
		Node prevTemp = null;
		Node nextTemp;
		while (trav != null) {
			nextTemp = trav.next;
			trav.next = prevTemp;
			prevTemp = trav;
			trav = nextTemp;

		}
		head = prevTemp;
		System.out.println("reversed linked list");
		display();

	}

}
