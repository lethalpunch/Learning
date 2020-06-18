package ch002stacks;

import java.util.Stack;

public class StackUtil {

    public static int evaluateInfixStringInOneGo(String infixString) {
	Stack<Character> operatorStack = new Stack<>();
	Stack<Integer> operandStack = new Stack<>();
	for (int i = 0; i < infixString.length(); i++) {
	    char token = infixString.charAt(i);
	    if (Character.isDigit(token)) {
		String operand = Character.toString(token);
		while (Character.isDigit(infixString.charAt(i + 1))) {
		    operand += infixString.charAt(i++);
		}
		operandStack.push(Integer.parseInt(operand));
	    } else if (operatorStack.isEmpty() || precedence(token) > precedence(operatorStack.peek())) {
		operatorStack.push(token);
	    } else {
		operandStack.push(performBinaryOperation(operandStack.pop(), operandStack.pop(), operatorStack.pop()));
		operatorStack.push(token);
	    }
	}
	while (!operatorStack.isEmpty()) {
	    operandStack.push(performBinaryOperation(operandStack.pop(), operandStack.pop(), operatorStack.pop()));
	}
	return operandStack.pop();
    }

    private static int performBinaryOperation(int secondDigit, int firstDigit, char operation) {
	switch (operation) {
	case '+':
	    return firstDigit + secondDigit;
	case '-':
	    return firstDigit - secondDigit;
	case '*':
	    return firstDigit * secondDigit;
	case '/':
	    return firstDigit / secondDigit;
	default:
	    return 0;
	}
    }

    private static int precedence(char operator) {
	switch (operator) {
	case '+':
	    return 0;
	case '-':
	    return 0;
	case '*':
	    return 2;
	case '/':
	    return 2;
	case '^':
	    return 3;
	default:
	    return -1;
	}
    }
    
    public static void reverseStack(Stack stack) {
	if (stack.isEmpty()) {
	    return;
	}
	Object temp = stack.pop();
	reverseStack(stack);
	insertAtBottom(stack, temp);
    }

    private static void insertAtBottom(Stack stack, Object value) {
	if (stack.isEmpty()) {
	    stack.push(value);
	    return;
	}
	Object temp = stack.pop();
	insertAtBottom(stack, value);
	stack.push(temp);
    }

    public static void main(String... strings) {
	Stack<String> stack = new Stack<>();
	stack.push("A");
	stack.push("B");
	stack.push("C");
	reverseStack(stack);
	System.out.println(stack);
	int[] inputArr = {6,3,2,4,5,2};
	int[] spans = findingSpansBruteForce(inputArr);
	for (Integer i : spans) {
	    System.out.print(i + ", ");
	}
	System.out.println();
	spans = findingSpansUsingStack(inputArr);
	for (Integer i : spans) {
	    System.out.print(i + ", ");
	}
	System.out.println();
	int[] A = { 3, 2, 5, 6, 1, 4, 4 };
	System.out.println("max Area of histograms : " + maxRectangleAreaInHistogram(A));
    }
    
    public static int[] findingSpansBruteForce(int[] inputArray) {
	int[] spans = new int[inputArray.length];
	for (int i = 0; i < inputArray.length; i++) {
	    int span = 1;
	    int j = i - 1;
	    while (j >= 0 && inputArray[j] <= inputArray[i]) {
		span++;
		j--;
	    }
	    spans[i] = span;
	}
	return spans;
    }
    
    public static int[] findingSpansUsingStack(int[] inputArray) {
	int[] spans = new int[inputArray.length];
	Stack<Integer> stack = new Stack<>();
	int p = 0;
	for (int i = 0; i < inputArray.length; i++) {
	    while (!stack.isEmpty() && inputArray[i] > inputArray[stack.peek()]) {
		stack.pop();
	    }
	    if (stack.isEmpty()) {
		p = -1;
	    } else {
		p = stack.peek();
	    }
	    spans[i] = i - p;
	    stack.push(i);
	}
	return spans;
    }
    
    public static int maxRectangleAreaInHistogram(int[] A) {
	Stack<Integer> stack = new Stack<>();
	if (A == null || A.length == 0) {
	    return 0;
	}

	int maxArea = 0;
	int i = 0;
	while (i < A.length) {
	    if (stack.isEmpty() || A[stack.peek()] <= A[i]) {
		stack.push(i++);
	    } else {
		int top = stack.pop();
		maxArea = Math.max(maxArea, A[top] * (stack.isEmpty() ? i : i - stack.peek() - 1));
	    }
	}

	while (!stack.isEmpty()) {
	    int top = stack.pop();
	    maxArea = Math.max(maxArea, A[top] * (stack.isEmpty() ? i : i - stack.peek() - 1));
	}

	return maxArea;
    }
}
