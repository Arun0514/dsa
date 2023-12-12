package queue_stack;

import java.util.Scanner;

class Queue {
	private String arr[];
	// private int size;
	private int front;
	private int rear;

	public Queue(int size) {
		arr = new String[size];
		front = -1;
		rear = -1;
	}

	public void enque(String val) {
		if (!isFull()) {
			rear++;
			arr[rear] = val;
			System.out.println("element has been pushed");
		} else {
			System.out.println("queue is full");
		}
	}

	public void deque() {
		if (!isEmpty()) {
			front++;
			System.out.println("element has been popped");
		} else {
			System.out.println("queue is empty");
		}
	}

	public void peek() {
		System.out.println("front element is " + arr[front+1]);
	}

	public void display() {
		for (int i = front + 1; i <= rear; i++) {
			System.out.println(arr[i]);
		}
	}

	public boolean isFull() {
		return rear == arr.length - 1;
	}

	public boolean isEmpty() {
		return front == rear;
	}

}

public class QueueStackMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter size of queue");
		int size = sc.nextInt();
		Queue que = new Queue(size);
		boolean exit = false;
		while (!exit) {
			System.out.println(
					"Menu: \n" + "0.exit\n" + "1.enque\n" + "2.deque\n" + "3.peek\n" + "4.display\n" + "enter choice");
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
					que.peek();
					break;

				case 4:
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
