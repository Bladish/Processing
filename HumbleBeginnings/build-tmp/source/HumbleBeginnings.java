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

float triangleX1 = 8/width;
float triangleY1 = 435/height;
float triangleX2 = 200/width;
float triangleY2 = 434/height;
float triangleX3 = 119/width;
float triangleY3 = 253/height;
public void setup(){
  
  
}

public void draw(){
  background(220);
  fill(220);
  triAngles();
  noFill();
  name();
}

public void triAngles(){
  strokeWeight(4.0f);
    for (int i = 0; i < width; i = i + 10) {
      triangle(triangleX1 * width + width - i,triangleY1 + i, triangleX2 * width - i, triangleY2 * height + i, triangleX3 * width - i, triangleY3 * height + i);
    }

  
}

public void name() {
  strokeWeight(15.0f);
  
  line(186,120,186,237);
  line(184,240,144,240);
  line(144,215,144,239);
  
  ellipse(246,214,60,57);
  
  arc(338,214,60,57,7,12);
  
  line(407,240,407,119);
  arc(449,214,69,57,8,11);
  
  arc(513,214,60,57,7,12);
  line(493,209,538,209);  
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
