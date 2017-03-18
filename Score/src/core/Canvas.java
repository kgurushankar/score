package core;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import sprite.Sprite;

public class Canvas {
	public static JPanel panel;
	private static void repainter (Graphics g){
    	for(int i = 0; i < Sprite.spriteBuffer.length; i++){
    		g.drawImage(Sprite.spriteBuffer[i].image,Sprite.spriteBuffer[i].x, Sprite.spriteBuffer[i].y, Sprite.spriteBuffer[i].width, Sprite.spriteBuffer[i].height, null);
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
