package test;

import java.util.concurrent.Semaphore;

public class LimitStringObject {
private final Semaphore semaphore;
private StringBuffer[] bufferArr;
private boolean[] bufferStatus;
public LimitStringObject(int limit)
{
	semaphore=new Semaphore(limit);
	bufferArr=new StringBuffer[limit];
	bufferStatus=new boolean[limit];
	for(int i=0;i<bufferArr.length;i++)
	{
		bufferArr[i]=new StringBuffer();
		bufferStatus[i]=false;
	}
}

public StringBuffer acquireBufferObject() throws InterruptedException
{
	semaphore.acquire();
	/*semaphore.tryAcquire();*/
	StringBuffer tempBuffer=null;
	for(int i=0;i<bufferStatus.length;i++)
	{
		if(!bufferStatus[i])
		{
			tempBuffer=bufferArr[i];
			bufferStatus[i]=true;
			break;
		}
	}
	return tempBuffer;
}



public void releaseBufferObject(StringBuffer obj)
{
	boolean releaseFlag=false;
	for(int i=0;i<bufferStatus.length;i++)
	{
		if(bufferArr[i].equals(obj))
		{
			bufferStatus[i]=false;
			releaseFlag=true;
			break;
		}
	}
	if(releaseFlag)
	{
		semaphore.release();
	}
}
}
