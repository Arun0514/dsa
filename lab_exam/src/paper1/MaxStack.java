package paper1;
import java.util.Stack;

class MaxStack {
    private java.util.Stack<Integer> stack;
    private int currentMax;

    public MaxStack() {
        stack = new Stack<>();
        currentMax = Integer.MIN_VALUE;
    }

    public void push(int x) {
        if (x >= currentMax) {
            stack.push(currentMax);
            currentMax = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (!stack.isEmpty()) {
            if (stack.pop() == currentMax && !stack.isEmpty()) {
                currentMax = stack.pop();
            }
        }
    }

    public int top() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public int getMax() {
        return currentMax;
    }

    public static void main(String[] args) {
        MaxStack maxStack = new MaxStack();
        maxStack.push(3);
        maxStack.push(5);
        System.out.println("Top element: " + maxStack.top());  // Output: 5
        System.out.println("Max element: " + maxStack.getMax());  // Output: 5
        maxStack.push(2);
        maxStack.push(7);
        System.out.println("Top element: " + maxStack.top());  // Output: 7
        System.out.println("Max element: " + maxStack.getMax());  // Output: 7
        maxStack.pop();
        System.out.println("Top element: " + maxStack.top());  // Output: 2
        System.out.println("Max element: " + maxStack.getMax());  // Output: 5
    }
}
