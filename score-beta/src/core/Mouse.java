package core;

import java.awt.MouseInfo;

public class Mouse {
	public static int getx(){
		return MouseInfo.getPointerInfo().getLocation().x;
	}
	public static int gety(){
		return MouseInfo.getPointerInfo().getLocation().y;
	}
}
