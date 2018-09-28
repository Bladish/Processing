boolean moveLeft;
boolean moveRight;
boolean moveUp;
boolean moveDown;



void keyPressed(){
	if(key == 'd'){
		moveRight = true;
	}
	else if(key == 'a'){
		moveLeft = true;
	}
	else if(key == 'w'){
		moveUp = true;
	}
	else if(key == 's'){
		moveDown = true;
	}
}

void keyReleased(){
	if(key == 'd'){
		moveRight = false;
	}
	else if(key == 'a'){
		moveLeft = false;
	}
	else if(key == 'w'){
		moveUp = false;
	}
	else if(key == 's'){
		moveDown = false;
	}	
}

float getAxisRaw(String axis){
	if(axis == "Horizontal") {
		if(moveLeft){
			return -1;
		}

		if(moveRight){
			return 1;
		}
	}

	if(axis == "Vertical"){
		if(moveUp){
			return -1;
		}

		if(moveDown){
			return 1;
		}

	}

	return 0;
} 