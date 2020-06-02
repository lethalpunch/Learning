package ch002stacks;

public class DynamicArrayStack {
	private int[] stackRep;
	private int top = -1;
	
	public DynamicArrayStack() {
		this(16);
	}
	
	public DynamicArrayStack(int capacity) {
		stackRep = new int[capacity];
	}
	
	public int size() {
		return top +1;
	}
	
	public boolean isEmpty() {
		return top < 0;
	}
	
	private void expand() {
		int length = size();
		int[] newStackRep = new int[length << 1];
		System.arraycopy(stackRep, 0, newStackRep, 0, size());
		stackRep = newStackRep;
	}
	
	public void push(int data) {
		if (size() == stackRep.length) {
			expand();
		}
		stackRep[++top] = data;
	}
	
	public int pop() throws Exception {
		if(isEmpty()) {
			throw new Exception("Stack is empty");
		}
		int data = stackRep[top];
		stackRep[top--] = Integer.MIN_VALUE;
		return data;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		if (size() > 0) {
			for (Integer data : stackRep) {
				sb.append(data).append(",");
			}
			sb.substring(0, sb.length() - 1);
		}
		sb.append("]");
		return sb.toString();
	}

}
