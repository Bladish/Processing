int xCord = 80;
int yCord = 600;
int distance = 50;
void setup(){
  size(600, 600);
  background(255);
  stroke(0,0,0,255);
  strokeWeight(5.5);
}

void draw(){
	for (int i = 0; i < width; i = i + distance) {
		line(0,i,xCord + i,yCord);	
	}
  	
 }
