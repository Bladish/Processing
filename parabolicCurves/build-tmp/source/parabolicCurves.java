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

int numberOfLines = 30;
public void setup(){
  
  background(0,191,255);
  strokeWeight(2.5f);
}

public void draw(){
	background(0,191,255);
	ParabolicCurves2 xAxis  = new ParabolicCurves2(685,74,193,2);
  	ParabolicCurves2 yAxis  = new ParabolicCurves2(29,50,19,605);
  	drawParabolicCurve(xAxis, yAxis);
}

 public void drawParabolicCurve(ParabolicCurves2 xAxis, ParabolicCurves2 yAxis) {
 	for (int i = 0; i <= numberOfLines; i++) {
		if(i % 3 == 0){stroke(0);}
		else 
			stroke(220);
		float lineX1 = xAxis.x1 + (i * (xAxis.x2 - xAxis.x1) / numberOfLines);
		float lineY1 = xAxis.y1 + (i * (xAxis.y2 - xAxis.y1) / numberOfLines);
		float lineX2 = yAxis.x1 + (i * (yAxis.x2 - yAxis.x1) / numberOfLines);
		float lineY2 = yAxis.y1 + (i * (yAxis.y2 - yAxis.y1) / numberOfLines);	
		line(lineX1, lineY1, lineX2, lineY2);
	}
 	
 }

 public class ParabolicCurves2 {
 	float x1;
 	float y1;
 	float x2;
 	float y2;
 	
 	
	public ParabolicCurves2 (float valueX1, float valueY1, float valueX2, float valueY2) {
		this.x1 = valueX1;
		this.y1 = valueY1;
		this.x2 = valueX2;
		this.y2 = valueY2;		
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
