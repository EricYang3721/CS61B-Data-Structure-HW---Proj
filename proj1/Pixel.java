/* Pixel.java */

/** The object to store the information of each pixel RGB intensities. 
*/

public class Pixel{
	protected short red, green, blue;
	
	//Pixel class constructor;
	public Pixel(){             
		red = 0;
		green = 0;
		blue = 0;
	}
	//Pixel class constructor;
	public Pixel(int r, int g, int b){
		red = (short) r;
		green = (short) g;
		blue = (short) b;
	}
	
	//Get RGB value in a pixel;
	public short getR(){
		return red;
	}
	public short getG(){
		return green;
	}
	public short getB(){
		return blue;
	}
	
	//Set the RGB in a pixel
	public void setRGB(int r, int g, int b){
		red = (short) r;
		green = (short) g;
		blue = (short) b;
	}
	
	public String toString(){
		return "r"+red+", g"+green+", b"+blue;
	}
}