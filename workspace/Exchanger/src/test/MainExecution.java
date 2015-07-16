package test;

import java.util.ArrayList;
import java.util.concurrent.Exchanger;

public class MainExecution {
public static void main(String...strings )
{
	ArrayList<Integer> bL=new ArrayList<Integer>();
	ArrayList<Integer> bL2=new ArrayList<Integer>();
	Exchanger<ArrayList<Integer>> exchanger=new Exchanger<ArrayList<Integer>>();
	DataCreatorThread dct=new DataCreatorThread(bL, exchanger);
	DataPrinterThread dpt=new DataPrinterThread(bL2, exchanger);
	//TestExtraExchanger tee=new TestExtraExchanger(bL, exchanger);
	dct.start();
	dpt.start();
	//tee.start();
}
	
}
