package ch001linkedList.doublyLinkedList;

public class ListNode<T> {
	private T data;
	private ListNode<T> prevNode;
	private ListNode<T> nextNode;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public ListNode<T> getPrevNode() {
		return prevNode;
	}
	public void setPrevNode(ListNode<T> prevNode) {
		this.prevNode = prevNode;
	}
	public ListNode<T> getNextNode() {
		return nextNode;
	}
	public void setNextNode(ListNode<T> nextNode) {
		this.nextNode = nextNode;
	}
}
