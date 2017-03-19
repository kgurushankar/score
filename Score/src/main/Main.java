package main;

import core.Canvas;
import sprite.Sprite;
import core.Listener;

public class Main {
	/*Feel free to delete this file. It only exists for testing purposes!*/
	public static void main(String[] args){
		Canvas canvas = new Canvas("Demo",1000,1000);
		Sprite sprite1 = new Sprite(500,100,100,100);
		sprite1.addCostume("test2.jpg");
		sprite1.width = 150;
		sprite1.height = 150;
		Sprite sprite2 = new Sprite(500, 400, 200,200);
		sleep(100);
		while(true){
			if(sprite1.mouseDown()){
				while(sprite1.mouseDown()){
					canvas.getMouse();
					sprite1.goTo(canvas.x - sprite1.width/2, canvas.y - sprite1.height/2);
					sleep(5);
				}
				
			}
			if(Listener.keypressed.equals("w")){
				for(double t = 0; sprite1.y<=700 && !(sprite1.touching(sprite2)); t++){
					sprite1.y = sprite1.y - (int) (4*t - 3*t*t/20);
					if(sprite1.y > 700){
						sprite1.y = 700;
						break;
					}
					sleep(15);
					Canvas.panel.repaint();
					
				}
			}
			else if(sprite1.y<700){
				for(double t = 0; sprite1.y<=700 && !sprite1.touching(sprite2); t++){
					sprite1.y = sprite1.y - (int) (-3*t*t/20);
					if(sprite1.y > 700){
						sprite1.y = 700;
						break;
					}
					sleep(30);
					Canvas.panel.repaint();
				}
			}
				
			if(Listener.keypressed.equals("a")){
				sprite1.nextCostume();
				for(int i = 0; i < 35; i++){
					sprite1.x-=1;
					sleep(1);
				}
			}
			if(Listener.keypressed.equals("d")){
				sprite1.nextCostume();
				for(int i = 0; i < 35; i++){
					sprite1.x+=1;
					sleep(1);
				}
			}
			if(sprite1.touching(sprite2)){
				sprite1.goTo(0, 0);
			}
			sleep(1);
			//simplest physics
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
