package core;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JFrame;
import sprites.Sprite;

public class Canvas {
	public JFrame c = new JFrame();
	Sprite sprite = new Sprite(0,0,100,100);
	Paint paint = new Paint(sprite);
	public Canvas(int width, int height, String title){
		c.setTitle(title);
		c.setBounds(0, 0, width, height);
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setVisible(true);
		
	}
	public void localPainter(Sprite insprite){
		paint.updateSprite(insprite);
		c.getContentPane().add(paint);
	}
	public static void main(String[] args){
		Canvas myCanvas = new Canvas(1000,1000,"Hello World");
		myCanvas.localPainter(new Sprite(0,0,100,100));
		myCanvas.localPainter(new Sprite(200,200,100,200));
	}
}
