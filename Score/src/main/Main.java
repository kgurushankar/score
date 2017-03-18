package main;

import core.Canvas;
import sprite.Sprite;
import core.Listener;

public class Main {
	/*This is the most unstable version of score. I wouldn't recommend using it!*/
	public static void main(String[] args){
		Canvas canvas = new Canvas("Demo",1000,1000);
		Sprite sprite1 = new Sprite();
		sprite1.width = 200;
		sprite1.height = 200;
		sleep(100);
		while(true){
			if(Listener.keypressed.equals("w")&&sprite1.y>=700){
				for(double t = 0; sprite1.y<=700; t++){
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
				for(double t = 0; sprite1.y<=700; t++){
					sprite1.y = sprite1.y - (int) (-3*t*t/20);
					if(sprite1.y > 700){
						sprite1.y = 700;
						break;
					}
					sleep(15);
					Canvas.panel.repaint();
				}
			}
			if(Listener.keypressed.equals("a")){
				sprite1.x--;
			}
			if(Listener.keypressed.equals("d")){
				sprite1.x++;
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
