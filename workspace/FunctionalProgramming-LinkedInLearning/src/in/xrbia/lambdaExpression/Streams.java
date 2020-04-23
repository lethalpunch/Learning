package in.xrbia.lambdaExpression;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {
		Employee[] emps = {new Employee("A", 1000), new Employee("B",1200), new Employee("C", 1300)};
		// Print the names of employee with salary atleast 2500 in alphabatical order.
		Arrays.asList(emps).stream().filter(emp -> emp.getSalary() > 1100).map(Employee::getName).sorted()
				.forEach(System.out::println);
		
		Employee[] lowEmps = Stream.of(emps).filter(e ->e.getSalary() < 2000).map(emp -> {
			emp.setName("D");
			return emp;
		}).toArray(Employee[]::new);
				//.toArray();
		
		Stream.of(lowEmps).map(Employee::getName).forEach(System.out::println);
	}

}
