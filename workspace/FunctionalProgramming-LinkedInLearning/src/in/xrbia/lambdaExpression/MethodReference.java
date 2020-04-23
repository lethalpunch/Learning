package in.xrbia.lambdaExpression;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReference {
	interface ThreadSupplier {
		Thread giveMeAThread();
	}

	public static void main(String... strings) {

		// Static method
		Supplier<Thread> s1 = Thread::currentThread;

		// Nothiing special about 'Supplier'
		ThreadSupplier ts = Thread::currentThread;
		System.out.println(ts.giveMeAThread());

		// Instance Method reference (instance specified)
		Employee frank = new Employee();frank.setSalary(1000);
		Integer i = frank.getSalary();
		Supplier<Integer> s2 = frank::getSalary;

		System.out.println(s2.get());

		// A common instance method (instance specified)
		Consumer<String> c1 = System.out::println;

		// An instance method (instance not specified)
		Function<Employee, Integer> f1 = Employee::getSalary;

		Integer frankSalary = f1.apply(frank);

		// A useful application: building a comparator based on a field

		// comparing expects Function<Employee, U>
		// where U supports natural ordering (i.e., Comparable)

		Comparator<Employee> byName = Comparator.comparing(Employee::getName);
		
		Employee dept[] = new Employee[5];
		dept[0] = new Employee("Alec", 1500);
		dept[1] = new Employee("Bob", 1600);
		dept[2] = new Employee("Claire", 1700);
		dept[3] = new Employee("Danielle", 1800);
		dept[4] = new Employee("Ethan", 1900);
		
		printAll(dept, Employee::getName);
		printAll(dept, emp -> "" + emp.getSalary());
	}
	
	public static <T> void printAll(T[] array, Function<T, String> toStringFn) {
		int i = 0;
		for (T t : array) {
			System.out.println(i++ + ":\t" + toStringFn.apply(t));
		}
	}
}
