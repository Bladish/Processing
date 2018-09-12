float triangleX1 = 8/width;
float triangleY1 = 435/height;
float triangleX2 = 200/width;
float triangleY2 = 434/height;
float triangleX3 = 119/width;
float triangleY3 = 253/height;
void setup(){
  size(768,432);
  
}

void draw(){
  background(220);
  fill(220);
  triAngles();
  noFill();
  name();
}

public void triAngles(){
  strokeWeight(4.0);
    for (int i = 0; i < width; i = i + 10) {
      triangle(triangleX1 * width + width - i,triangleY1 + i, triangleX2 * width - i, triangleY2 * height + i, triangleX3 * width - i, triangleY3 * height + i);
    }

  
}

public void name() {
  strokeWeight(15.0);
  
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
