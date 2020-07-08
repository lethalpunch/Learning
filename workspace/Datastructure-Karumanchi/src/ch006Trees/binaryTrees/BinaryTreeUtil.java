package ch006Trees.binaryTrees;

import java.util.ArrayList;
import java.util.List;
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
	
	public static void main(String...strings) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		List<Integer> rs = postorderTraversalViaIteration(root);
		postorderTraversalViaRecursion(root);
	}

}
