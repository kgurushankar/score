package core;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
		for(int i = Sprite.spriteBuffer.length-1; i >= 0; i--){
    		if(Sprite.spriteBuffer[i].type == 1){
    			g.setColor(Sprite.spriteBuffer[i].color);
    			g.fillRect(Sprite.spriteBuffer[i].x, Sprite.spriteBuffer[i].y, Sprite.spriteBuffer[i].width, Sprite.spriteBuffer[i].height);
    		}
    		else if(Sprite.spriteBuffer[i].type == 2){
    			g.setColor(Sprite.spriteBuffer[i].color);
    			g.setFont(Sprite.spriteBuffer[i].font);
    			g.drawString(Sprite.spriteBuffer[i].text, Sprite.spriteBuffer[i].x, Sprite.spriteBuffer[i].y);
    		}
    		else if(Sprite.spriteBuffer[i].type == 0){
    			g.drawImage(Sprite.spriteBuffer[i].image,Sprite.spriteBuffer[i].x, Sprite.spriteBuffer[i].y, Sprite.spriteBuffer[i].width, Sprite.spriteBuffer[i].height, null);
    		}
    	}
    }
	public void getMouse(){
		x = MouseInfo.getPointerInfo().getLocation().x;	    
		y = MouseInfo.getPointerInfo().getLocation().y;	    
	}
}


