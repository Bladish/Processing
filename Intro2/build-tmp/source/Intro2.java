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

public class Intro2 extends PApplet {

int scanLineDistance = 10;
int frames = 0;


public void setup(){
  
  strokeWeight(5);
}

public void draw(){
  background(255);
  stroke(128, 128, 128, 128);
  
  for(int i = 0; i < height; i = i + scanLineDistance){
  line(0, i + frames % scanLineDistance, width, i + frames % scanLineDistance);
    frames++;
  }
}
  public void settings() {  size(1920,1080); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Intro2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
