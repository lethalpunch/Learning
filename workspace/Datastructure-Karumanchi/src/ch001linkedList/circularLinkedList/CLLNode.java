package ch001linkedList.circularLinkedList;

public class CLLNode<T> {
	private T data;
	private CLLNode<T> nextNode;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public CLLNode<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(CLLNode<T> nextNode) {
		this.nextNode = nextNode;
	}

}
