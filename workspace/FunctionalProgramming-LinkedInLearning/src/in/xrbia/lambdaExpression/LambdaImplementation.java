package in.xrbia.lambdaExpression;

import java.util.function.Consumer;

public class LambdaImplementation {

	public static void main(String[] args) {

		// Anonymous class, multiple instances.
		System.out.println("\nAnonymous Class:");
		for (int i = 0; i < 5; i++) {
			Consumer<String> myPrinter = new Consumer<String>() {
				@Override
				public void accept(String t) {
					System.out.println("Consuming " + t);
				}
			};
			myPrinter.accept(myPrinter.toString());
		}

		// Non-Capturing lambda one instance
		System.out.println("\nNon-capturing lambda:");
		for (int i = 0; i < 5; i++) {
			Consumer<String> myPrinter = msg -> System.out.println("Consuming " + msg);
			myPrinter.accept(myPrinter.toString());
		}

		// Constant capturing lambda, one instance
		System.out.println("\nConstant-capturing lambda:");
		final int secret = 42;
		for (int i = 0; i < 5; i++) {
			Consumer<String> myPointer = msg -> System.out.println("Consuming " + msg + ", " + secret);
			myPointer.accept(myPointer.toString());
		}
		
		new LambdaImplementation().foo();
	}

	private int id = 1;

	public void foo() {
		System.out.println("\nInstance-capturing lambda:");
		for (int i = 0; i < 5; i++) {
			// this-capturing lambda, many instance.
			Consumer<String> myPointer = msg -> System.out.println(msg + ", " + id);
			myPointer.accept(myPointer.toString());
		}
	}

}
