package Queue.ArrayBlockingQueue;

import java.util.concurrent.BlockingQueue;

public class ProducerThread extends Thread{
BlockingQueue<String> queue;
int count=1;
public ProducerThread(BlockingQueue<String> queue)
{
	this.queue=queue;
}
@Override
public void run() {
	// TODO Auto-generated method stub
	super.run();
	while(count%10!=0){		
	try {
		queue.put("MY ELEMENT ::"+count);
		count++;
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}

}
