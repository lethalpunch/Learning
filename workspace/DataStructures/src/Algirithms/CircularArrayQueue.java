package Algirithms;

import java.lang.reflect.Array;

public final class  CircularArrayQueue <T>{
private int maxSize=0;
private int frontIndex=-1;
private int rearIndex=-1;
private T[] arr=null;

public CircularArrayQueue (Class <T> clas,int maxSize1)
{
	this.maxSize=maxSize1;
	arr= (T[]) Array.newInstance(clas, maxSize1);
}

public boolean isEmpty()
{
	boolean emptyFlag=false;
	if(frontIndex==-1)
	{
		emptyFlag=true;
	}
	return emptyFlag;
}

public boolean isFull()
{
	boolean filledFlag=false;
	if(((rearIndex+1)%maxSize)==frontIndex)
	{
		filledFlag=true;
	}
	return filledFlag;
}
public void add(T data) throws Exception
{
	if(isFull())
	{
		throw new Exception("OverFlowException : The circular array is full");
	}
	rearIndex=rearIndex+1%maxSize;
	arr[rearIndex]=data;
	if(frontIndex==-1)
	{
		frontIndex=rearIndex;
	}
}

public T dequeue() throws Exception
{
	if(isEmpty())
	{
		throw new Exception("UnderFlowException : The circular array is emplty for dequeue.");
	}
	T  t=arr[frontIndex];
	if(frontIndex==rearIndex)
	{
		frontIndex=rearIndex=-1;
	}
	else
	{	
	frontIndex=frontIndex+1%maxSize;
	}
	return t;
}

public static void main(String...strings) throws Exception
{
	CircularArrayQueue<String> que=new CircularArrayQueue<String>(String.class, 10);
	
	for(int i=0;i<20;i++)
	{
	
		if(i<=9){
		que.add("");		
		}
		else
		{
			que.dequeue();
		}
		System.out.println(i);
	}
}
}
