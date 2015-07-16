package Queue.DelayQueue;

import java.util.concurrent.Delayed;


import java.util.concurrent.TimeUnit;

public class QueuedElement implements Delayed{

	final String temp;
	public QueuedElement()
	{
		temp=Test.maybe;
	}
	@Override
	public int compareTo(Delayed arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getDelay(TimeUnit arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
