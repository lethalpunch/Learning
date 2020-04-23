package in.xrbia.lambdaExpression;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReduceAndCollect {

	public static void main(String[] args) {

		// Concatenate strings

		List<String> stringList = Arrays.asList("A", "B", "C");

		StringBuilder summary = stringList.stream().collect(StringBuilder::new,
				StringBuilder::append, StringBuilder::append);

		String summary1 = stringList.stream().collect(Collectors.joining());

		StringBuilder summary2 = stringList.stream().collect(
				() -> new StringBuilder(),
				(StringBuilder builder, String s) -> builder.append(s),
				(StringBuilder builder1, StringBuilder builder2) -> builder1
						.append(builder2));

		Stream<Employee> emps = null;

		TreeSet<Employee> tree = emps
				.collect(Collectors.toCollection(() -> new TreeSet<Employee>(
						Comparator.comparingInt(Employee::getSalary))));

	}

}
