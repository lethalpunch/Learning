
public class MainClass {
	static int stepCount = 0;

	public static void towerOfHanoi(int n, String fromPeg, String toPeg, String auxPeg) {
		// If only 1 disk, make the move and return.
		if (n == 1) {
			System.out.println("Move disk 1 from peg " + fromPeg + " to peg " + toPeg);
			stepCount++;
			return;
		}
		// Move top n-1 disks from A to B using C as auxiliary.
		towerOfHanoi(n - 1, fromPeg, auxPeg, toPeg);

		// Move remaining disks from A to C.
		System.out.println("Move disk from peg " + fromPeg + " to peg " + toPeg);
		stepCount++;

		// Move n-1 disks from B to C using A as auxiliary.
		towerOfHanoi(n - 1, auxPeg, toPeg, fromPeg);
	}

	public static void main(String... args) {
		towerOfHanoi(7, "A", "C", "B");
		System.out.println("Total Count ###### " + stepCount);
	}
}
