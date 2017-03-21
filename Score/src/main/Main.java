package main;
import java.awt.Color;
import java.awt.Font;

import core.Canvas;
import sprite.Sprite;
import core.Listener;

public class Main {
	/*Feel free to delete this file. It only exists for testing purposes!*/
	public static void main(String[] args){
		platformer();
	}
	public static void dodge(){
		Canvas canvas = new Canvas("Quick demo", 1000, 1000);
		Sprite hero = new Sprite(450,450,150,150);
		hero.addCostume("test2.jpg");
		Sprite[] bullets = new Sprite[10];
		//Our villans have been created!
		for(int i = 0; i < bullets.length; i++){
			bullets[i] = new Sprite(-i * randint(0,150),i * randint(0,150),50,50);
		}
		boolean playing = true;
		while(playing){
			canvas.getMouse();
			hero.goTo(canvas.x-75, canvas.y-75);
			//bullet behavior
			for(int i = 0; i < bullets.length; i++){
				if(bullets[i].x<950){
					bullets[i].x++;
				}
				else{
					bullets[i].x = 0;
					bullets[i].y = randint(0,950);
				}
				if(bullets[i].touching(hero)){
					playing = false;
				}
			}
			sleep(2);
		}
		System.exit(0);
	}
	public static void platformer(){
		//This is a simple game where you have to bump into another cat
		Sprite hero = new Sprite();
		hero.addCostume("test2.jpg");
		Sprite platform = new Sprite(Sprite.RECTANGLE);
		platform.width = 300;
		platform.height = 100;
		platform.x = 600;
		platform.y = 600;
		Sprite platform2 = new Sprite(Sprite.RECTANGLE);
		platform2.width = 300;
		platform2.height = 100;
		platform2.x = 300;
		platform2.y = 200;
		Sprite goal = new Sprite(300,100,100,100);
		Sprite ground = new Sprite(Sprite.RECTANGLE);
		ground.width = 1000;
		ground.height = 100;
		ground.x = 0;
		ground.y = 900;
		double velocity = 0;
		Canvas canvas = new Canvas("Quick demo",1000,1000);
		while(true){
			//This is the main game script
			if(hero.touching(goal)){
				break;
			}
			if(Listener.keypressed.equals("w")&&(hero.touching(ground)||hero.touching(platform)||hero.touching(platform2))){
				int maxHeight = hero.y;
				hero.goTo((int)((hero.x)+(velocity)*5), hero.y);
				velocity = velocity*0.9;
				for(double t = 0; hero.y<=800; t++){
					hero.goTo((int)((hero.x)+(velocity)*5), hero.y);
					hero.y = hero.y - (int) (4*t - 3*t*t/20);
					if(hero.y > maxHeight){
						break;
					}
					maxHeight = hero.y;
					if(hero.y > 800){
						hero.y = 800;
						break;
					}
					sleep(15);
					Canvas.panel.repaint();
					
				}
			}
			else if(!hero.touching(ground) && !hero.touching(platform) && !hero.touching(platform2)){
				for(double t = 0; hero.y<=800; t++){
					hero.goTo((int)((hero.x)+(velocity)*5), hero.y);
					hero.y = hero.y - (int) (-3*t*t/20);
					if(hero.y > 800){
						hero.y = 800;
						break;
					}
					if(hero.touching(platform)||hero.touching(platform2)){
						break;
					}
					sleep(30);
					Canvas.panel.repaint();
				}
			}
			if(hero.touching(platform)){
				if(hero.y + hero.height != platform.y){
					hero.y = platform.y - hero.height;
					
				}
			}
			if(hero.touching(platform2)){
				if(hero.y + hero.height != platform2.y){
					hero.y = platform2.y - hero.height;
					
				}
			}
			if(Listener.keypressed.equals("a")){
				if(hero.touching(platform)||hero.touching(platform2)||hero.touching(ground)){
					velocity = -1;
				}
			}
			if(Listener.keypressed.equals("d")){
				if(hero.touching(platform)||hero.touching(platform2)||hero.touching(ground)){
					velocity = 1;
				}
			}
			//Velocity handler
			hero.goTo((int)((hero.x)+(velocity)*5), hero.y);
			velocity = velocity*0.8 + 0.001;
			sleep(5);
			if(Math.abs(velocity)>0.5){
				sleep(45);
				hero.nextCostume();
			}
			//So that you can see "smooth" animations
			Canvas.panel.repaint();
		}
		Sprite background = new Sprite(Sprite.RECTANGLE);
		background.x = 0;
		background.y = 0;
		background.width = 1000;
		background.height = 1000;
		background.color = Color.YELLOW;
		Sprite.spriteBuffer[1] = background;
		Sprite text = new Sprite(Sprite.TEXT);
		text.x = 150;
		text.y = 450;
		text.font = new Font(Font.SANS_SERIF,Font.BOLD, 50);
		text.color = Color.BLUE;
		text.text = "You beat this stupid game!";
		Sprite.spriteBuffer[0] = text;
		Canvas.panel.repaint();
		
	}
	public static void sleep(int millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static int randint(int Min, int Max)
	{
	     return (int) (Math.random()*(Max-Min))+Min;
	}
}
