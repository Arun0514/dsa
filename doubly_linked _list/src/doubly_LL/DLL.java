package doubly_LL;

public class DLL {
	private Node head;

	class Node {
		private String data;
		private Node next;
		private Node prev;

		public Node(String data) {
			this.data = data;
			next = null;
			prev = null;
		}
	}

	public void addFirst(String data) {
		// general case
		// create new node
		Node newNode = new Node(data);
		// put head in new node's next
		newNode.next = head;
		// point new node as head
		head = newNode;

	}

	public void addLast(String data) {
		if (head == null) {
			addFirst(data);
		} else {
			// general case
			// create node
			Node newNode = new Node(data);
			// travel to the last node
			Node trav = head;
			while (trav.next != null) {
				trav = trav.next;
			}
			// make last node next is new node
			trav.next = newNode;
		}
	}

	public void addAtPos(String data, int pos) {
		// special case1,2: when list is empty or pos<=1
		if (head == null || pos <= 1) {
			addFirst(data);
		} else {
			// general case
			// create new node
			Node newNode = new Node(data);
			// travel till pos-1
			Node trav = head;
			for (int i = 1; i < pos - 1; i++) {
				if (trav.next == null)// special case 3: if position is beyond the length of list
					break;
				trav = trav.next;
			}
			// make connection
			newNode.next = trav.next;
			newNode.prev = trav;
			/*
			 * below condition used when position is beyond the length of list, if not used
			 * ,there will be no object at trav.next.prev,and will throw null pointer
			 * exception
			 */
			if (trav.next != null)
				trav.next.prev = newNode;

			trav.next = newNode;
		}
	}

	public void deleteFirst() {
		// special case : if list is empty or have one node
		if (head.next == null || head == null) {
			head = null;
		} else {
			// make head is head next
			head = head.next;
			// now make head prev is null
			head.prev = null;
		}

	}

	public void deleteLast() {
		// special case
		if (head.next == null) {
			head = null;
		} else {
			// general case
			// travel to the second last node
			Node trav = head;
			while (trav.next.next != null) {
				trav = trav.next;
			}
			trav.next = null;
			// make second last node next null
		}

	}

	public void deleteAtPos(int pos) {
		// special case 1:when list is empty.
		// special case 2:when pos is 1
		if (head == null || pos < 1) {
			throw new RuntimeException("invalid position or list is empty...");
		}
		if (pos == 1) {
			deleteFirst();
		} else {
			// general case
			// travel to the postion(pos) and position -1(temp)
			Node trav = head, temp = null;
			for (int i = 1; i < pos; i++) {
				if (trav.next==null)
					throw new RuntimeException("position is out of bound");//special 3: when pos is out of bound
				temp = trav;
				trav = trav.next;
			}
			// make and break connections
			temp.next = trav.next;
			if (trav.next != null)
				trav.next.prev = temp;
		}

	}

	public void displyAll() {
		// travel the list
		System.out.println("List is :");
		Node trav = head;
		while (trav != null) {
			System.out.println(trav.data);
			trav = trav.next;
		}

	}
}
