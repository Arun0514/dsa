package paper5;

public class Queue {
	private int[] arr;
	private int front;
	private int rear;
	

	public Queue(int size) {
		arr = new int[size];
		front = -1;
		rear = -1;

	}

	public void add(int value) {
		if (!isFull()) {
			rear = (rear + 1) % arr.length;
			arr[rear] = value;
			System.out.println("element added successfully");
		} else
			System.out.println("queue is full");

	}

	public boolean isEmpty() {
		return front == -1 && rear == -1;

	}

	public boolean isFull() {
		return (rear == front && front != -1) || (front == -1 && rear == arr.length - 1);

	}

	public void remove() {
		if (!isEmpty()) {
			front = (front + 1) % arr.length;
			System.out.println("element popped successfully");
			if (front == rear)
				front = rear = -1;
		} else {
			System.out.println("queue is empty");
		}

	}

	public void size() {
		int count=0;
		if(isEmpty()) {
			System.out.println("queue is empty");
			return;
		}
		if(front<rear) {
			for(int i=front+1;i<=rear;i++) {
				count++;
			}
		}
			else {
				for(int i=front+1;i<arr.length;i++) {
					System.out.print(arr[i]+",");
					count++;
				}
				for(int i=0;i<=rear;i++) {
					System.out.print(arr[i]+",");
					count++;
				}
				
			}
		System.out.println("size is :"+ count);
		}

	

	public void display() {
	if(isEmpty()) {
		System.out.println("queue is empty");
		return;
	}
	if(front<rear) {
		for(int i=front+1;i<=rear;i++) {
			System.out.print(arr[i]+",");
		}
	}
		else {
			for(int i=front+1;i<arr.length;i++) {
				System.out.print(arr[i]+",");
			}
			for(int i=0;i<=rear;i++) {
				System.out.print(arr[i]+",");
			}
			
		}
	}
	
	
	
		
	}

