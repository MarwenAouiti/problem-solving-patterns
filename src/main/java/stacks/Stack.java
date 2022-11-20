package stacks;

import java.util.EmptyStackException;

public class Stack<T> {
    private static class StackNode<T extends Comparable<T>> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }

        private StackNode<T> top;

        public T pop() {
            if (top == null) throw new EmptyStackException();
            T item = top.data;
            top = top.next;
            return item;
        }

        public T min() {
            if (top == null) throw new EmptyStackException();
            T min = this.pop();

            while (!this.isEmpty()) {
                if (min.compareTo(this.peek()) < 0) {
                    min = this.pop();
                } else {
                    continue;
                }
            }
            return min;
        }

        public void push(T item) {
            StackNode<T> t = new StackNode<T>(item);
            t.next = top;
            top = t;
        }

        public T peek() {
            if (top == null) throw new EmptyStackException();
            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }
}
