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
public void setup(){
  
  background(0,191,255);
  strokeWeight(2.5f);
}

public void draw(){
	for (int i = 0; i < width; i = i + distance) {
		line(0,i,xCord + i,yCord);
		if(i % (3 * distance) == 0){
			stroke(0);
		}else stroke(220,220,220);
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
