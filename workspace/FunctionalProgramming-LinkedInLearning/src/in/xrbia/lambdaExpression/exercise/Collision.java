package in.xrbia.lambdaExpression.exercise;

/**
 * A Collision is a pair of Boxes. Order is not relevant, as witnessed by
 * hashCode and equals
 * 
 * @author LE7HAL
 *
 */

public class Collision {

	public final Box a, b;

	public Collision(Box a, Box b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public int hashCode() {
		return a.hashCode() ^ b.hashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Collision)) {
			return false;
		}
		Collision c = (Collision) other;
		return (a.equals(c.a) && b.equals(c.b))
				|| (a.equals(c.b) && b.equals(c.a));
	}

}
