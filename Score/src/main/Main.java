package main;

import java.awt.Color;

import core.Canvas;
import sprite.Sprite;

public class Main {
	public static Sprite sprite1 = new Sprite(0,0,100,100, Color.RED);
	public static Sprite sprite2 = new Sprite(100,100,200,100, Color.BLUE);
	public static Sprite[] spriteBuffer = {sprite1,sprite2};
	public static void main(String[] args) {
		Canvas.startCanvas();

	}

}
