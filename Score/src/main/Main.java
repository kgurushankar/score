package main;

import core.Canvas;
import sprite.Sprite;
import core.Listener;

public class Main {
	/*Feel free to delete this file. It only exists for testing purposes!*/
	public static void main(String[] args){
		//This is a simple game where you have to bump into another cat
		Sprite hero = new Sprite();
		hero.addCostume("test2.jpg");
		Sprite platform = new Sprite(600,600,300,100);
		Sprite platform2 = new Sprite(300,200,300,100);
		Sprite goal = new Sprite(300,100,100,100);
		Sprite ground = new Sprite(0,900,1000,100);
		//you might want to change the path to the floor and ground
		platform.setCostume("C:\\tmp\\assets\\floor.jpg");
		platform2.setCostume("C:\\tmp\\assets\\floor.jpg");
		ground.setCostume("C:\\tmp\\assets\\floor.jpg");
		Canvas canvas = new Canvas("Quick demo",1000,1000);
		while(true){
			//This is the main game script
			if(hero.touching(goal)){
				hero.goTo(0, 500);
			}
			if(Listener.keypressed.equals("w")&&(hero.touching(ground)||hero.touching(platform)||hero.touching(platform2))){
				int maxHeight = hero.y;
				for(double t = 0; hero.y<=800; t++){
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
				
			if(Listener.keypressed.equals("a")){
				hero.nextCostume();
				for(int i = 0; i < 35; i++){
					hero.x-=1;
					sleep(1);
				}
			}
			if(Listener.keypressed.equals("d")){
				hero.nextCostume();
				for(int i = 0; i < 35; i++){
					hero.x+=1;
					sleep(1);
				}
			}
			sleep(1);
			//So that you can see "smooth" animations
			Canvas.panel.repaint();
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
