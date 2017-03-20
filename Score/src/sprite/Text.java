package sprite;

import java.awt.Color;
import java.awt.Font;

import core.Canvas;

public class Text {
	public static Text[] textBuffer = new Text[0];
	public String text;
	public Color color = Color.BLACK;
	public int x,y,size = 100;
	public int style = Font.PLAIN;
	public String font = Font.SANS_SERIF;
	public Text(String message){
		text = message;
		if(textBuffer.length == 0){
			textBuffer = new Text[1];
			textBuffer[0] = this;
		}
		else{
			util.main.push(textBuffer, this);
		}
		Canvas.panel.repaint();
	}
	public void goTo(int xpos, int ypos){
		x = xpos;
		y = ypos;
		Canvas.panel.repaint();
	}
	public String toString(){
		return text;
	}
}
