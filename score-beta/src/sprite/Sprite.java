package sprite;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	//Reference points
	public static final int IMAGE = 0, RECTANGLE = 1, TEXT = 2;
	
	//Required static
	public static Sprite[] renderBuffer  = new Sprite[0];
	
	//Core values for each sprite
	public int x = 0, y = 0, width = 100, height = 100, type = IMAGE;
	
	//Other values that depend on type
	//IMAGE
	public String path = "Scratch_Cat.png";
	public Image image = readImage(path);
	public Image[] costumes = {image};
	
	//Rectangle
	public Color color = Color.BLACK;
	
	//Font
	public Font font = new Font(Font.SANS_SERIF,Font.PLAIN,25);
	public String text = "Sample text";
	public Sprite(){
		renderBuffer = util.main.push(renderBuffer, this);
	}
	public Sprite(int spriteType, int xpos, int ypos){
		type = spriteType;
		x = xpos;
		y = ypos;
		renderBuffer = util.main.push(renderBuffer, this);
	}
	public Sprite (int types){
		type = types;
		renderBuffer = util.main.push(renderBuffer, this);
	}
	
	//static methods
	public static Image readImage(String path){
		try {
		    File pathToFile = new File(path);
		    Image out = ImageIO.read(pathToFile);
		    return out;
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
		return null;
	}
}
