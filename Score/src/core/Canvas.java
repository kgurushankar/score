package core;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import main.Main;

public class Canvas {
	
	private static void repainter (Graphics g){
    	for(int i = 0; i < Main.spriteBuffer.length; i++){
    		g.setColor(Main.spriteBuffer[i].color);
    		g.fillRect(Main.spriteBuffer[i].x, Main.spriteBuffer[i].y, Main.spriteBuffer[i].width, Main.spriteBuffer[i].height);
    	}
    }
	public static void startCanvas() {
        JFrame frame = new JFrame();
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(600, 400);

        JPanel panel = new JPanel() {
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
