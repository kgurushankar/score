package sprite;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import core.Canvas;
import core.Mouse;

public class Sprite {
	//Reference points
	public static final int IMAGE = 0, RECTANGLE = 1, TEXT = 2;
	
	//Required static
	public static Sprite[] renderBuffer  = new Sprite[0];
	
	//Core values for each sprite
	public int x = 0, y = 0, width = 100, height = 100, type = IMAGE;
	public double angle = 0;
	public boolean visible = true;
	//Other values that depend on type
	//IMAGE
	public String path = "";
	public Image image = readImage(path);
	public Image[] costumes = {image};
	
	public int costumeNumber = 0;
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
	
	//Sprite methods
	
	/*Motion methods
	 * 
	 * Since the score library is heavily based on Scratch, many of the methods line up
	 * These methods are categorized by Scratch as motion methods
	 */
	public void moveSteps(int steps){
		x = (int) Math.ceil(x + steps * Math.cos(Math.toRadians((double) angle)));
		y = (int) Math.ceil(y - steps * Math.sin(Math.toRadians((double)angle)));
		Canvas.update();
	}
	public void turndegrees(int degrees){
		angle = angle + degrees;
	}
	public void pointInDirection(int degrees){
		angle = degrees;
	}
	public void pointTowardsMouse(){
		if(Mouse.getx() > x && Mouse.gety() < y){
			angle =  Math.toDegrees(((double)(y - Mouse.gety()))/(Mouse.getx() - x));
		}
		else if(Mouse.getx() < x && Mouse.gety() < y){
			angle = 180 - Math.toDegrees(((double)(y - Mouse.gety()))/(x - Mouse.getx()));
		}
		else if(Mouse.getx() < x && Mouse.gety() > y){
			angle = 180 + Math.toDegrees(((double)(Mouse.gety() - y))/(x - Mouse.getx()));
		}
		else if(Mouse.getx() > x && Mouse.gety() > y){
			angle = Math.toDegrees(((double)(Mouse.gety() - y))/(x - Mouse.getx()));
		}
	}
	public void pointTowardsSprite(Sprite other){
		if(other.x > x && other.y < y){
			angle =  Math.toDegrees(((double)(y - other.y))/(other.x - x));
		}
		else if(other.x < x && other.y < y){
			angle = 180 - Math.toDegrees(((double)(y - other.y))/(x - other.x));
		}
		else if(other.x < x && other.y > y){
			angle = 180 + Math.toDegrees(((double)(other.y - y))/(x - other.x));
		}
		else if(other.x > x && other.y > y){
			angle = Math.toDegrees(((double)(other.y - y))/(x - other.x));
		}
	}
	public void goTo(int xCoordinate, int yCoordinate){
		x = xCoordinate;
		y = yCoordinate;
		Canvas.update();
	}
	public void goToMouse(){
		x = Mouse.getx();
		y = Mouse.gety();
		Canvas.update();
	}
	public void changex(int value){
		x += value;
		Canvas.update();
	}
	public void changey(int value){
		y += value;
		Canvas.update();
	}
	
	//Looks blocks
	public void visible(boolean visability){
		visible = visability;
		Canvas.update();
	}
	
	public void switchCostume(int costumeNumber){
		image = costumes[costumeNumber];
		Canvas.update();
	}
	
	public void nextCostume(){
		if(costumeNumber + 1 < costumes.length){
			costumeNumber++;
			switchCostume(costumeNumber);
		}
		else{
			costumeNumber = 0;
			switchCostume(costumeNumber);
		}
	}
	
	public void changeSizeBy(double percent){
		width = (int) (width * percent / 100);
		height = (int) (height * percent / 100);
		Canvas.update();
	}
	
	public void setSizeTo(int newWidth, int newHeight){
		width = newWidth;
		height = newHeight;
		Canvas.update();
	}
	public void setLayerTo(int newLayer) {
	    Sprite last = renderBuffer[renderBuffer.length-1];

	    // Copy sub-array starting at newLayer to newLayer+1
	    System.arraycopy(renderBuffer, newLayer, renderBuffer, newLayer + 1, renderBuffer.length - newLayer - 1);

	    renderBuffer[newLayer] = last;
	}
	public void sendToFront() {
	   setLayerTo(renderBuffer.length-1);
	}
	
	//Sensing
	
	public boolean touchingMouse(){
		if(Mouse.getx()<x + width && Mouse.getx() > x){
			if(Mouse.gety()<y + height && Mouse.gety() > y){
				return true;
			}
		}
		return false;
	}
	
	public int distanceToMousePointer(){
		int xpos = Mouse.getx() - x;
		int ypos = Mouse.gety() - y;
		return (int) Math.sqrt(xpos * xpos + ypos * ypos);
	}
}
