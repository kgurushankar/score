package main;
import sprite.Sprite;

import java.awt.Color;

import core.Canvas;

public class Main {

	public static void  main(String[] args) throws InterruptedException {
		Canvas canvas = new Canvas("TEST",1000,1000);
		Sprite test = new Sprite(Sprite.RECTANGLE);
		test.color = Color.BLUE;
		Sprite test2 = new Sprite(Sprite.RECTANGLE);
		test.x = 500;
		test.y = 500;
		test2.x = 300;
		test2.y = 300;
		Canvas.update();
		while(true){
			test.pointTowardsSprite(test2);
			test2.goToMouse();
			test.moveSteps(4);
			Thread.sleep(10);
		}
	}

}
