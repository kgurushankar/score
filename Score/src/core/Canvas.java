package core;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import sprite.Sprite;

public class Canvas {
	public JFrame frame;
	public static JPanel panel;
	private static void repainter (Graphics g){
    	for(int i = 0; i < Sprite.spriteBuffer.length; i++){
    		g.setColor(Color.WHITE);
    		g.fillRect(0, 0, 1000, 1000);
    		g.drawImage(Sprite.spriteBuffer[i].image,Sprite.spriteBuffer[i].x, Sprite.spriteBuffer[i].y, Sprite.spriteBuffer[i].width, Sprite.spriteBuffer[i].height, null);
    	}
    }
	public Canvas(String title, int width, int height) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(width, height);
        frame.setTitle(title);
        frame.setBackground(Color.RED);
        panel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
               
                repainter(g);
            }
        };
        frame.add(panel);
        frame.validate(); // because you added panel after setVisible was called
        frame.repaint(); // because you added panel after setVisible was called
        Listener.start(this); //Starts up the keylistener
        frame.repaint();
    }
}


