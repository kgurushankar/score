package main;

import java.awt.Color;

import core.Canvas;
import sprite.Sprite;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		Canvas.startCanvas();
		Sprite sprite1 = new Sprite(100,100,100,100);
		sprite1.color = Color.RED;
		
	}
}
