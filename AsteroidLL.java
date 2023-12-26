public class AteroidLL {

	public static void main(String[] args) {

		AteroidLL myAwesomeAsteroidList = new AteroidLL();

		myAwesomeAsteroidList.getAsteroidFromDataFile("input.txt");
		System.out.println("--------------------------------------");
		System.out.println("Printing the Linked List");
		myAwesomeAsteroidList.printLL();

		System.out.println("--------------------------------------");
		System.out.println("Average mass of all the elements in the list: " + myAwesomeAsteroidList.getAverageMass());

		Asteroid[] asteroidsAsArray = myAwesomeAsteroidList.toArray();

		System.out.println("--------------------------------------");
		System.out.println("Average mass of all the elements in the array: " + computeAverageMass(asteroidsAsArray));

		System.out.println("--------------------------------------");
		System.out.println("[Collatz Sequence] The sequence should end in 4 2 1 regardless of what the input number is: ");
		collatzSequence(915);

	}

	/**Compute the average mass of all objects (helper function)*/
	public static double computeAverageMass(Asteroid[] asteroids) {
		if (asteroids.length == 0) {
			return 0.0;
		}
		return computeSumMassRecursive(asteroids, 0) / asteroids.length;
	}

	/**Compute the sum of the mass of all the objects in the array using recursion*/
	public static double computeSumMassRecursive(Asteroid[] asteroids, int index) {
		if (index >= asteroids.length) {
			return 0.0;
		}
		return asteroids[index].getMass() + computeSumMassRecursive(asteroids, index + 1);
	}

	/**
	 * Generates the Collatz sequence for a given positive integer.
	 *
	 * The Collatz sequence is generated recursively based on the following rules:
	 * - If the current number is even, the next number is obtained by dividing it
	 * by 2.
	 * - If the current number is odd, the next number is obtained by multiplying it
	 * by 3 and adding 1.
	 * - If n is 1, print the number and terminate the recursion
	 * The sequence is printed to the console.*/
	public static void collatzSequence(int n) {
		System.out.print(n + " ");
		if (n == 1) {
			return;
		} else if (n % 2 == 0) {
			collatzSequence(n / 2);
		} else {
			collatzSequence(3 * n + 1);
		}
	}
}