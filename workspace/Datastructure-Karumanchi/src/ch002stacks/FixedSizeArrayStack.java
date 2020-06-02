package ch002stacks;

public class FixedSizeArrayStack {
	private int[] stackRep;
	private int top = -1;

	public FixedSizeArrayStack() {
		this(10);
	}

	public FixedSizeArrayStack(int capacity) {
		stackRep = new int[capacity];
	}

	public int size() {
		return top + 1;
	}

	public boolean isEmpty() {
		return top < 0;
	}

	public void push(int data) throws Exception {
		if (size() == stackRep.length) {
			throw new Exception("Stack is full");
		}
		stackRep[++top] = data;
	}

	public int pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is empty.");
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

	public static void main(String... strings) throws Exception {
		FixedSizeArrayStack stck = new FixedSizeArrayStack(2);
		stck.push(1);
		stck.push(2);
		stck.push(2);
		System.out.println(stck.toString());
		System.out.println(stck.pop());
		System.out.println(stck.pop());
		System.out.println(stck.pop());
	}

}
