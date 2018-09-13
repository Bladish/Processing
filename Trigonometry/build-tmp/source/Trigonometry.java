import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Trigonometry extends PApplet {


int frame = 0;
float multiplier = 0.002f;
int numberOfPoints = 320;
int distance = width/100;



public void setup()
{
	
	strokeWeight(5);
}

public void draw()
{
	background(255);
	Circle circle = new Circle();
	//Draw animated point
	circle.makingACircle();
	cosCurve();
	sinCurve();
	frame++;
}

public void sinCurve() {
	for (int i = 0; i < width; i += 10) {
			stroke(206,112,155);
			point(distance + i, 240 + sin((-frame + i) * 0.04f) * 100);
		}
	
}

public void cosCurve() {
			for (int i = 0; i < width; i += 10) {
			stroke(135,182,204);
			point(distance + i, 240 + cos((frame + i) * 0.04f) * 100);	
		}			
}

public class Circle{
	
	public void makingACircle() {
		for (int i = 0; i < width; i += 10) {
			if(i % 10 == 0)
				stroke(random(0,255), random(0,255), random(0,255));
			point(width/2 + cos((frame + i) * 0.04f) * 200,height/2 +  sin((frame + i) * 0.04f) * 200);

		}
			
	}

}

  public void settings() { 	size(640, 480); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Trigonometry" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
