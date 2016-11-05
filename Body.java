/*
 * Lab assignment 2
 * Sage Hourihan
 * 10/25/16
 */
package Sandbox;

import edu.princeton.cs.introcs.StdDraw;

public class Body {
	public double x;// physical property
	public double y;// physical property
	public double vx;// physical property
	public double vy;// physical property
	public double radius;// physical property
	public double mass;// physical property

	// R, G, B are variables used for the color of the Earth and the moon
	public int R;
	public int G;
	public int B;

	// constructor
	public Body(double px, double py, double ivx, double ivy, double pradius, int r, int g, int b) {
		x = px;// setting the x variable to px. will be used as x location for
				// the bodies
		y = py;// setting the variable to py. will be used as y location for the
				// bodies
		vx = ivx;// setting vx to ivx. will be used as horizontal velocity for
					// the bodies
		vy = ivy;// setting vy to ivy. will be used as vertical velocity for the
					// bodies
		radius = pradius;// setting radius to pradius

		R = r;// setting R to r
		G = g;// setting G to g
		B = b;// setting B to b
		// these will be used to change the color of the bodes
	}

	public void setmass(double m) {
		mass = m;// setting mass to m. will be used to set the mass of the body
	}

	// method to draw body
	public void draw(double PIXEL_PER_METER) {
		StdDraw.setPenColor(R, G, B);
		StdDraw.filledCircle(x * PIXEL_PER_METER, y * PIXEL_PER_METER, radius);

	}

	// method to updatePosition of body
	public void updatePosition(double timestep) {
		x = x + vx * timestep;
		y = y + vy * timestep;
	}

	// method to updateVelocity of body
	public void updateVelocity(double ax, double ay, double timestep) {
		vx = vx + ax * timestep;
		vy = vy + ay * timestep;
	}

}