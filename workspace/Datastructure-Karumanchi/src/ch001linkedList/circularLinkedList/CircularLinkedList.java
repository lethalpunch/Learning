package ch001linkedList.circularLinkedList;

public class CircularLinkedList<T> {
	private CLLNode<T> tail;

	public int size() {
		int size = 0;
		if (tail == null) {
			return size;
		}
		CLLNode<T> node = tail.getNextNode();
		size++;
		while (node != tail) {
			node = node.getNextNode();
			size++;
		}
		return size;
	}

	public void insertFirst(T data) {
		CLLNode<T> newNode = new CLLNode<>();
		newNode.setData(data);
		if (tail != null) {
			newNode.setNextNode(tail.getNextNode());
			tail.setNextNode(newNode);
		} else {
			newNode.setNextNode(newNode);
			tail = newNode;
		}
	}

	public void insertLast(T data) {
		CLLNode<T> newNode = new CLLNode<>();
		newNode.setData(data);
		newNode.setNextNode(newNode);
		if (tail != null) {
			newNode.setNextNode(tail.getNextNode());
			tail.setNextNode(newNode);
		}
		tail = newNode;
	}

	public void insertAt(T data, int index) {
		CLLNode<T> newNode = new CLLNode<>();
		newNode.setData(data);
		CLLNode<T> prevIndexNode = getAt(index - 1);
		if (prevIndexNode == null) {
			throw new ArrayIndexOutOfBoundsException();
		}
		newNode.setNextNode(prevIndexNode.getNextNode());
		prevIndexNode.setNextNode(newNode);
		if (prevIndexNode == tail) {
			tail = newNode;
		}
	}

	public void removeFromTail() {
		if (tail == null) {
			return;
		}
		CLLNode<T> node = tail.getNextNode();
		while (node.getNextNode() != tail) {
			node = node.getNextNode();
		}
		if (node == tail) {
			tail = null;
		} else {
			node.setNextNode(tail.getNextNode());
			tail = node;
		}
	}

	public void removeFromHead() {
		if (tail == null) {
			return;
		}
		if (tail == tail.getNextNode()) {
			tail = null;
			return;
		}
		tail.setNextNode(tail.getNextNode().getNextNode());
	}

	public void removeAt(int index) {
		CLLNode<T> prevIndexNode = getAt(index - 1);
		if (prevIndexNode == tail) {
			return;
		}
		CLLNode<T> tempNode = prevIndexNode.getNextNode();
		prevIndexNode.setNextNode(tempNode.getNextNode());
		if (tempNode == tail) {
			tail = prevIndexNode;
		}
	}

	public int indexOf(T data) {
		if (tail == null) {
			return -1;
		}
		int position = 0;
		CLLNode<T> node = tail.getNextNode();
		while (node.getData().equals(data) || node == tail) {
			node = node.getNextNode();
			position++;
		}
		if (node == tail && !node.getData().equals(data)) {
			return -1;
		}
		return position;
	}

	public CLLNode<T> getAt(int index) {
		if (tail == null || index < 0) {
			return null;
		}
		CLLNode<T> node = tail;
		for (int i = 0; i <= index; i++) {
			node = node.getNextNode();
			if (node == tail && i != index) {
				return null;
			}
		}
		return node;
	}
}
