package main;
import sprite.Sprite;

import java.awt.Color;
import java.awt.Font;

import core.Canvas;
import core.Keyboard;

public class Main {
	public static void main(String[] args) throws InterruptedException{
		test();
	}
	public static void test() throws InterruptedException {
		Canvas canvas = new Canvas("test", 1000,1000);
		int stage = 0;
		//Title screen
		Sprite background = new Sprite(Sprite.IMAGE);
		//Starting screen
		background.setSizeTo(1000, 1000);
		background.color = Color.YELLOW;
		
		Sprite text = new Sprite(Sprite.TEXT);
		text.text = "PRESS SPACE TO START";
		text.font = new Font(Font.SANS_SERIF, Font.BOLD, 30);
		text.goTo(300, 475);
		
		ExtensionTester test1 = new ExtensionTester(Sprite.RECTANGLE);
		test1.goTo(500, 500);
		test1.color = Color.RED;
		
		
		while(stage == 0){
			if(Keyboard.keyPressed(32)){
				stage = 1;
			}
			Thread.sleep(10);
		}
		
		background.color = Color.GREEN;
		
		text.visible = false;
		
		Sprite hero = new Sprite(Sprite.RECTANGLE);
		hero.setSizeTo(80, 80);
		hero.color = Color.BLUE;
		hero.goTo(800, 460);
		hero.angle = 180;
		
		Sprite defender = new Sprite(Sprite.RECTANGLE);
		defender.color = Color.RED;
		defender.goTo(100, 450);
		
		Sprite goalie = new Sprite(Sprite.RECTANGLE);
		goalie.color = Color.RED;
		goalie.setSizeTo(200, 200);
		goalie.goTo(0, 450);
		canvas.update();
		long timekeeper = 0;
		while(stage == 1){
			if(Keyboard.keyPressed(38)){
				hero.moveSteps(5);
			}
			if(Keyboard.keyPressed(37)){
				hero.angle = hero.angle + 5;
				canvas.update();
			}
			if(Keyboard.keyPressed(39)){
				hero.angle = hero.angle - 5;
				canvas.update();
			}
			if(timekeeper%55 == 0){
				timekeeper = 0;
				defender.pointTowardsSprite(hero);
				defender.angle += 10;
			}
			defender.moveSteps(7);
			Thread.sleep(20);
			if(	   (Math.abs(defender.x + 50 - hero.x) < 144) 
				&& (Math.abs(defender.y + 50 - hero.y) < 144)){
				stage = -1;
			}
			if(hero.x <= 10){
				stage = 2;
			}
			goalie.pointTowardsSprite(hero);
			goalie.moveSteps(3);
			timekeeper++;
		}
		if(stage == -1){
			goalie.visible = false;
			defender.goTo(hero.x, hero.y);
			text.visible = true;
			text.text = "TACKLED!!";
			text.font = new Font(Font.SANS_SERIF, Font.BOLD, 100);
			text.sendToFront();
			text.color = Color.RED;
			canvas.update();
			Thread.sleep(500);
			for(int i = 0; i < 100; i++){
				defender.visible = false;
				hero.changeSizeBy(100 - i);
				Thread.sleep(100);
			}
		}
		if(stage == 2){
			goalie.visible = false;
			hero.angle = 0;
			hero.goTo(-20, hero.y);
			text.visible = true;
			text.text = "YOU WIN!";
			text.font = new Font(Font.SANS_SERIF, Font.BOLD, 100);
			text.sendToFront();
			text.color = Color.BLUE;
			canvas.update();
			for(int i = 0; i < 100; i++){
				defender.changeSizeBy(100 - i);
				Thread.sleep(20);
			}

		}
	}

}