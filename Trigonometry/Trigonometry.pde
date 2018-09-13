
int frame = 0;
float multiplier = 0.002;
int numberOfPoints = 320;
int distance = width/100;



void setup()
{
	size(640, 480);
	strokeWeight(5);
}

void draw()
{
	background(255);

	//Draw animated point
	circle();
	cosCurve();
	sinCurve();
	frame++;
}

public void sinCurve() {
	for (int i = 0; i < width; i += 10) {
			stroke(206,112,155);
			point(distance + i, 240 + sin((-frame + i) * 0.04) * 100);
		}
	
}

public void cosCurve() {
			for (int i = 0; i < width; i += 10) {
			stroke(135,182,204);
			point(distance + i, 240 + cos((frame + i) * 0.04) * 100);	
		}			
}

public void circle() {
	for (int i = 0; i < width; i += 10) {
		if(i % 10 == 0)
			stroke(random(0,255), random(0,255), random(0,255));
			point(width/2 + cos((frame + i) * 0.04) * 200,height/2 +  sin((frame + i) * 0.04) * 200);
	}
}