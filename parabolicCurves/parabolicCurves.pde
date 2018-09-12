int xCord = 0;
int yCord = 600;
int distance = 30;
int[] position = new int[4];
void setup(){
  size(600, 600);
  background(0,191,255);
  strokeWeight(2.5);
}

void draw(){
	//drawParabolicCurve();
  	ParabolicCurves2 parabolicCurves  = new ParabolicCurves2(position,0,600,8);

 }

 public void drawParabolicCurve() {
 	for (int i = 0; i < width; i = i + distance) {
		line(0,i,xCord + i,yCord);
		if(i % (3 * distance) == 0){
			stroke(0);
		}else stroke(220,220,220);
	}
 	
 }

 public class ParabolicCurves2 {
 	private int[] position;
 	private int axis1;
 	private int axis2;
 	private int numberOfLines; 
 	
	public ParabolicCurves2 (int[] position, int axis1, int axis2, int numberOfLines ) {
		int lineDistance = width/numberOfLines;	
		for (int i = 0; i < numberOfLines; i++) {
			line(0, i * lineDistance, axis1 + i * lineDistance, axis2);		
			}		
	}


}

