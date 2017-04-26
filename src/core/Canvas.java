package core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import sprite.Sprite;

public class Canvas{
	//Stuff that moves around
	private static JPanel panel;
	private static Graphics2D graphics;
	public JFrame frame;
	public Canvas (String title, int width, int height){
		frame = new JFrame();
		frame.setTitle(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		panel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                graphics = (Graphics2D) g;
                
                render(g);
            }
        };
        Keyboard.start(this);
		frame.add(panel);
		frame.validate();
        graphics = (Graphics2D) frame.getGraphics();
		update();
	}
	
	//Important internal methods
	private void render(Graphics g){
		ArrayList render = Sprite.renderBuffer;
		for(int i = 0; i < render.size(); i++){
			Sprite current = (Sprite) render.get(i);
			if(current.type == Sprite.IMAGE && current.visible){
				// The required drawing location
				int drawLocationX = current.x;
				int drawLocationY = current.y;
				// Rotation information
				double rotationRequired = Math.toRadians (-current.angle);
				double locationX = current.width / 2;
				double locationY = current.height / 2;
				AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
				AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

				// Drawing the rotated image at the required drawing locations
				graphics.drawImage(op.filter((BufferedImage) current.image, null), drawLocationX, drawLocationY, null);
			}
			else if(current.type == Sprite.RECTANGLE  && current.visible){
				
				graphics.setColor(current.color);
				Rectangle original = new Rectangle(current.x, current.y, current.width, current.height);
				AffineTransform transform = new AffineTransform();
				transform.rotate(Math.toRadians(-current.angle), current.x + current.width/2, current.y + current.height/2);
				Shape rectangle = transform.createTransformedShape(original);
				graphics.fill(rectangle);
			}
			else if(current.type == Sprite.TEXT  && current.visible){
				graphics.setColor(current.color);
				graphics.setFont(current.font);
				graphics.drawString(current.text, current.x, current.y);
			}
			graphics.setColor(Color.GREEN);
			graphics.fillOval(107, 175, 115, 50);
			
			graphics.setColor(Color.ORANGE);
			graphics.drawOval(600, 10, 100, 100);
			
		}
	}
	public static void update(){
		panel.repaint();
	}
	
	//Sensing
	public boolean keypressed(int keycode){
		if(util.main.search(Keyboard.keyspressed, Integer.toString(keycode))){
			return true;
		}
		return false;
	}
	
	public boolean mouseDown(){
		return Mouse.mouseDown;
	}
	
	/**@author kgurushankar*/
	public void toggleResizable(){
		frame.setResizable(!(frame.isResizeable()));
	}
	
	/**@author kgurushankar*/
	public void toggleResizable(boolean resizable){
		frame.setResizable(resizable);
	}
}
