package ch006Trees.binaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeUtil {

	public static void preorderTraversalViaRecursion(BinaryTreeNode node) {
		if (node != null) {
			System.out.println(node.data);
			preorderTraversalViaRecursion(node.left);
			preorderTraversalViaRecursion(node.right);
		}
	}

	public static List<Integer> preorderTraversalViaIteration(BinaryTreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<BinaryTreeNode> nodeStack = new Stack<>();
		nodeStack.push(root);
		while (!nodeStack.isEmpty()) {
			BinaryTreeNode node = nodeStack.pop();
			result.add(node.data);
			if (node.right != null) {
				nodeStack.push(node.right);
			}
			if (node.left != null) {
				nodeStack.push(node.left);
			}
		}
		return result;
	}

	public static void inorderTraversalViaRecursion(BinaryTreeNode node) {
		if (node != null) {
			inorderTraversalViaRecursion(node.left);
			System.out.println(node.data);
			inorderTraversalViaRecursion(node.right);
		}
	}
	
	public static List<Integer> inorderTraversalViaIteration(BinaryTreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<BinaryTreeNode> nodeStack = new Stack<>();
		BinaryTreeNode currentNode = root;
		boolean done = false;
		while (!done) {
			if (currentNode != null) {
				nodeStack.push(currentNode);
				currentNode = currentNode.left;
			} else {
				if (nodeStack.isEmpty()) {
					done = true;
				} else {
					currentNode = nodeStack.pop();
					result.add(currentNode.data);
					currentNode = currentNode.right;
				}
			}
		}
		return result;
	}
	
	public static void postorderTraversalViaRecursion(BinaryTreeNode node) {
		if (node != null) {
			postorderTraversalViaRecursion(node.left);
			postorderTraversalViaRecursion(node.right);
			System.out.println(node.data);
		}
	}
	
	public static List<Integer> postorderTraversalViaIteration(BinaryTreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<BinaryTreeNode> s = new Stack<>();
		s.push(root);
		BinaryTreeNode prev = null;
		while (!s.isEmpty()) {
			BinaryTreeNode curr = s.peek();
			if (prev == null || prev.left == curr || prev.right == curr) {
				if (curr.left != null) {
					s.push(curr.left);
				} else if (curr.right != null) {
					s.push(curr.right);
				}
			} else if (curr.left == prev) {
				if (curr.right != null) {
					s.push(curr.right);
				}
			} else {
				result.add(curr.data);
				s.pop();
			}
			prev = curr;
		}
		return result;
	}
	
	public static List<Integer> levelOrderTraversal(BinaryTreeNode root) {
		List<Integer> result  = new ArrayList<>();
		LinkedList<BinaryTreeNode> ll = new LinkedList<>();
		ll.offer(root);
		while(!ll.isEmpty()) {
			BinaryTreeNode curr = ll.poll();
			result.add(curr.data);
			if (curr.left != null) {
				ll.offer(curr.left);
			}
			if (curr.right != null) {
				ll.offer(curr.right);
			}
		}
		return result;
	}
	
	public static void main(String...strings) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		List<Integer> rs = levelOrderTraversal(root);
		System.out.println(rs);
		System.out.println(minimumHeightViaRecursion(root));
	}
	
	public static int sizeViaRecursion(BinaryTreeNode root) {
		int lSize = root.left == null ? 0 : sizeViaRecursion(root.left);
		int rSize = root.right == null ? 0 : sizeViaRecursion(root.right);
		return lSize + rSize + 1;
	}
	
	public static int sizeViaIteration(BinaryTreeNode node) {
		int size = 0;
		if (node == null) {
			return size;
		}
		Queue<BinaryTreeNode> llQueue = new LinkedList<>();
		llQueue.offer(node);
		while (!llQueue.isEmpty()) {
			BinaryTreeNode curr = llQueue.poll();
			size++;
			if (curr.left != null) {
				llQueue.offer(curr.left);
			}
			if (curr.right != null) {
				llQueue.offer(curr.right);
			}
		}
		return size;
	}
	
	public static int heightViaRecursion(BinaryTreeNode node) {
		if (node == null) {
			return 0;
		}
		int lHeight = heightViaRecursion(node.left);
		int rHeight = heightViaRecursion(node.right);
		return Math.max(lHeight, rHeight) + 1;
	}
	
	public static int heightViaIteration(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		Stack<BinaryTreeNode> s = new Stack<>();
		s.push(root);
		int height = 0;
		BinaryTreeNode prev = null;
		while (!s.isEmpty()) {
			BinaryTreeNode curr = s.pop();
			if (prev == null || prev.left == curr || prev.right == curr) {
				if (curr.left != null) {
					s.push(curr.left);
				}
				if (curr.right != null) {
					s.push(curr.right);
				}
			} else if (curr.left == prev) {
				if (curr.right != null) {
					s.push(curr.right);
				}
			} else {
				s.pop();
			}
			height = Math.max(s.size(), height);
		}
		return height;
	}
	public static int minimumHeightViaRecursion(BinaryTreeNode root) {
		return minimumHeight(root) - 1;
	}
	public static int minimumHeight(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		int lHeight = minimumHeight(root.left);
		int rHeight = minimumHeight(root.right);
		return Math.min(lHeight, rHeight) + 1;
	}
	
	public static int minimumHeightViaIteration(BinaryTreeNode root) {
		int height = 0;
		if (root != null) {
			Queue<BinaryTreeNode> queue = new LinkedList<>();
			
			
		}
		return height;
	}
	

}
