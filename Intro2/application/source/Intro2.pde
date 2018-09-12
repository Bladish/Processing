int scanLineDistance = 10;
int frames = 0;


void setup(){
  size(720,480);
  strokeWeight(5);
}

void draw(){
  background(255);
  stroke(128, 128, 128, 128);
  
  for(int i = 0; i < height; i = i + scanLineDistance){
  line(0, i + frames % scanLineDistance, width, i + frames % scanLineDistance);
    frames++;
  }
}
