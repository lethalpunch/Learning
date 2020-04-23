package in.xrbia.lambdaExpression.exercise;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

public class BasicDetection {

	public static void forEachCollision1(Collection<Box> c,
			Consumer<Collision> collisionHandler) {
		for (Box a : c) {
			for (Box b : c) {
				if (Box.areOverlapping(a, b)) {
					collisionHandler.accept(new Collision(a, b));
				}
			}
		}
	}

	public static void forEachCollision2(ArrayList<Box> c,
			Consumer<Collision> collisionHandler) {
		for (int i = 0; i < c.size(); i++) {
			for (int j = i + 1; j < c.size(); j++) {
				Box a = c.get(i), b = c.get(j);
				if (Box.areOverlapping(a, b)) {
					collisionHandler.accept(new Collision(a, b));
				}
			}
		}
	}
	
	// Using parallel stream.
	public static void forEachCollision3(Collection<Box> c,
			Consumer<Collision> collisionHandler) {
		c.parallelStream().collect(() -> new ForEachCollisionCollector(collisionHandler),
				ForEachCollisionCollector::update,
				ForEachCollisionCollector::merge);
	}

}
