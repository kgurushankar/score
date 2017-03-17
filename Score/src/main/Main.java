package main;

import java.awt.Color;

import core.Canvas;
import sprite.Sprite;

public class Main {
	public static Sprite[] spriteBuffer = new Sprite[0];
	public static Sprite sprite1 = new Sprite(100,100,100,100, Color.RED);
	public static void main(String[] args) throws InterruptedException {
		Canvas.startCanvas();
		Sprite sprite2 = new Sprite();
		while(true){
			sprite1.moveTo(0, 0);
			sprite2.moveTo(100,0);
			Thread.sleep(100);
			sprite1.moveTo(100, 0);
			sprite2.moveTo(100, 100);
			Thread.sleep(100);
			sprite1.moveTo(100, 100);
			sprite2.moveTo(0, 100);
			Thread.sleep(100);
			sprite1.moveTo(0, 100);
			sprite2.moveTo(0, 0);
			Thread.sleep(100);
		}
	}
}
