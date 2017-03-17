package sprite;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.Main;
import util.*;
import core.Canvas;

public class Sprite {
	public static Sprite[] spriteBuffer = new Sprite[0];
	public int x = 0;
	public int y = 0;
	public int width = 100;
	public int height = 100;
	public String image = "test.jpg";
	/*Constructors and other stuff you don't care about*/
	public Sprite (){
		spriteBuffer = util.main.push(spriteBuffer, this);
	}
	public Sprite(int xpos, int ypos, int w, int h) {
		x = xpos;
		y = ypos;
		width = w;
		height = h;
		spriteBuffer = util.main.push(spriteBuffer, this);
	}
	public void goTo(int xpos, int ypos){
		x = xpos;
		y = ypos;
		Canvas.panel.repaint();
	}
	public static Image readImage(String path){
		try {
		    File pathToFile = new File(path);
		    Image image = ImageIO.read(pathToFile);
		    return image;
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
		return null;
	}
}
