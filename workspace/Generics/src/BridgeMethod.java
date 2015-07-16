
public class BridgeMethod {
public static void main(String...strings)
{
	MyNode mn = new MyNode(5);
	Node n = (MyNode)mn;            // A raw type - compiler throws an unchecked warning
	n.setData(1);     // Causes a ClassCastException to be thrown.
	Integer x = mn.data;
}
}
 class Node<T> {

    public T data;

    public Node(T data) { this.data = data; }

    public void setData(T data) {
        System.out.println("Node.setData");
        this.data = data;
    }
}

 class MyNode extends Node<Integer> {
    public MyNode(Integer data) { super(data); }

    public void setData(Integer data) {
        System.out.println("MyNode.setData");
        super.setData(data);
    }
}
