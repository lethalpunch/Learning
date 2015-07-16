package test;

import java.util.ArrayList;
import java.util.concurrent.Exchanger;

public class DataPrinterThread extends Thread {
	ArrayList<Integer> bufferList;
	Exchanger<ArrayList<Integer>> exchanger;
	public DataPrinterThread(ArrayList<Integer> bufferList,Exchanger<ArrayList<Integer>> exchanger)
	{
		this.bufferList=bufferList;
		this.exchanger=exchanger;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int c=0;c<5;c++){
			this.bufferList.add(1115);
		try {
			this.bufferList=exchanger.exchange(bufferList);
			Thread.sleep(1500);
			for(int i=0;i<this.bufferList.size();i++)
			{
				System.out.println(this.bufferList.get(i));
			}
			System.out.println("Print End ::"+c);
			this.bufferList.clear();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
}
