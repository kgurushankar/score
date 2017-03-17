package main;

import java.awt.Color;

import core.Canvas;
import sprite.Sprite;

public class Main {
	
	public static Sprite sprite1 = new Sprite(100,100,100,100, Color.RED);
	public static void main(String[] args) throws InterruptedException {
		Canvas.startCanvas();
		Sprite sprite2 = new Sprite();
		Sprite sprite3 = new Sprite();
		sprite3.color = Color.GREEN;
		while(true){
			sprite1.moveTo(100, 0);
			sprite2.moveTo(200, 0);
			sprite3.moveTo(200, 100);
			Thread.sleep(80);
			sprite1.moveTo(200, 0);
			sprite2.moveTo(200, 100);
			sprite3.moveTo(200, 200);
			Thread.sleep(70);
			sprite1.moveTo(200, 100);
			sprite2.moveTo(200, 200);
			sprite3.moveTo(100,200);
			Thread.sleep(60);
			sprite1.moveTo(200, 200);
			sprite2.moveTo(100, 200);
			sprite3.moveTo(0,200);
			Thread.sleep(50);
			sprite1.moveTo(100, 200);
			sprite2.moveTo(0, 200);
			sprite3.moveTo(0,100);
			Thread.sleep(70);
			sprite1.moveTo(0, 200);
			sprite2.moveTo(0, 100);
			sprite3.moveTo(0,0);
			Thread.sleep(80);
			sprite1.moveTo(0, 100);
			sprite2.moveTo(0, 0);
			sprite3.moveTo(100,0);
			Thread.sleep(100);
			sprite1.moveTo(0, 0);
			sprite2.moveTo(100, 0);
			sprite3.moveTo(200,0);
			Thread.sleep(120);
		}
	}
}
