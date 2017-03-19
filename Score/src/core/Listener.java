package core;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

    public class Listener {
    	public static String keypressed = "";
    	public static boolean mouseClicked = false;
        public static void start(Canvas canvas){
        	JPanel listenerPanel = new JPanel();
        	listenerPanel.addKeyListener(new Keychecker());
        	listenerPanel.addMouseListener(new Keychecker());
        	canvas.frame.add(listenerPanel);
        	listenerPanel.requestFocusInWindow();
        }
        public static String getKeyPressed(){
        	return keypressed;
        }
    }

    class Keychecker extends KeyAdapter implements MouseListener{
        @Override
     public void keyPressed(KeyEvent event) {
        char ch = event.getKeyChar();
        Listener.keypressed = Character.toString(event.getKeyChar());
     }
     public void keyReleased(KeyEvent event) {
    	 Listener.keypressed = "";
     }
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		Listener.mouseClicked = true;
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		Listener.mouseClicked = false;
	}
     
}   