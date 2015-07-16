
public class GenericMethod {

	public static void main(String...strings){
	callMethod cm=new callMethod();
	cm.callPrint("ASA");
	}
	
}
class callMethod{
	public  <T> void callPrint(T t)
	{
		System.out.println(t);
		System.out.println(t.hashCode());
	}
}