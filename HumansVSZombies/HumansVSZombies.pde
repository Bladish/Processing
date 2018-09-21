
Controler controler;
void setup() {
	size(1024,800);
	controler = new Controler();
}

void draw() {
	background(255);
	controler.update();
	controler.collision();
	controler.checkBorders();
}