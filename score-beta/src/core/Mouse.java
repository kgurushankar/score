package core;

import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse {
	public static int getx(){
		return MouseInfo.getPointerInfo().getLocation().x;
	}
	public static int gety(){
		return MouseInfo.getPointerInfo().getLocation().y;
	}
	public static boolean mouseDown = false;
}

class mouseListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		Mouse.mouseDown = true;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		Mouse.mouseDown = false;
		
	}
	
}
