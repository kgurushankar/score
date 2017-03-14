package core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import sprites.Sprite;
public class Paint extends JPanel
{
	public Paint(Sprite sprite){
		x = sprite.x;
		y = sprite.y;
		width = sprite.width;
		height = sprite.height;
	}
	public void updateSprite(Sprite s){
		x = s.x;
		y = s.y;
		width = s.width;
		height = s.height;
	}
	public int x,y,width,height;
	public void paint(Graphics g) {
	    g.fillRect(x,y,width,height); 
	}
}