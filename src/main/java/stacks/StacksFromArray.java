package stacks;

import java.util.EmptyStackException;

public class StacksFromArray {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public StacksFromArray(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[stackSize];
    }

    public void push(int stackNum, int value) throws FullStackException {
        if (isFull(stackNum)) {
            throw new FullStackException();
        }
        /* Increment stack pointer and then update top value.*/
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;

    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex]; //get top
        values[topIndex] = 0; //clear
        sizes[stackNum]--;//shrink stack size
        return value; //return popped value
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex];
        return value;
    }

    private boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        return offset + sizes[stackNum] +-1;
    }

    private boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    public int[] getValues() {
        return values;
    }

    public int[] getSizes() {
        return sizes;
    }
}
