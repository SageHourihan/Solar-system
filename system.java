/*
 * Lab assignment 2
 * Sage Hourihan
 * 10/25/16
 */
package Sandbox;

import edu.princeton.cs.introcs.StdDraw;

public class system {

	// creating variables for the window
	private static double WINDOW_WIDTH = 200;
	private static double WINDOW_HEIGHT = 200;

	// main method which calls upon the other two classes I created and draws
	// them
	public static void main(String[] args) {
		double x = 25, y = 10;

		double v_x = 10.0, v_y = 10.0;

		StdDraw.setXscale(0, WINDOW_WIDTH);
		StdDraw.setYscale(0, WINDOW_HEIGHT);
		// EarthMoon sb = new EarthMoon(x, y, v_x, v_y, 3, 255, 255, 255, 0.5);
		SolarSystem merc = new SolarSystem(25, 18, 3, 5, 1.5, 250, 100, 50, 0.5);
		SolarSystem ven = new SolarSystem(28, 20, 3, 10, 2, 0, 255, 0, 0.5);
		SolarSystem ear = new SolarSystem(31, 22, 5, 12, 3, 0, 0, 255, 0.5);
		SolarSystem mars = new SolarSystem(34, 25, 10, 16, 2, 255, 0, 0, 0.5);

		while (true) {

			// sb.draw();
			merc.draw();
			ven.draw();
			ear.draw();
			mars.draw();

			// sb.update(1.0, 1.0/50);
			merc.update(1.0, 1.0 / 20);
			ven.update(1.0, 1.0 / 25);
			ear.update(1.0, 1.0 / 30);
			mars.update(1.0, 1.0 / 35);
			
		}
	}

}
