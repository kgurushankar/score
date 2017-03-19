package sprite;

import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import core.Canvas;
import core.Listener;

public class Sprite {
	public static Sprite[] spriteBuffer = new Sprite[0];
	public int x = 0;
	public int y = 0;
	public int width = 100;
	public int height = 100;
	public String path = "Scratch_Cat.png";
	public Image image;
	public Image[] costumes = new Image[1];
	
	private int imageLocation = 0;
	/*Constructors and other stuff you don't care about*/
	public Sprite (){
		spriteBuffer = util.main.push(spriteBuffer, this);
		image = this.readImage(path);
		costumes[0] = image;
	}
	public Sprite(int xpos, int ypos, int w, int h) {
		x = xpos;
		y = ypos;
		width = w;
		height = h;
		spriteBuffer = util.main.push(spriteBuffer, this);
		image = this.readImage(path);
		costumes[0] = image;
	}
	public void goTo(int xpos, int ypos){
		x = xpos;
		y = ypos;
		Canvas.panel.repaint();
	}
	public void addCostume(String pathToImage){
		costumes = util.main.push(costumes, readImage(pathToImage));
	}
	//This is where all of the sprites methods live
	public void nextCostume(){
		if(imageLocation == costumes.length - 1){
			imageLocation = 0;
			image = costumes[0];
		}
		else{
			imageLocation++;
			image = costumes[imageLocation];
		}
	}
	public void setCostume(String pathToImage){
		image = readImage(pathToImage);
	}
	public boolean touching(Sprite other){
		if(other.x + other.width < x || other.x > x + width || other.y + other.height < y || other.y > y + height){
			return false;
		}
		return true;
	}
	public Image readImage(String path){
		try {
		    File pathToFile = new File(path);
		    Image out = ImageIO.read(pathToFile);
		    return out;
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
		return null;
	}
	public boolean clicked(){
		int mousex = MouseInfo.getPointerInfo().getLocation().x;	    
		int mousey = MouseInfo.getPointerInfo().getLocation().y;	
		if(mousex < x || mousex > x + width || mousey< y || mousey> y + height){
			return false;
		}
		if(Listener.mouseClicked){
			return true;
		}
		return false;
	}
}
