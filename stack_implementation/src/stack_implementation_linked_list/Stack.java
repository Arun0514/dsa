package stack_implementation_linked_list;

//stack : last in(add first) first out(delete first) 
//
public class Stack {
	private static Node top;

	static class Node {
		String data;
		Node next;

		public Node(String data) {
			super();
			this.data = data;
			this.next = null;
		}

	}

	public void displayLL() {
		if (top == null) { // optional part
			System.out.println("linked list is empty");
		} else {
			System.out.println("List : ");
			Node trav = top;
			while (trav != null) {
				// System.out.println("in display");

				System.out.println(trav.data);
				trav = trav.next;

			}

		}

	}

	public void push(String val) {
		if (top == null) {
			top = new Node(val);
		} else {
			// create new node
			Node newNode = new Node(val);
			// make new node next is top
			newNode.next = top;
			// point top to new node
			top = newNode;
		}
		System.out.println("new element pushed");
	}

	public void pop() {
		if (isEmpty()) {
			System.out.println("stack is empty, can't pop element");
		} else {
			peek();
			top = top.next;
			System.out.println("top element has been popped out.");
		}
	}

	public boolean isEmpty() {
		return top == null;
	}

	public void peek() {
		if (!isEmpty())
			System.out.println("current top is : " + top.data);
		else
			System.out.println("stack is empty");
	}

}
