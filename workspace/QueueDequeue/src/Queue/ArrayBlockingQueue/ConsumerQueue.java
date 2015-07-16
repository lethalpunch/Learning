package Queue.ArrayBlockingQueue;

import java.util.concurrent.BlockingQueue;

public class ConsumerQueue extends Thread{
BlockingQueue<String> queue;
 public ConsumerQueue(BlockingQueue<String> queue)
 {
	 this.queue=queue;
 }
@Override
public void run() {
	// TODO Auto-generated method stub
	super.run();
	try {
		while(!queue.isEmpty()){
		String val=queue.take();
		System.out.println(val);
		Thread.sleep(100);
		}
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
 
}
