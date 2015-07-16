package Tree.BinaryTree;

import java.util.Stack;

import Tree.BinaryTreeNode;

public class PreorderialTraversal {
public void printAllNodeRecursively(BinaryTreeNode root)
{
	if(root!=null){
	System.out.println(root.data);
	this.printAllNodeRecursively(root.leftNode);
	this.printAllNodeRecursively(root.rightNode);
	}
}

public void printAllNodeViaStack(BinaryTreeNode root)
{
Stack<BinaryTreeNode> stack=new Stack<BinaryTreeNode>();
while(true)
{
	if(root!=null)
	{
		stack.push(root);
		root=root.leftNode;
	}
	
	if(stack.isEmpty())
	{
		break;
	}
	root=stack.pop();
	System.out.println(root.data);
		if(root.rightNode!=null)
		{
			stack.push(root.rightNode);
		}
	
	
}
}



public static void main(String...strings)
{
	BinaryTreeNode btn=new BinaryTreeNode();
	btn.data="Data";
		BinaryTreeNode bt=new BinaryTreeNode();
		BinaryTreeNode bt2=new BinaryTreeNode();
		bt.data="L"+1;
		bt2.data="R"+1;
		btn.leftNode=bt;
		btn.rightNode=bt2;
		
		PreorderialTraversal pt=new PreorderialTraversal();
		pt.printAllNodeViaStack(btn);
}
}
