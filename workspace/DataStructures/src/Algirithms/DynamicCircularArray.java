package Algirithms;

public class DynamicCircularArray <T>{
	
	private int frontIndex,rearIndex=-1;
	private int maxSize=10;
	private Object[] arr=null;
	
	public DynamicCircularArray(){
		arr=new Object[maxSize];
	}

	public boolean isEmpty(){
		boolean emptyFlag=false;
		if(frontIndex==-1)
		{
			emptyFlag=true;
		}
		return emptyFlag;
	}
	
	public boolean isFull(){	
		boolean filledFlag=false;
		if(rearIndex+1%maxSize==frontIndex)
		{
			filledFlag=true;
		}
		return filledFlag;
	}
	
	public void resizeQueue() {// this method is called by enqueue method if the circular array is full to reassign it to size increased new array.
		maxSize=maxSize*2;
		Object[] tempArr=new Object[maxSize];
		if(rearIndex>frontIndex)
		{
			for(int i=0;i<arr.length;i++)
			{
				tempArr[i]=arr[i];
			}
		}
		else
		{
			int count=0;
			for(int i=frontIndex;i<arr.length;i++)
			{
				tempArr[count]=arr[i];
				count++;
			}
			for (int i=0;i<=rearIndex;i++)
			{
				tempArr[count]=arr[i];
				count++;
			}
		}
		
		arr=tempArr;
	}
	
	/**
	 * Rest of the functionalities will be similar as Circular Array Implementation.
	 */
}
