package sidehack.ma402;

import java.util.Scanner;

public class MonteCarloPiApproximation {

	/**
	 * Pi Approximations using Monte Carlo approximation. Using a square and a
	 * quarter a circle, then using
	 * 
	 * @author CarlisNdemo
	 * 
	 */
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner totalPoints = new Scanner(System.in);

		System.out.println("Enter the number of points for approximation: ");
		int numPoints = totalPoints.nextInt();

		System.out.println("Your Pi Approximation was: " + valueOfPi(numPoints));

	}

	// Generates value of Pi using Monte Carlo simulation.
	public static int valueOfPi(int n) {

		int pointsInCircle = 0;

		for (int i = 0; i < n; i++) {

			double x = Math.random();
			double y = Math.random();

			//System.out.println(x + " , " + y);

			if (((x * x) + (y * y)) <= 1.00) {
				pointsInCircle++;
			} else {
				continue;
			}

		} // ends for loop

		int pI = 4 * (pointsInCircle / n);
		return pI;
	}
}

