package singly_circular_linked_list;

public class SCLL {

	private Node head;
	private Node trav;

	class Node {
		private String data;
		private Node next;

		Node(String val) {
			data = val;
			next = null;
		}
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addFirst(String data) {
		// create new node.
		Node newNode = new Node(data);
		// special case when list is empty
		if (isEmpty()) {
			head = newNode;
			newNode.next = head;
			System.out.println("node has been added");
		} else {
			Node trav = head;
//		do {
//			trav=trav.next;
//		}while(trav.next!=head);
			while (trav.next != head)
				trav = trav.next;
			trav.next = newNode;
			// make new node next head
			newNode.next = head;
			// mark head to the new node
			head = newNode;
			System.out.println("new node has been added");
		}

	}

	public void addLast(String data) {
		// create new node
		Node newNode = new Node(data);
		// special case when list is empty
		if (isEmpty()) {
			head = newNode;
			newNode.next = head;
			System.out.println("node has been added");
		} else {
			// travel to the last node(i.e trav.next==head)
			Node trav = head;
//	do {
//		trav=trav.next;
//	}while(trav.next!=head);
			while (trav.next != head) {
				trav = trav.next;
			}
			// add new node
			trav.next = newNode;
			// make new node next head.
			newNode.next = head;
			System.out.println("new node has been added");
		}

	}

	public void displyAll() {
		if (isEmpty()) {
			// System.out.println("list is Empty");
			return;
		} else {
			trav = head;
			do {
				System.out.println(trav.data);
				trav = trav.next;
			} while (trav != head);
		}
	}

	public void addAtPos(String data, int pos) {
		if (head == null || pos <= 1) {
			addFirst(data);
			System.out.println("element has been added..");
		} else {
			// create new node
			Node newNode = new Node(data);
			// travel to the position-1
			trav = head;
			for (int i = 1; i < pos - 1; i++) {
				if (trav.next == head)
					break;
				trav = trav.next;
			}
			// make new node next trav next

			newNode.next = trav.next;
			// make trav next is new node
			trav.next = newNode;
			System.out.println("node has been added at position");
			//
		}
	}

	public void deleteFirst() {
		if (isEmpty()) {
			System.out.println("list is empty already");
		} else if (head.next == head) {
			head = null;
			System.out.println("node has been deleted");
		} else {
			// travel to the last node
			Node trav = head;
			while (trav.next != head) {
				trav = trav.next;
			}
			// make last node next is head
			trav.next = head.next;
			head = head.next;
			System.out.println("first node has been deleted");

		}
	}

	public void deleteLast() {
		// travel to the second last node
		if (isEmpty()) {
			System.out.println("list is empty already");
		} else if (head.next == head) {
			head = null;
			System.out.println("node has been deleted");
		} else {
			Node trav = head;
			while (trav.next.next != head) {
				trav = trav.next;
			}
			trav.next = head;
			System.out.println("last node has been deleted");
			// make second last node next is head
		}
	}

	public void deleteAtPos(int pos) {
		if (isEmpty() || pos<1) {
			System.out.println("list is empty or invalid position");
		} else if (pos == 1) {
			deleteFirst();
		}
//	else {
//	//travel to pos -1
//	Node trav=head;
//	//make trav next is trav's next's next
//	for(int i =1;i<pos-1;i++) {
//		trav=trav.next;
//	}
//	trav.next=trav.next.next;
//	
//	}
		else {
			Node trav = head;
			Node temp = null;
			for (int i = 0; i < pos; i++) {
				temp = trav;
				trav = trav.next;
				if (trav.next == head)
					throw new RuntimeException("invalid position...");
			}
			temp.next = trav.next;
		}

	}
}
