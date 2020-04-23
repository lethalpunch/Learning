package in.xrbia.lambdaExpression;

import java.util.Comparator;
import java.util.function.Function;

public class ComplexFunction {
	public static Function<Employee, String> getInitialLetterFromName() {
		Function<Employee, String> gName = Employee :: getName;
		Function<String, char[]> convertsToArray = String :: toCharArray;
		Function<char[], String> getLetter = (char[] arr) -> ""+arr[0];
		return getLetter.compose(convertsToArray.compose(gName));
	}
	public static void main(String... strings) {
		Employee frank = new Employee("Frank", 1000);
		System.out.println(getInitialLetterFromName().apply(frank));
		
		// Compare lexicographically by name and if name equals then by salary.
		Comparator<Employee> byName = Comparator.comparing(Employee::getName);
		Comparator<Employee> bySalary = Comparator.comparingInt(Employee::getSalary);
		Comparator<Employee> byNamethenSalary = byName.thenComparing(bySalary);
	}
}
