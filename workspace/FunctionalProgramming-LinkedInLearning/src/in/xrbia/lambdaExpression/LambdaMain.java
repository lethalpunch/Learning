package in.xrbia.lambdaExpression;

import java.util.Comparator;

public class LambdaMain {
	public static void main(String... strings) {
		Comparator<String> byLength = (String a, String b) -> {
			return a.length() - b.length();
		};

		Comparator<Employee> byName = new Comparator<Employee>() {
			@Override
			public int compare(Employee a, Employee b) {
				return a.getName().compareTo(b.getName());
			}
		};

		// First lambda expression
		Comparator<Employee> byNamelambda1 = (Employee a, Employee b) -> {
			return a.getName().compareTo(b.getName());
		};

		// Removing parameter type.
		Comparator<Employee> byNamelambda2 = (a, b) -> {
			return a.getName().compareTo(b.getName());
		};

		// Removing braces and 'return'
		Comparator<Employee> byNamelambda3 = (a, b) -> a.getName()
				.compareTo(b.getName());
		
		
		Runnable r = () -> System.out.println("A compact runnable");
		Thread t1 = new Thread(r);
		t1.start();
		
		Thread t2 = new Thread(() ->  System.out.print("super compact"));
		t2.start();
		
	}
}
