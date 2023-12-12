package queue_linked_list;

import java.util.Scanner;
//Queue : first in(addLast) first out(deleteFirst)

class Queue {
	private Node front;
	private Node rear;

	class Node {
		private String data;
		private Node next;

		public Node(String data) {
			super();
			this.data = data;
			this.next = null;
		}
	}

	public void enque(String data) {
		//addLast
		Node newNode=new Node(data);
		if(rear==null) {
			front=newNode;
			rear=newNode;
		}
		else {
			rear.next=newNode;
			rear=newNode;
			
		}
		System.out.println("element has been pushed");
		
	}
	public void deque() {
		//deleteFirst
		if(isEmpty()) {
			System.out.println("queue is empty");
		}
		else {
			front=front.next;
			System.out.println("element has been popped");
		}
	}
	public boolean isEmpty() {
		return rear==null;
	}
	public void display() {
		
		Node trav=front;
		while(trav!=null) {
			System.out.println(trav.data);
			trav=trav.next;
		}
		
		
	}
	

}

public class QueueMain {

	public static void main(String[] args) {

		Queue que = new Queue();
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		while (!exit) {
			System.out.println(
					"Menu: \n" + "0.exit\n" + "1.enque\n" + "2.deque\n" + "3.display\n"+ "enter choice");
			try {
				switch (sc.nextInt()) {
				case 1:
					System.out.println("enter element:");
					String data = sc.next();
					que.enque(data);
					break;
				case 2:
					que.deque();
					break;
				
				case 3:
			          System.out.println("list is :");
			          que.display();
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
