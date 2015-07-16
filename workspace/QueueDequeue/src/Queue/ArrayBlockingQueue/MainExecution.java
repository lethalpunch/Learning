package Queue.ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MainExecution {

public static void main(String...strings) throws InterruptedException{
BlockingQueue<String> queue=new ArrayBlockingQueue<String>(2);
ConsumerQueue cq=new ConsumerQueue(queue);
ProducerThread pt=new ProducerThread(queue);
pt.start();
Thread.sleep(100);
cq.start();
}


}
