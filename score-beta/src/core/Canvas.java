package core;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import sprite.Sprite;

public class Canvas{
	static Graphics2D graphics;
	public Canvas (String title, int width, int height){
		JFrame frame = new JFrame();
		frame.setTitle(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JPanel panel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                graphics = (Graphics2D) g;
            }
        };
		graphics = (Graphics2D) frame.getGraphics();
		update();
	}
	public void update(){
		Sprite[] render = Sprite.renderBuffer;
		for(int i = 0; i < render.length; i++){
			if(render[i].type == Sprite.IMAGE){
				graphics.drawImage(render[i].image, render[i].x, render[i].y, render[i].width, render[i].height, null);
			}
			else if(render[i].type == Sprite.RECTANGLE){
				graphics.fillRect(render[i].x, render[i].y, render[i].width, render[i].height);
			}
			else if(render[i].type == Sprite.TEXT){
				graphics.setFont(render[i].font);
				graphics.drawString(render[i].text, render[i].x, render[i].y);
			}
			else{
				System.err.println("Invalid type.");
			}
		}
	}
}