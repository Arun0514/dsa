package paper3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SortedLL {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList list = new LinkedList();
		boolean exit = false;
		while (!exit) {
			System.out.println(
					"0.exit\n" + "1.Add\n" + "2.Add all\n" + "3.Remove\n" + "4.Tostring\n" + "Enter your choice");
			try {
				switch (sc.nextInt()) {
				case 0:
					exit = true;
					System.out.println("exit");
					break;
				case 1:
					System.out.println("enter element");
					int element = sc.nextInt();
					list.add(element);

					break;
				case 2:
					List<Integer> elementList = new ArrayList<Integer>();
					elementList.add(45);
					elementList.add(35);
					elementList.add(55);
					elementList.add(25);
					elementList.add(65);
					list.addAll(elementList);

					// System.out.println("enter elements in list :");

					break;
				case 3:
					System.out.println("enter element index");
					int index = sc.nextInt();
					list.remove(index);

					break;
				case 4:
					System.out.println("displaying linked list");
					list.display();

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
	static Node head;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public void add(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			System.out.println("first Node added successfully");
		} else {
			if (head.data > newNode.data) {
				newNode.next = head;
				head = newNode;
				System.out.println("node added in sorted manner");
				return;
			}
			Node trav = head;
			while (trav.next != null) {
				if (newNode.data >= trav.data && newNode.data <= trav.next.data) {
					newNode.next = trav.next;
					trav.next = newNode;
					System.out.println("node added in sorted manner");
					return;
				}

				trav = trav.next;
			}
			trav.next = newNode;
			System.out.println("node added in the end ");

		}

	}

	public void remove(int index) {
		if (index == 1) {
			head = head.next;
			System.out.println("element removed at 1 index");
			return;
		} else {
			Node trav = head, prev = null;
			for (int i = 1; i < index - 1; i++) {
				if(trav.next==null)
					throw new RuntimeException("index out of bound");
				trav = trav.next;
			}
			trav.next=trav.next.next;
			System.out.println();
		}

	}

	public void addAll(List<Integer> elementList) {
		for (Integer integer : elementList) {
			add(integer);
		}

	}

	public void display() {
		Node trav = head;
		if (trav == null) {
			System.out.println("linked list is empty");
			return;
		}
		while (trav != null) {
			System.out.print(trav.data + ",");
			trav = trav.next;
		}
		System.out.println();

	}

}
