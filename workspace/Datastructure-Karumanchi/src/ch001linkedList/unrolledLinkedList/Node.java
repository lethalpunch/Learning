package ch001linkedList.unrolledLinkedList;

public class Node<T> {
	private Object[] dataArr;
	private Node<T> nextNode;
	private Node<T> previousNode;
	private int numElements;
	public Node(int nodeCapacity) {
		dataArr = new Object[nodeCapacity];
	}
	public T[] getData() {
		return (T[]) dataArr;
	}
	public void setData(T[] data) {
		this.dataArr = data;
	}
	public Node<T> getNextNode() {
		return nextNode;
	}
	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}
	public Node<T> getPreviousNode() {
		return previousNode;
	}
	public void setPreviousNode(Node<T> previousNode) {
		this.previousNode = previousNode;
	}
	public int getNumElements() {
		return numElements;
	}
	public void setNumElements(int numElements) {
		this.numElements = numElements;
	}
	public void addData(T data) {
		if (numElements >= dataArr.length) {
			throw new ArrayIndexOutOfBoundsException();
		}
		this.dataArr[numElements] = data;
		numElements++;
	}
}
