/*
 * Lab assignment 2
 * Sage Hourihan
 * 11/1/2016
 */
package Sandbox;

import edu.princeton.cs.introcs.StdDraw;

public class SolarSystem {

	// Creating fields I will be using in this class

	public static double GRAVITY_CONSTANT = 1.0;
	public static double PIXEL_PER_METER = 5.0;

	public static int X = 20;
	public static int Y = 20;

	public static int FRAMERATE = 30;
	public static double TIMESTEP = 1.0 / FRAMERATE;

	public Body Sun;// Sun
	public Body Merc;// Mercury
	public Body Ven;// Venus
	public Body Ear;// Earth
	public Body Mars;// Mars

	// Constructor
	public SolarSystem(double Bodyx, double Bodyy, double BodyVx, double BodyVy, double BodyRadius, int BodyR,
			int BodyG, int BodyB, double Bodymass) {
//		final double AU = 1.49598e11;
//		final double EM = 5.9736e24;

		Merc = new Body(Bodyx, Bodyy, BodyVx, BodyVy, BodyRadius, BodyR, BodyG, BodyB);
		Merc.setmass(Bodymass);
		Ven = new Body(Bodyx, Bodyy, BodyVx, BodyVy, BodyRadius, BodyR, BodyG, BodyB);
		Ven.setmass(Bodymass);
		Ear = new Body(Bodyx, Bodyy, BodyVx, BodyVy, BodyRadius, BodyR, BodyG, BodyB);
		Ear.setmass(Bodymass);
		Mars = new Body(Bodyx, Bodyy, BodyVx, BodyVy, BodyRadius, BodyR, BodyG, BodyB);
		Mars.setmass(Bodymass);
		Sun = new Body(X, Y, 0, 0, 7, 255, 255, 0);

	}

	// method to draw
	public void draw() {
		StdDraw.clear(StdDraw.BLACK);
		Merc.draw(PIXEL_PER_METER);
		Ven.draw(PIXEL_PER_METER);
		Ear.draw(PIXEL_PER_METER);
		Mars.draw(PIXEL_PER_METER);
		Sun.draw(PIXEL_PER_METER);

//		StdDraw.setPenColor(StdDraw.BLACK);
//		StdDraw.setPenRadius(0.02);
//		StdDraw.setPenRadius();
		StdDraw.show(20);
	}

	// method to calculate the distance
	public double distance() {
		double dx = Merc.x - Sun.x;
		double dy = Merc.y - Sun.y;
		return Math.sqrt(dx * dx + dy * dy);
	}

	// method to calculate the gravityForce
	public double gravityForce(double k) {
		return distance() * k;
	}

	// method to calculate the acceleration of the bodies
	public double computeAccleration(double k) {
		double a;
		a = gravityForce(k) / Merc.mass;
		return a;
	}

	// method to calculate the x acceleration of the bodies
	public double computeAx(double a) {
		double dx = Sun.x - Merc.x;
		return a * dx / distance();
	}

	// method to calculate the y acceleration of the bodies
	public double computeAy(double a) {
		double dy = Sun.y - Merc.y;
		return a * dy / distance();
	}

	// method to update the acceleration and velocity of the bodies
	public void update(double k, double timestep) {

		Merc.updatePosition(timestep);
		Ven.updatePosition(timestep);
		Ear.updatePosition(timestep);
		Mars.updatePosition(timestep);

		double a = computeAccleration(GRAVITY_CONSTANT);
		double ax = computeAx(a);
		double ay = computeAy(a);

		Merc.updateVelocity(ax, ay, timestep);
		Ven.updateVelocity(ax, ay, timestep);
		Ear.updateVelocity(ax, ay, timestep);
		Mars.updateVelocity(ax, ay, timestep);
	}
}
