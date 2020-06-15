package ch002stacks;

import java.util.EmptyStackException;

public class ArrayWithThreeStacks {

    private Integer[] dataArr;
    private int size, topOne, topTwo, topThree, baseThree;
    
    public ArrayWithThreeStacks(int size) {
	if(size < 3) throw new RuntimeException("Size should be greater than 3.");
	dataArr = new Integer[size];
	this.size = size;
	topOne = -1;
	topTwo = size;
	baseThree = size/2;
	topThree = baseThree;
    }
    
    private boolean isStack3RightShiftable() {
	return topThree + 1 < topTwo;
    }
    
    private void shiftStack3ToRight() {
	for (int i = topThree + 1; i >= baseThree + 1; i--) {
	    dataArr[i] = dataArr[i-1];
	}
	dataArr[baseThree++] = null;
	topThree++;
    }
    
    private boolean isStack3LeftShiftable() {
	return topOne + 1 < baseThree;
    }
    
    private void shiftStack3ToLeft() {
	for (int i = baseThree -1 ; i >= topThree -1; i++) {
	    dataArr[i] = dataArr[i+1];
	}
	dataArr[baseThree--] = null;
	topThree--;
    }
    
    public void push(int stackId, int data) {
	if (stackId == 1) {
	    if (topOne + 1 == baseThree) {
		if (isStack3RightShiftable()) {
		    shiftStack3ToRight();
		    dataArr[++topOne] = data;
		} else {
		    throw new StackOverflowError("Stack1 has reached maximum.");
		}
	    } else {
		dataArr[++topOne] = data;
	    }
	} else if (stackId == 2) {
	    if (topTwo - 1 == topThree) {
		if (isStack3LeftShiftable()) {
		    shiftStack3ToLeft();
		    dataArr[--topTwo] = data;
		} else {
		    throw new StackOverflowError("Stack2 has reached maximum.");
		}
	    } else {
		dataArr[--topTwo] = data;
	    }
	} else if (stackId == 3) {
	    if (topTwo - 1 == topThree) {
		if (isStack3LeftShiftable()) {
		    shiftStack3ToLeft();
		    dataArr[++topThree] = data;
		} else {
		    throw new StackOverflowError("Stack3 has reached maximum.");
		}
	    } else {
		dataArr[++topThree] = data;
	    }
	}
    }
    
    public int pop(int stackId) {
	if (stackId == 1) {
	    if (topOne == -1) throw new EmptyStackException();
	    int toPop = dataArr[topOne];
	    dataArr[topOne--] = null;
	    return toPop;
	} else if (stackId == 2) {
	    if (topTwo == size) throw new EmptyStackException();
	    int toPop = dataArr[topTwo];
	    dataArr[topTwo++] = null;
	    return toPop;
	} else if (stackId == 3) {
	    if (topThree == baseThree) throw new EmptyStackException();
	    int toPop = dataArr[topThree];
	    dataArr[topThree--] = null;
	    return toPop;
	}
	throw new RuntimeException(" Wrong stackid");
    }
    
}
