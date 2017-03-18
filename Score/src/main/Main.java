package main;

import core.Canvas;
import sprite.Sprite;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		Canvas.startCanvas();
		Sprite sprite1 = new Sprite();
		Thread.sleep(100);
		while(true){
			sprite1.goTo(0,0);
			Thread.sleep(100);
			sprite1.goTo(100, 0);
			Thread.sleep(100);
			sprite1.goTo(100, 100);
			Thread.sleep(100);
			sprite1.goTo(0, 100);
			Thread.sleep(100);
		}
		
	}
}
