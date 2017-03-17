package main;

import java.awt.Color;

import core.Canvas;
import sprite.Sprite;

public class Main {
	public static Sprite sprite1 = new Sprite(100,100,100,100, Color.RED);
	public static Sprite[] spriteBuffer = new Sprite[1];
	public static void main(String[] args) throws InterruptedException {
		spriteBuffer[0] = sprite1;
		Canvas.startCanvas();
		Sprite sprite2 = new Sprite();
		spriteBuffer = push(spriteBuffer, sprite2);
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
	public static Sprite[] push(Sprite[] push, Sprite pushable){
		Sprite[] temp = new Sprite[push.length+1];
		for(int i = 0; i < push.length; i++){
			temp[i] = push[i];
		}
		temp[temp.length-1] = pushable;
		return temp;
	}

}
