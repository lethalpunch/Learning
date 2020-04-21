package ch001linkedList.unrolledLinkedList;

import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.ListIterator;

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
		this(16);
	}

	public UnrolledLinkedList(int capacity) {
		nodeCapacity = capacity;
		firstNode = new Node<>(capacity);
		lastNode = firstNode;
	}

	@Override
	public T get(int index) {
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	private class ULLIterator implements ListIterator<T> {
		Node<T> currentNode;
		int pointer;
		int index;
		private int expectedModCount = modCount;
		@Override
		public boolean hasNext() {
			return index < size - 1;
		}

		@Override
		public T next() {
			pointer++;
			if(pointer < currentNode.getNumElements()) {
				index++;
			}
			return null;
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T previous() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

		@Override
		public void set(T e) {
			// TODO Auto-generated method stub

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
}