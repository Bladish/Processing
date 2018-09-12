int xCord = 80;
int yCord = 600;
int distance = 30;
void setup(){
  size(600, 600);
  background(0,191,255);
  strokeWeight(2.5);
}

void draw(){
	for (int i = 0; i < width; i = i + distance) {
		line(0,i,xCord + i,yCord);
		if(i % (3 * distance) == 0){
			stroke(0);
		}else stroke(220,220,220);
	}
  	
 }

