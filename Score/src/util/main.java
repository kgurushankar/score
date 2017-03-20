package util;

import java.awt.Image;

import sprite.Rect;
import sprite.Sprite;
import sprite.Text;

public class main {
	public static Sprite[] push(Sprite[] push, Sprite pushable){
		Sprite[] temp = new Sprite[push.length+1];
		for(int i = 0; i < push.length; i++){
			temp[i] = push[i];
		}
		temp[temp.length-1] = pushable;
		return temp;
	}
	public static Image[] push(Image[] push, Image pushable){
		Image[] temp = new Image[push.length+1];
		for(int i = 0; i < push.length; i++){
			temp[i] = push[i];
		}
		temp[temp.length-1] = pushable;
		return temp;
	}
	public static Text[] push(Text[] push, Text pushable){
		Text[] temp = new Text[push.length+1];
		for(int i = 0; i < push.length; i++){
			temp[i] = push[i];
		}
		temp[temp.length-1] = pushable;
		return temp;
	}
	public static Rect[] push(Rect[] push, Rect pushable){
		Rect[] temp = new Rect[push.length+1];
		for(int i = 0; i < push.length; i++){
			temp[i] = push[i];
		}
		temp[temp.length-1] = pushable;
		return temp;
	}
}
