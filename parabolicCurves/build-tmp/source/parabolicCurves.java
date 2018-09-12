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

public class parabolicCurves extends PApplet {

int xCord = 0;
int yCord = 600;
int distance = 30;
int[] position = new int[2];
public void setup(){
  
  background(0,191,255);
  strokeWeight(2.5f);
}

public void draw(){
	//drawParabolicCurve();
  	ParabolicCurves2 parabolicCurves  = new ParabolicCurves2(position,0,600,8);

 }

 public void drawParabolicCurve() {
 	for (int i = 0; i < width; i = i + distance) {
		line(0,i,xCord + i,yCord);
		if(i % (3 * distance) == 0){
			stroke(0);
		}else stroke(220,220,220);
	}
 	
 }

 public class ParabolicCurves2 {
 	private int[] position;
 	private int axis1;
 	private int axis2;
 	private int numberOfLines; 
 	
	public ParabolicCurves2 (int[] position, int axis1, int axis2, int numberOfLines ) {
		int lineDistance = width/numberOfLines;	
		for (int i = 0; i < numberOfLines; i++) {
			line(0, i * lineDistance, axis1 + i * lineDistance, axis2);		
			}		
	}


}

  public void settings() {  size(600, 600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "parabolicCurves" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
