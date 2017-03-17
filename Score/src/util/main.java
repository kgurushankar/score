package util;

import sprite.Sprite;

public class main {
	public static Sprite[] push(Sprite[] push, Sprite pushable){
		Sprite[] temp = new Sprite[push.length+1];
		for(int i = 0; i < push.length; i++){
			temp[i] = push[i];
		}
		temp[temp.length-1] = pushable;
		return temp;
	}
}
