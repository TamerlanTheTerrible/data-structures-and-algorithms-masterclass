package exercises.stack;

/**
 * Created by Temurbek Ismoilov on 21/01/23.
 */
class ThreeInOne {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public ThreeInOne(int stackSize) {
        this.stackCapacity = stackSize;
        this.values = new int[stackSize * numberOfStacks];
        this.sizes = new int[numberOfStacks];
        for (int i = 0; i < numberOfStacks; i++) {
            sizes[i] = 0;
        }
    }

    // isFull
    public boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    // isEmpty
    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    // indexOfTop - this is helper method for push, pop and peek methods
    private int indexOfTop(int stackNum) {
        return stackNum * stackCapacity + sizes[stackNum];
    }

    // push
    public void push(int stackNum, int value) {
        if (isFull(stackNum)) {
            System.out.printf("stack %s is full", stackNum);
        } else {
            values[indexOfTop(stackNum)] = value;
            sizes[stackNum] = sizes[stackNum] + 1;
        }
    }

    // pop
    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            return -1;
        } else {
            final int value = values[indexOfTop(stackNum) - 1];
            values[indexOfTop(stackNum) - 1] = -1;
            sizes[stackNum] = sizes[stackNum] - 1;
            return value;
        }
    }

    // peek

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            return -1;
        } else {
            return values[indexOfTop(stackNum) - 1];
        }
    }

}
