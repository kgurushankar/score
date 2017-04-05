package util;

import java.awt.Image;
import sprite.Sprite;

public class main {
	//Push allows you to add to an array
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
	public static String[] push(String[] push, String pushable){
		String[] temp = new String[push.length+1];
		for(int i = 0; i < push.length; i++){
			temp[i] = push[i];
		}
		temp[temp.length-1] = pushable;
		return temp;
	}
	//Delete allows you to delete elements from an array
	public static String[] remove(String[] original, int element){
	    String[] n = new String[original.length - 1];
	    System.arraycopy(original, 0, n, 0, element );
	    System.arraycopy(original, element+1, n, element, original.length - element-1);
	    return n;
	}
	//Search allows you to search within an array
	public static boolean search(String[] area, String item){
		for(int i = 0; i < area.length; i++){
			try{
				if(area[i].equals(item)){
					return true;
				}
			}
			catch(Exception e){
				
			}
		}
		return false;
	}
}
