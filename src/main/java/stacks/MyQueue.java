package stacks;

import java.util.ArrayList;
import java.util.Stack;

public class MyQueue {
    Stack<Integer> stackOne = new Stack<Integer>();
    Stack<Integer> stackTwo = new Stack<Integer>();

    ArrayList<Integer> stackElements = new ArrayList<Integer>();

    public MyQueue() {
        stackOne.push(1);
        stackOne.push(2);
        stackOne.push(3);
        stackOne.push(4);

        stackTwo.push(7);
        stackTwo.push(18);
        stackTwo.push(11);

        System.out.println(stackOne);
        System.out.println(stackTwo);
    }

    public void push(int item) {
        stackTwo.push(item);
    }

    public int pop() {
        while (!stackOne.isEmpty()) {
            stackElements.add(stackOne.pop());
        }
        int popped;
        for (int i = stackElements.size() - 1; i > 0 ; i--) {
            stackOne.push(stackElements.get(i));
        }
        popped = stackElements.get(0);
        stackElements.clear();

        System.out.println(stackOne);
        return popped;
    }
}
