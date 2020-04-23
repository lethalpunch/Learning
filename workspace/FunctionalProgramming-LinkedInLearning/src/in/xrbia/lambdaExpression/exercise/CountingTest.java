package in.xrbia.lambdaExpression.exercise;

import static in.xrbia.lambdaExpression.exercise.BasicDetection.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Consumer;

public class CountingTest {
	
	public static final int XRES = 1920, YRES = 1080, MAXX = 200, MAXY = 200;
	
	// generate random boxes
	public static ArrayList<Box> makeRandom(int n) {
		ArrayList<Box> result = new ArrayList<>(n);
		for (int i = 0; i<n; i++) {
			result.add(Box.newRandow(XRES, YRES, MAXX, MAXY));
		}
		return result;
	}

	public static void main(String[] args) {
		final int TEST_SIZE = 5_000;
		ArrayList<Box> world = makeRandom(TEST_SIZE);
		
		System.out.println("\nCounting the number of collisions:");
		
		final LongAdder atomicCounter = new LongAdder();
		Consumer<Collision> action = c -> atomicCounter.increment();
		
		System.out.println("\nStandard imperative");
		
		forEachCollision1(world, action);
		atomicCounter.reset();
		
		//Standard imperative
		System.out.println("Standard imperative");
		long startTime = Calendar.getInstance().getTimeInMillis();
		forEachCollision1(world, action);
		long endTime = Calendar.getInstance().getTimeInMillis();
		System.out.println("Number of Collisions: " + atomicCounter);
		System.out.println("Processed in: " + (endTime - startTime));
		atomicCounter.reset();
		
		//standard imperative (no duplicates)
		System.out.println("standard imperative (no duplicates)");
		startTime = Calendar.getInstance().getTimeInMillis();
		forEachCollision2(world, action);
		endTime = Calendar.getInstance().getTimeInMillis();
		System.out.println("Number of Collisions: " + atomicCounter);
		System.out.println("Processed in: " + (endTime - startTime));
		atomicCounter.reset();
		
		//Parallel Stream
		System.out.println("Parallel Stream");
		startTime = Calendar.getInstance().getTimeInMillis();
		forEachCollision3(world, action);
		endTime = Calendar.getInstance().getTimeInMillis();
		System.out.println("Number of Collisions: " + atomicCounter);
		System.out.println("Processed in: " + (endTime - startTime));

	}

}
