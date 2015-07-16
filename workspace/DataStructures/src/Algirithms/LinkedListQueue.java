package Algirithms;

public class LinkedListQueue<T> {
private ListNode<T> frontNode=null;
private ListNode<T> rearNode=null;

public LinkedListQueue(){
	frontNode=new ListNode<T>();
	rearNode=frontNode;
}

public void add(T data){
	ListNode<T> tempNode=new ListNode<T>();
	tempNode.data=data;
	rearNode.nextData=tempNode;
	rearNode=tempNode;
}

public T dequeue(){
	T data=frontNode.data;
	ListNode<T> tempNode=frontNode.nextData;
	frontNode=tempNode;
	return data;
}

}
class ListNode<T>{
	T data=null;
	ListNode nextData=null;
}
