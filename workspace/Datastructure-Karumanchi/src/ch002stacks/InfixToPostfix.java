package ch002stacks;

import java.util.Stack;

public class InfixToPostfix {
    private String postFixString;
    private Stack<Character> operatorStack;

    public InfixToPostfix() {
	postFixString = "";
	operatorStack = new Stack<>();
    }

    /**
     * <pre>
     *  For each character <code>t</code> in the input stream
     *    <code>if(t is an operand) output t.</code>
     *    <code>else if(t is right parenthesis)</code>
     *    		pop and output the tokens until a left
     *    		parenthesis is popped but not output.
     *    <code>else</code> //t is an operator or left parenthesis
     *    		Pop and output tokens until one of lower
     *    		priority than t is encountered or a left
     *    		parenthesis is encountered or the 
     *    		stack is empty.
     *    		Push t
     *    
     *    Pop and output the tokens until the stack is empty.
     * </pre>
     * 
     * @param tokenStr
     */
    private void infixToPostfixConverter(String tokenStr) {
	for (int i = 0; i < tokenStr.length(); i++) {
	    char token = tokenStr.charAt(i);
	    if (isAnOperand(token)) {
		postFixString += token;
	    } else if (token == '(') {
		operatorStack.push(token);
	    } else if (token == ')') {
		while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
		    postFixString += operatorStack.pop();
		}
		operatorStack.pop(); // removing the '(' from stack
	    } else {
		while (!operatorStack.isEmpty() && precedence(token) <= precedence(operatorStack.peek())) {
		    postFixString += operatorStack.pop();
		}
		operatorStack.push(token);
	    }
	}
	while (!operatorStack.isEmpty()) {
	    postFixString += operatorStack.pop();
	}
    }

    public String getPostFixString(String infixString) {
	infixToPostfixConverter(infixString);
	return postFixString;
    }

    private boolean isAnOperand(char token) {
	return Character.isAlphabetic(token);
    }

    private int precedence(char operator) {
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

    public static void main(String[] args) {
	String exp = "a+b*(c^d-e)^(f+g*h)-i";// abcd^e-fgh*+^*+i-
	// exp = "a*b-(c+d)+e";
	InfixToPostfix obj = new InfixToPostfix();
	System.out.println(obj.getPostFixString(exp));
	System.out.println(obj.postFixEvaluation("123*+5-"));
    }
    
    public int postFixEvaluation(String postFixStr) {
	Stack<Integer> operand = new Stack<>();
	for (int i = 0; i < postFixStr.length(); i++) {
	    char token = postFixStr.charAt(i);
	    if (Character.isDigit(token)) {
		operand.push(Integer.parseInt(Character.toString(token)));
	    } else if (isUnaryOperator(token)) {
		int retVal = performUnaryOperation(operand.pop(), token);
		operand.push(retVal);
	    } else if (isBinaryOperator(token)) {
		int retVal = performBinaryOperation(operand.pop(), operand.pop(), token);
		operand.push(retVal);
	    }
	}
	return operand.pop();
    }

    private boolean isUnaryOperator(char operator) {
	return false;
    }

    private boolean isBinaryOperator(char operator) {
	return true;
    }

    private int performBinaryOperation(int secondDigit, int firstDigit, char operation) {
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
    
    private int performUnaryOperation(int digit, char operation) {
	return 0;
    }

}
