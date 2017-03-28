package main;
import sprite.Sprite;
import core.Canvas;

public class Main {

	public static void  main(String[] args) {
		Canvas canvas = new Canvas("TEST",1000,1000);
		Sprite test = new Sprite(Sprite.RECTANGLE);
		canvas.update();
	}

}
