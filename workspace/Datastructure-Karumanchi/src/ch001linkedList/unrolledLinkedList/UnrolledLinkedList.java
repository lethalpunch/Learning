package ch001linkedList.unrolledLinkedList;

import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class UnrolledLinkedList<T> extends AbstractList<T> implements List<T> {
	/**
	 * The maximum number of elements that can be stored in a single node.
	 */
	private int nodeCapacity;
	/**
	 * The current size of the list.
	 */
	private int size;

	private Node<T> firstNode;

	private Node<T> lastNode;

	private int modCount;

	public UnrolledLinkedList() {
		this(9);
	}

	public UnrolledLinkedList(int capacity) {
		if (capacity < 8) {
			capacity = 9;
		}
		nodeCapacity = capacity;
		firstNode = new Node<>(capacity);
		lastNode = firstNode;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		Node<T> node = null;
		int p = 0;
		if (size - index > index) {
			node = firstNode;
			while (p <= index - node.numElements) {
				node = node.nextNode;
				p += node.numElements;
			}
		} else {
			node = lastNode;
			p = size;
			while (p - node.numElements - index > 0) {
				node = node.previousNode;
				p -= node.numElements;
			}
		}
		return (T) node.dataArr[index - p];
	}
	
	public T set(int index, T element) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		Node<T> node = null;
		int p = 0;
		if (size - index > index) {
			node = firstNode;
			while (p <= index - node.numElements) {
				node = node.nextNode;
				p += node.numElements;
			}
		} else {
			node = lastNode;
			p = size;
			while (p - node.numElements - index > 0) {
				node = node.previousNode;
				p -= node.numElements;
			}
		}
		Object el = node.dataArr[index - p];
		node.dataArr[index - p] = element;
		return el != null ? (T) el : null;
	}
	
	public Iterator<T> iterator() {
		return new ULLIterator(firstNode,0,0);
	}

	@Override
	public int size() {
		return size;
	}
	
	public boolean add(T el) {
		insertIntoNode(lastNode, lastNode.numElements, el);
		return true;
	}
	
	public boolean remove(Object o) {
		Node<T> node = firstNode;
		while (node != null) {
			for (int ptr = 0; ptr < node.numElements; ptr++) {
				if ((node.dataArr[ptr] == null && o == null)
						|| o.equals(node.dataArr[ptr])) {
					removeFromNode(node, ptr);
					return true;
				}
			}
			node = node.nextNode;
		}
		return false;
	}
	public void clear() {
		Node<T> node = firstNode.nextNode;
		while(node != null) {
			Node<T> next = node.nextNode;
			node.nextNode = null;
			node.previousNode = null;
			node.dataArr = null;
			node = next;
		}
		lastNode = firstNode;
		for (int ptr = 0; ptr < firstNode.numElements; ptr ++) {
			firstNode.dataArr[ptr] = null;
		}
		firstNode.numElements = 0;
		firstNode.nextNode = null;
		size = 0;
	}
	
	// Insert the specified element at the specified position in this list.
	// Shifts the element currently at that position(if any) and any subsequent
	// elements to the right (adds one to their indices).
	public void add(int index, T element) throws IndexOutOfBoundsException{
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		Node<T> node;
		int p = 0;
		if (size - index > index) {
			node = firstNode;
			while (p <= index - node.numElements) {
				node = node.nextNode;
				p += node.numElements;
			}
		} else {
			node = lastNode;
			p = size;
			while (p - node.numElements - index > 0) {
				node = node.previousNode;
				p -= node.numElements;
			}
		}
		insertIntoNode(node, index - p, element);
	}
	

	private class ULLIterator implements ListIterator<T> {
		Node<T> currentNode;
		int pointer;
		int index;
		private int expectedModCount = modCount;
		
		public ULLIterator(Node<T> node, int pointer, int index) {
			this.currentNode = node;
			this.pointer = pointer;
			this.index = index;
		}
		@Override
		public boolean hasNext() {
			return index < size - 1;
		}

		@Override
		public T next() {
			pointer++;
			if (pointer >= currentNode.numElements) {
				if (currentNode.nextNode != null) {
					currentNode = currentNode.nextNode;
					pointer = 0;
				} else {
					throw new NoSuchElementException();
				}
			}
			index++;
			checkForModification();
			return (T) currentNode.dataArr[pointer];
		}

		@Override
		public boolean hasPrevious() {
			return index > 0;
		}

		@Override
		public T previous() {
			pointer--;
			if (pointer < 0) {
				if (currentNode.previousNode != null) {
					currentNode = currentNode.previousNode;
					pointer = currentNode.numElements - 1;
				} else {
					throw new NoSuchElementException();
				}
			}
			index--;
			checkForModification();
			return (T) currentNode.dataArr[pointer];
		}

		@Override
		public int nextIndex() {
			return index + 1;
		}

		@Override
		public int previousIndex() {
			return index - 1;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

		@Override
		public void set(T e) {
			checkForModification();
			currentNode.dataArr[pointer] = e;
		}

		@Override
		public void add(T e) {
			// TODO Auto-generated method stub

		}
		
		private void checkForModification() {
			if (modCount != expectedModCount) {
				throw new ConcurrentModificationException();
			}
		}
	}
	
	private void insertIntoNode(Node<T> node, int ptr, T element) {

		// if the node is full
		if (node.numElements == nodeCapacity) {
			// create new node
			Node<T> newNode = new Node<>(nodeCapacity);
			// move half of the elements in the new node.
			int elementsToMove = nodeCapacity / 2;
			int startIndex = nodeCapacity - elementsToMove;
			for (int i = 0; i < elementsToMove; i++) {
				newNode.dataArr[i] = node.dataArr[startIndex + i];
				node.dataArr[startIndex + i] = null;
				node.numElements--;
				newNode.numElements++;
			}

			// insert the new Node
			newNode.nextNode = node.nextNode;
			newNode.previousNode = node;
			if (node.nextNode != null) {
				node.nextNode.previousNode = newNode;
			}
			node.nextNode = newNode;
			if (node == lastNode) {
				lastNode = newNode;
			}

			// Check whether the elements will be inserted in the new node or
			// current node.
			if (ptr > node.numElements) {
				node = newNode;
				ptr = ptr - node.numElements - 1;
			}
		}

		for (int i = node.numElements; i > ptr; i--) {
			node.dataArr[i] = node.dataArr[i - 1];
		}
		node.dataArr[ptr] = element;
		node.numElements++;
		size++;
		modCount++;
	}
	
	private void removeFromNode(Node<T> node, int ptr) {
		node.numElements--;
		for (int i = ptr; i < node.numElements; i++) {
			node.dataArr[i] = node.dataArr[i + 1];
		}
		node.dataArr[node.numElements] = null;
		if (node.nextNode != null && node.nextNode.numElements
				+ node.numElements <= nodeCapacity) {
			mergeWithNextNode(node);
		} else if (node.previousNode != null && node.previousNode.numElements
				+ node.numElements <= nodeCapacity) {
			mergeWithNextNode(node.previousNode);
		}
		size--;
		modCount++;
	}

	private void mergeWithNextNode(Node<T> node) {
		Node<T> next = node.nextNode;
		for(int i = 0; i<next.numElements; i++) {
			node.dataArr[node.numElements + i] = next.dataArr[i];
			next.dataArr[i] = null;
		}
		node.numElements+=next.numElements;
		if (next.nextNode != null) {
			next.nextNode.previousNode = node;
		}
		node.nextNode = next.nextNode;
		if (next == lastNode) {
			lastNode = node;
		}
	}
	
}