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
    }
}
