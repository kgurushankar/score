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
		try {
			Listener.start(canvas);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true){
			if(Listener.keypressed.equals("w")){
				sprite1.y--;
			}
			if(Listener.keypressed.equals("a")){
				sprite1.x--;
			}
			if(Listener.keypressed.equals("s")){
				sprite1.y++;
			}
			if(Listener.keypressed.equals("d")){
				sprite1.x++;
			}
			sleep(10);
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
