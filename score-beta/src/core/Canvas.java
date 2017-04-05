package core;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

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
		Sprite[] render = Sprite.renderBuffer;
		for(int i = 0; i < render.length; i++){
			if(render[i].type == Sprite.IMAGE && render[i].visible){
				// The required drawing location
				int drawLocationX = render[i].x;
				int drawLocationY = render[i].y;
				// Rotation information
				double rotationRequired = Math.toRadians (-render[i].angle);
				double locationX = render[i].width / 2;
				double locationY = render[i].height / 2;
				AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
				AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

				// Drawing the rotated image at the required drawing locations
				graphics.drawImage(op.filter((BufferedImage) render[i].image, null), drawLocationX, drawLocationY, null);
			}
			else if(render[i].type == Sprite.RECTANGLE  && render[i].visible){
				
				graphics.setColor(render[i].color);
				Rectangle original = new Rectangle(render[i].x, render[i].y, render[i].width, render[i].height);
				AffineTransform transform = new AffineTransform();
				transform.rotate(Math.toRadians(-render[i].angle), render[i].x + render[i].width/2, render[i].y + render[i].height/2);
				Shape rectangle = transform.createTransformedShape(original);
				graphics.fill(rectangle);
			}
			else if(render[i].type == Sprite.TEXT  && render[i].visible){
				graphics.setColor(render[i].color);
				graphics.setFont(render[i].font);
				graphics.drawString(render[i].text, render[i].x, render[i].y);
			}
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
	
	
	
}