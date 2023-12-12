package circular_queue_array;

import java.util.Scanner;

class Queue {
	private int size;
	private String[] queue;
	private int front;
	private int rear;

	public Queue(int size) {
		queue = new String[size];
		front = -1;
		rear = -1;
	}

	public void enque(String data) {
		if (!isFull()) {
			rear = (rear + 1) % queue.length;
			queue[rear] = data;
			System.out.println("pushed");
		} else {
			System.out.println("queue is full");
		}

	}

	public void deque() {
		if (!isEmpty()) {
			front = (front + 1) % queue.length;
			System.out.println("popped");
			if (front == rear) {
				front = -1;
				rear = -1;
			}
		} else {
			System.out.println("queue is empty");
		}

	}

	public void peek() {
		if (!isEmpty())
			System.out.println("Front element is : " + queue[front + 1]);
		else
			System.out.println("queue is empty");
	}

	public boolean isEmpty() {
		return front == rear && front == -1;
	}

	public boolean isFull() {
		return (front == -1 && rear == queue.length - 1) || (front == rear && front != -1);
	}

}

public class QueueMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter size of queue");
		int size = sc.nextInt();
		Queue que = new Queue(size);
		boolean exit = false;
		while (!exit) {
			System.out.println("Menu: \n" + "0.exit\n" + "1.enque\n" + "2.deque\n" + "3.peek\n" + "enter choice");
			try {
				switch (sc.nextInt()) {
				case 0:exit=false;
				break;
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
				default:
					break;
				}

			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}

		}
		sc.close();
	}

}
