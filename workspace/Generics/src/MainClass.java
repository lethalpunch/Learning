import java.util.ArrayList;


class MainClass<T> {
T t;
public MainClass(T t)
{
	this.t=t;
}
public void printT()
{
System.out.println(this.t);	
}
public static void main(String...strings)
{
	String[] tA={"anit","ranjav"};
	ArrayList<String> listr=new ArrayList<String>();
	listr.add("asa");
	listr.add("fsa");
	System.out.println(listr);
/*	MainClass<Integer> intClass=new MainClass<Integer>(1);
	MainClass<String> strClass=new MainClass<String>("String");
	intClass.printT();
	strClass.printT();*/
}
}
