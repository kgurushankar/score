package sprite;

import java.awt.Color;

public class Sprite {
	public int x = 0;
	public int y = 0;
	public int width = 100;
	public int height = 100;
	public Color color = Color.BLUE;
	public Sprite (Color c){
		
	}
	public Sprite(int xpos, int ypos, int w, int h, Color c) {
		x = xpos;
		y = ypos;
		width = w;
		height = h;
		color = c;
	}
}
