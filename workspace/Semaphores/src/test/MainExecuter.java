package test;

public class MainExecuter {
public static void main(String arg[])
{
	final LimitStringObject lso=new LimitStringObject(2);
	for(int i=0;i<40;i++)
	{
		
		Runnable r=new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				try {
					StringBuffer bufferStr=lso.acquireBufferObject();
					if(bufferStr!=null)
					{
					bufferStr.append("THREAD ACCESSING ");
					Thread.sleep(100);
					System.out.println(bufferStr);
					lso.releaseBufferObject(bufferStr);
					}
					else{
						System.out.println("didntFound");
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Thread th=new Thread(r);
		th.start();
	}
}
}
