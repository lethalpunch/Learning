package in.xrbia.lambdaExpression.exercise;

import java.util.ArrayList;
import java.util.function.Consumer;

public class ForEachCollisionCollector {
	
	private Consumer<Collision> handler;
	//stores previously seen boxes
	private ArrayList<Box> cache = new ArrayList<>();
	
	public ForEachCollisionCollector(Consumer<Collision> handler) {
		this.handler = handler;
	}
	
	//process a new box
	public void update(Box b) {
		for (Box a : cache) {
			if (Box.areOverlapping(a, b)) {
				handler.accept(new Collision(a, b));
			}
		}
		// store the new box
		cache.add(b);
	}
	
	public void merge(ForEachCollisionCollector other) {
		for (Box a : cache) {
			for (Box b : other.cache) {
				if (Box.areOverlapping(a, b)) {
					handler.accept(new Collision(a, b));
				}
			}
		}
		
		// merge the two caches
		cache.addAll(other.cache);
	}

}
