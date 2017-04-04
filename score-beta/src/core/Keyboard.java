package core;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class Keyboard{
	public static String[] keyspressed = {};
	public static void start(Canvas canvas){
		JPanel listenerPanel = new JPanel();
    	listenerPanel.addKeyListener(new KeyChecker());
    	canvas.frame.add(listenerPanel);
    	listenerPanel.requestFocusInWindow();
	}
	public static boolean keyPressed(int keyCode){
		if(util.main.search(keyspressed, Integer.toString(keyCode))){
			return true;
		}
		return false;
	}
}
class KeyChecker extends KeyAdapter{
	 public void keyPressed(KeyEvent event) {
		 if(!util.main.search(Keyboard.keyspressed, Integer.toString(event.getKeyCode()))){
			 Keyboard.keyspressed = util.main.push(Keyboard.keyspressed, Integer.toString(event.getKeyCode()));
		 }
	 }
	  public void keyReleased(KeyEvent event) {
	    	 for(int i = 0; i <= Keyboard.keyspressed.length-1; i++){
	    		 if(Keyboard.keyspressed[i].equals(Integer.toString(event.getKeyCode()))){
	    			 Keyboard.keyspressed = util.main.remove(Keyboard.keyspressed, i);
	    		 }
	    	 }
	 }
}