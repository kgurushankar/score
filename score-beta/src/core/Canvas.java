package core;

import java.awt.Graphics;
import java.awt.Graphics2D;

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
		frame.add(panel);
		frame.validate();
        graphics = (Graphics2D) frame.getGraphics();
		update();
	}
	
	//Important internal methods
	private void render(Graphics g){
		Sprite[] render = Sprite.renderBuffer;
		for(int i = 0; i < render.length; i++){
			if(render[i].type == Sprite.IMAGE && render[i].visable){
				graphics.drawImage(render[i].image, render[i].x, render[i].y, render[i].width, render[i].height, null);
			}
			else if(render[i].type == Sprite.RECTANGLE  && render[i].visable){
				graphics.setColor(render[i].color);
				graphics.fillRect(render[i].x, render[i].y, render[i].width, render[i].height);
			}
			else if(render[i].type == Sprite.TEXT  && render[i].visable){
				graphics.setColor(render[i].color);
				graphics.setFont(render[i].font);
				graphics.drawString(render[i].text, render[i].x, render[i].y);
			}
			else{
				System.err.println("Invalid type.");
			}
		}
	}
	public static void update(){
		panel.repaint();
	}
}