package exercises.stack;

import java.util.Stack;

/**
 * Created by Temurbek Ismoilov on 21/01/23.
 */

public class QueueViaStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> helperStack;

    public QueueViaStack(){
        this.mainStack = new Stack<>();
        this.helperStack = new Stack<>();
    }

    public void enqueue(int value) {
        if (mainStack.isEmpty()) {
            mainStack.push(value);
        } else {
            while (!mainStack.isEmpty()) {
                helperStack.push(mainStack.pop());
            }
            mainStack.push(value);
            while (!helperStack.isEmpty()) {
                mainStack.push(helperStack.pop());
            }
        }
    }

    public Integer dequeue() {
        if (mainStack.isEmpty()) {
            System.out.println("queue is empty");
            return -1;
        }

        return mainStack.pop();
    }

    public Integer peek() {
        if (mainStack.isEmpty()) {
            System.out.println("queue is empty");
            return -1;
        }

        return mainStack.peek();
    }
}