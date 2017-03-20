package sprite;

import java.awt.Color;
/*This is temporary! We will soon change this into a generic shape buffer manager!*/
public class Rect {
	public static Rect rectBuffer[] = new Rect[0];
	public int x,y,width,height = 100;
	public Color color = Color.BLACK;
	public Rect(int xpos,int ypos,int w,int h){
		x = xpos;
		y = ypos;
		width = w;
		height = h;
		if(rectBuffer.length == 0){
			rectBuffer = new Rect[1];
			rectBuffer[0] = this;
		}
		else{
			util.main.push(rectBuffer, this);
		}
	}
}
