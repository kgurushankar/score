package core;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import main.Main;
import sprite.Sprite;

public class Canvas {
	public static JPanel panel;
	private static void repainter (Graphics g){
    	for(int i = 0; i < Sprite.spriteBuffer.length; i++){
    		g.drawImage(Sprite.readImage(Sprite.spriteBuffer[i].image), Sprite.spriteBuffer[i].x, Sprite.spriteBuffer[i].y, null);
    	}
    }
	public static void startCanvas() {
        JFrame frame = new JFrame();
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(600, 400);
        panel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                repainter(g);
            }
        };
        
        frame.add(panel);
        frame.validate(); // because you added panel after setVisible was called
        frame.repaint(); // because you added panel after setVisible was called
    }
}
