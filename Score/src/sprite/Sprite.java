package sprite;

import java.awt.Color;

import core.Canvas;

public class Sprite {
	public int x = 0;
	public int y = 0;
	public int width = 100;
	public int height = 100;
	public Color color = Color.BLUE;
	/*Constructors and other stuff you don't care about*/
	public Sprite (){
		
	}
	public Sprite(int xpos, int ypos, int w, int h, Color c) {
		x = xpos;
		y = ypos;
		width = w;
		height = h;
		color = c;
	}
	public void moveTo(int xpos, int ypos){
		x = xpos;
		y = ypos;
		Canvas.panel.repaint();
	}
}
