package core;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import sprite.Text;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sprite.Rect;
import sprite.Sprite;

public class Canvas {
	public int x;
	public int y;
	public JFrame frame;
	public static JPanel panel;
	public Canvas(String title, int width, int height) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(width, height);
        frame.setTitle(title);
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
	private static void repainter (Graphics g){
    	for(int i = Rect.rectBuffer.length-1; i>=0; i--){
    		g.setColor(Rect.rectBuffer[i].color);
    		g.fillRect(Rect.rectBuffer[i].x, Rect.rectBuffer[i].y, Rect.rectBuffer[i].width, Rect.rectBuffer[i].height);
    	}    	
		for(int i = Sprite.spriteBuffer.length-1; i >= 0; i--){
    		g.drawImage(Sprite.spriteBuffer[i].image,Sprite.spriteBuffer[i].x, Sprite.spriteBuffer[i].y, Sprite.spriteBuffer[i].width, Sprite.spriteBuffer[i].height, null);
    	}
    	for(int i = Text.textBuffer.length-1; i>=0; i--){
    		g.setColor(Text.textBuffer[i].color);
    		g.setFont(new Font(Text.textBuffer[i].font, Text.textBuffer[i].style, Text.textBuffer[i].size));
    		g.drawString(Text.textBuffer[i].text, Text.textBuffer[i].x, Text.textBuffer[i].y);
    	}
    }
	public void getMouse(){
		x = MouseInfo.getPointerInfo().getLocation().x;	    
		y = MouseInfo.getPointerInfo().getLocation().y;	    
	}
}


