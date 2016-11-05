/*
 * Lab assignment 2
 * Sage Hourihan
 * 10/25/16
 */
package Sandbox;
import edu.princeton.cs.introcs.StdDraw;

public class EarthMoon {
  
	//Creating fields I will be using in this class
	
  public static double GRAVITY_CONSTANT = 1.0;
  public static double PIXEL_PER_METER = 5.0;
   
  public static int X = 20;
  public static int Y = 20;
   
  public static int FRAMERATE = 30;
  public static double TIMESTEP = 1.0 / FRAMERATE;
   
  public Body M;//Moon
  public Body Earth;//Earth
   
  
  //Constructor
  public EarthMoon(double Bodyx, double Bodyy, double BodyVx, double BodyVy, double BodyRadius, int BodyR, int BodyG, int BodyB, double Bodymass) {
    M = new Body(Bodyx, Bodyy, BodyVx, BodyVy, BodyRadius, BodyR, BodyG, BodyB);
    M.setmass(Bodymass);
    Earth = new Body(X, Y, 0, 0, 10, 0, 0, 255);
  }
   
  //method to draw  
  @SuppressWarnings("deprecation")
public void draw() {
    StdDraw.clear(StdDraw.BLACK);
    M.draw(PIXEL_PER_METER);
     
    Earth.draw(PIXEL_PER_METER);
     
     
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.setPenRadius(0.02);
    StdDraw.setPenRadius();
    StdDraw.show((int)(1000 * TIMESTEP));
  }
   
  //method to calculate the distance between Earth and Moon
  public double distance() {
    double dx = M.x - Earth.x;
    double dy = M.y - Earth.y;
     
    return Math.sqrt(dx*dx + dy*dy);
  }
   
  //method to calculate the gravityForce
  public double gravityForce(double k) {
    return distance() * k;
  }
   
  
  //method to calculate the acceleration of the bodies
  public double computeAccleration(double k) {
    double a;
    a = gravityForce(k) / M.mass;
    return a;
  }
   
   //method to calculate the x acceleration of the bodies
  public double computeAx(double a) {
    double dx = Earth.x - M.x;
    return a * dx / distance();
  }
   
  //method to calculate the y acceleration of the bodies 
  public double computeAy(double a) {
    double dy = Earth.y - M.y;
    return a * dy / distance();
  }
   
  //method to update the acceleration and velocity of the bodies
  public void update(double k, double timestep) {
 
    M.updatePosition(timestep);
    double a = computeAccleration(GRAVITY_CONSTANT);
    double ax = computeAx(a);
    double ay = computeAy(a);
    M.updateVelocity(ax, ay, timestep);
     
  }
}