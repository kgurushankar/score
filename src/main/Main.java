package main;
/*
 * Program by Anantajit Subrahmanya
 * 
 * The goal of this program is to display a landscape
 * 
 * External Libraries: Uses score, a library created by Anantajit Subrahmanya
 * Available at https://www.github.com/anantajit/score
 * 
 * Created on 4/25/2017
 */

import java.awt.Color;
import java.awt.Font;

import core.Canvas;
import sprite.Sprite;

public class Main {
	public static void main(String[] args){
		Canvas canvas = new Canvas("Scenic Landscape", 768, 432);
		
		Sprite bottomText = new Sprite(Sprite.TEXT);
		bottomText.font = new Font(Font.SERIF, Font.ITALIC, 32);
		bottomText.text = "Sunnyvale, CA: A Scenic Landscape";
		bottomText.goTo(150, 350);
		bottomText.color = Color.BLACK;
		
		Sprite line = new Sprite(Sprite.RECTANGLE);
		line.goTo(0, 300);
		line.color = Color.GREEN;
		line.setSizeTo(768, 1);
		
		Sprite trunk = new Sprite(Sprite.RECTANGLE);
		trunk.goTo(150, 200);
		trunk.setSizeTo(30, 100);
		
		Sprite house = new Sprite(Sprite.RECTANGLE);
		house.color = new Color(100,0,100);
		house.goTo(550, 200);
		house.setSizeTo(100, 100);
		
		Sprite roof = new Sprite(Sprite.RECTANGLE);
		roof.goTo(564, 165);
		roof.color = Color.BLUE;
		roof.angle = 45;
		roof.setSizeTo(70,70);
		roof.setLayerTo(2);
		
	}
}	
