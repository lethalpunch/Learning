package ch002stacks;

public class LinkedListStack {
	public class ListNode {
		int data;
		ListNode nextNode;
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public ListNode getNextNode() {
			return nextNode;
		}
		public void setNextNode(ListNode nextNode) {
			this.nextNode = nextNode;
		}
	}
	
	private int length;
	private ListNode top;
	
	public LinkedListStack() {
		length = 0;
		top = null;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public int size() {
		return length;
	}
	
	public void push(int data) {
		ListNode tempNode = new ListNode();
		tempNode.data = data;
		tempNode.nextNode = top;
		top = tempNode;
		length++;
	}
	
	public int pop() throws Exception{
		if (top == null) {
			throw new Exception("Stack is empty");
		}
		int result = top.getData();
		top = top.nextNode;
		length--;
		return result;
	}

}
