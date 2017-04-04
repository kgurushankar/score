package main;
import sprite.Sprite;

import java.awt.Color;

import core.Canvas;
import core.Keyboard;

public class Main {

	public static void  main(String[] args) throws InterruptedException {
		Canvas canvas = new Canvas("test", 1000,1000);
		Sprite test = new Sprite(Sprite.RECTANGLE);
		test.goTo(100, 100);
		while(true){
			if(Keyboard.keyPressed(38)){
				test.moveSteps(10);
			}
			if(Keyboard.keyPressed(37)){
				test.angle = test.angle + 10;
				canvas.update();
			}
			if(Keyboard.keyPressed(39)){
				test.angle = test.angle - 10;
				canvas.update();
			}
			Thread.sleep(100);
		}
		
	}

}
