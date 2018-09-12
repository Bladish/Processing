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

public class HumbleBeginnings extends PApplet {

public void setup(){
  
}

public void draw(){
  fill(142,90,109,60);
  background(142,90,109,60);
  strokeWeight(15.0f);
  
  line(120,120,120,238);
  line(120,240,74,240);
  line(74,215,74,239);
  
  ellipse(177,214,60,57);
  
  arc(260,214,60,57,7,12);
  
  line(320,240,320,119);
  arc(361,214,69,57,8,11);
  
  arc(414,214,60,57,7,12);
  line(392,209,439,208);
}
  public void settings() {  size(768,432); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "HumbleBeginnings" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
