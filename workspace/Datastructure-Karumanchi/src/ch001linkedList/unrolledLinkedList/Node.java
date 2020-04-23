package ch001linkedList.unrolledLinkedList;

public class Node<T> {
	public Object[] dataArr;
	public Node<T> nextNode;
	public Node<T> previousNode;
	public int numElements;
	public Node(int nodeCapacity) {
		dataArr = new Object[nodeCapacity];
	}
}
