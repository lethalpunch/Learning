package test;

import java.util.ArrayList;
import java.util.concurrent.Exchanger;

public class DataCreatorThread extends Thread{
	int count=0;
	ArrayList<Integer> bufferList;
	Exchanger<ArrayList<Integer>> exchanger;
	
	public DataCreatorThread(ArrayList<Integer> bufferList,Exchanger<ArrayList<Integer>> exchanger)
	{
		this.bufferList=bufferList;
		this.exchanger=exchanger;
	}

	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int c=0;c<5;c++){
		try {
			Thread.sleep(400);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		for(int i=0;i<10;i++)
		{
			this.bufferList.add(count++);
		}
		try {
			Thread.sleep(1000);
			this.bufferList=this.exchanger.exchange(this.bufferList);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
