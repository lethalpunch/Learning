package Algirithms;

public class StackUsingQueue {
private CircularArrayQueue<String> mainQueue=new CircularArrayQueue<String>(String.class, 10);
private CircularArrayQueue<String> tempQueue=new CircularArrayQueue<String>(String.class, 10);

public void push(String data) throws Exception{
	mainQueue.add(data);
}

public String pop() throws Exception{
	String data=null;
	while(!mainQueue.isEmpty())
	{
		data=mainQueue.dequeue();
		tempQueue.add(data);
	}
	mainQueue=tempQueue;
	tempQueue=new CircularArrayQueue<String>(String.class, 10);
	return data;
}

}
