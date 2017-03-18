package core;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

    public class Listener {
    	public static String keypressed = "";
        public static void start(Canvas canvas){
        	JPanel listenerPanel = new JPanel();
        	listenerPanel.addKeyListener(new Keychecker());
        	canvas.frame.add(listenerPanel);
        	listenerPanel.requestFocusInWindow();
        }
        public static String getKeyPressed(){
        	return keypressed;
        }
    }

    class Keychecker extends KeyAdapter {
        @Override
     public void keyPressed(KeyEvent event) {
        char ch = event.getKeyChar();
        Listener.keypressed = Character.toString(event.getKeyChar());
     }
     public void keyReleased(KeyEvent event) {
    	 Listener.keypressed = "";
     }
}   