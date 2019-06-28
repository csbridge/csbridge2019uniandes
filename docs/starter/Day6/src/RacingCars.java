import acm.program.*;
import acm.graphics.*;
import acm.util.*;

import java.awt.Color;
import java.awt.event.*;

public class RacingCars extends GraphicsProgram {
	private final int CAR_WIDTH=75;
	private final int MAX_VELOCITY=5;
	private final int PAUSE_TIME=20;
	private final int X_OFFSET=50;
	private RandomGenerator rgen=RandomGenerator.getInstance();

	public void run(){
		/*Creation and placement of the cars*/
		int numCars=10;
		double carHeight=getHeight()/(2*numCars);//!!here is line that could be better written
		GRect[] cars=new GRect[numCars];
		for(int i=0;i<numCars;i++){
			cars[i]=new GRect(CAR_WIDTH,carHeight);
			cars[i].setColor(rgen.nextColor());
			cars[i].setFilled(true);
			add(cars[i],X_OFFSET,(2*i)*carHeight);
		}
		pause(1000);
		//Animation
		boolean finished=false;
		while(!finished) {
			//move each car one by one
			for(int i=0;i<cars.length;i++) {
				cars[i].move(rgen.nextInt(MAX_VELOCITY), 0);
				if(cars[i].getX()+CAR_WIDTH>=getWidth()) {
					finished=true;
					break;
				}
			}
			pause(30);
		}
	}
}
