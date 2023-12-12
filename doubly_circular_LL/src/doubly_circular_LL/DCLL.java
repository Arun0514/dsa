package doubly_circular_LL;

public class DCLL {
	private Node head;

	class Node {
		private String data;
		private Node next;
		private Node prev;

		public Node(String data) {
			super();
			this.data = data;
			next = null;
			prev = null;
		}

	}

	public void addFirst(String data) {

		// create new node
		// special case :when list is empty
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			newNode.next = head;
			newNode.prev = head;
		} else {
			// travel to last node using head prev
			Node trav = head.prev;
			// last node next is new node
			trav.next = newNode;
			// new node prev is last node
			newNode.prev = trav;
			// new node next is head
			newNode.next = head;
			// head is new node
			head = newNode;
		}

	}

	public void addLast(String data) {
		// create new node
		// special case :when list is empty
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			newNode.next = head;
			newNode.prev = head;
			// or addFirst()
		} else {
			// travel to last node using head prev
			Node trav = head.prev;

			// last node next is new node
			trav.next = newNode;
			// new node prev is last node
			newNode.prev = trav;
			// new node next is head
			newNode.next = head;
			// head prev is new node
			head.prev = newNode;
		}
	}

	public void addAtPos(String data, int pos) {
		// special case: whe list is empty or pos is one
		if (head == null || pos <= 1) {
			addFirst(data);
		} else {
			// create new node
			Node newNode = new Node(data);
			// travel to the pos-1
			Node trav = head;
			for (int i = 1; i < pos - 1; i++) {
				if (trav.next == head)// if pos is greater than length of list then adding element at end of list
					break;
				trav = trav.next;
			}
			// new node next is trav next
			newNode.next = trav.next;
			// new node prev is trav
			newNode.prev = trav;
			// trav next prev is new node(traveling to the trav's next prev before updating
			// trav's next)
			trav.next.prev = newNode;
			// trav next is new node
			trav.next = newNode;
		}
	}

	public void deleteFirst() {
		// special case: when list has one node or list is empty
		if (head == null)
			System.out.println("list is empty");
		if (head.next == head)
			head = null;
		else {
			// travel to the last node
			Node trav = head.prev;
			// head is head next
			head = head.next;
			// last node next is head next
			trav.next = head;
			// now head prev is trav
			head.prev = trav;
		}

	}

	public void deleteLast() {
		if (head.next == head)
			head = null;
		else {
			// travel to the second last node
			Node trav = head.prev.prev;
			// second last node next is head
			trav.next = head;
			// head prev is second last node
			head.prev = trav;
		}

	}

	public void deleteAtPos(int pos) {
		// special case : when position is 1
		if (head == null)
			System.out.println("empty list");
		if (pos == 1)
			deleteFirst();
		else {
			// travel to the pos(trav) and pos -1(temp)
			Node trav = head, temp = null;
			for (int i = 1; i < pos; i++) {
				if (trav.next == head)
					throw new RuntimeException("position out of bound");
				temp = trav;
				trav = trav.next;
			}
			// trav next prev is temp
			trav.next.prev = temp;
			// temp next is trav next
			temp.next = trav.next;
		}
	}

	public void displyAll() {
		// travel to the last node
		System.out.println("List is :");
		Node trav = head;
		if (head == null)
			System.out.println(" empty");
		else {
			do {
				System.out.println(trav.data);
				trav = trav.next;
			} while (trav != head);
			System.out.println("reverse list is:");
			//Displaying list in reverse order
			Node temp=head.prev;
			do {
				System.out.println(temp.data);
				temp=temp.prev;
			}while(temp!=head.prev);
		}
	}

}
