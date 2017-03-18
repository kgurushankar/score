package main;

import core.Canvas;
import sprite.Sprite;

public class Main {
	/*This is the most unstable version of score. I wouldn't recommend using it!*/
	public static void main(String[] args){
		Canvas.startCanvas();
		Sprite sprite1 = new Sprite();
		sprite1.width = 200;
		sprite1.height = 200;
		sleep(100);
		while(true){
			sprite1.goTo(0,0);
			sleep(100);
			sprite1.goTo(100, 0);
			sleep(100);
			sprite1.goTo(100, 100);
			sleep(100);
			sprite1.goTo(0, 100);
			sleep(100);
		}
	}
	public static void sleep(int millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
