package main;
import sprite.Sprite;

import java.awt.Color;

import core.Canvas;

public class Main {

	public static void  main(String[] args) throws InterruptedException {
		Canvas canvas = new Canvas("test", 1000,1000);
		Sprite test1 = new Sprite(Sprite.RECTANGLE);
		test1.goTo(100, 100);
		test1.color = Color.RED;
		Sprite test2 = new Sprite(Sprite.RECTANGLE);
		test2.goTo(100, 100);
		test2.color = Color.BLUE;
		Sprite test3 = new Sprite(Sprite.RECTANGLE);
		test3.color = Color.YELLOW;
		test3.goTo(100,100);
		test3.setLayerTo(0);
	}

}
