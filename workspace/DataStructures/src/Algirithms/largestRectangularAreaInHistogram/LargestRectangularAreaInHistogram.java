package Algirithms.largestRectangularAreaInHistogram;

import java.util.Stack;

public class LargestRectangularAreaInHistogram {
	
	public static int largestAreaViaBruteForce(int[] inputArr) {
		int maxArea = 0;
		for (int i = 0; i < inputArr.length; i++) {
			int count = 1;
			int forwardIndex = i + 1;
			int backwardIndex = i - 1;
			while(forwardIndex < inputArr.length && inputArr[i] <= inputArr[forwardIndex++]) {
				count++;
			}
			while(backwardIndex >=0 && inputArr[i] <= inputArr[backwardIndex--]) {
				count++;
			}
			maxArea = Math.max(maxArea, inputArr[i] * count);
		}
		return maxArea;
	}
	
	public static int largestAreaViaDivideAndConquer(int[] inputArr, int startIndex, int lastIndex) {
		if (lastIndex == startIndex) {
			return 0;
		}
		if (lastIndex - startIndex == 1) {
			return inputArr[startIndex];
		}
		int minIndex = findMinBarIndexViaSegmentTree(inputArr, startIndex, lastIndex);
		int leftMaxArea = largestAreaViaDivideAndConquer(inputArr, startIndex, minIndex);
		int rightMaxArea = largestAreaViaDivideAndConquer(inputArr, minIndex + 1, lastIndex);
		int minBarArea = inputArr[minIndex] * (lastIndex - startIndex);
 		return Math.max(minBarArea, Math.max(rightMaxArea, leftMaxArea));
	}
	
	private static int findMinBarIndexViaSegmentTree(int[] inputArr, int startIndex, int lastIndex) {
		// TODO Need to implement minimum query using segment tree which has complexity
		// of O(logn)
		int minNum = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int i = startIndex; i < lastIndex; i++) {
			if (inputArr[i] <= minNum) {
				minIndex = i;
				minNum = inputArr[i];
			}
		}
		return minIndex;
	}
	
	public static int largestAreaViaStack(int[] inputArr) {
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;
		int tp;
		int i = 0;
		while (i < inputArr.length) {
			if (stack.isEmpty() || inputArr[stack.peek()] <= inputArr[i]) {
				stack.push(i++);
			} else {
				tp = stack.pop();
				maxArea = Math.max(maxArea, inputArr[tp] * (stack.empty() ? i : i - stack.peek() - 1));
			}
		}

		while (!stack.empty()) {
			tp = stack.pop();
			maxArea = Math.max(maxArea, inputArr[tp] * (stack.empty() ? i : i - stack.peek() - 1));
		}
		return maxArea;
	}

	public static void main(String...strings) {
		int[] A = {6,2,5,4,5,1,6};
		System.out.println("Area using brute force = " + largestAreaViaBruteForce(A));
		System.out.println("Area using divide and conquer = " + largestAreaViaDivideAndConquer(A, 0, A.length));
		System.out.println("Area using stack implementation = " + largestAreaViaStack(A));
	}
}
