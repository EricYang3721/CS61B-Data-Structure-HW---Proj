/* Part1.java */
import java.io.*;

public class Part1{
	public static void main(String[] args){
		System.out.println("###Testing x = y ###: ");
		X x = new X();
		Y y = new Y();
		x = y;
		System.out.println("x=y");
		
		System.out.println("\n### Testing y = (Y)x ###: ");
		y = (Y)x;
		System.out.println("y=(Y)x");
		
		System.out.println("\n### Testing xa = ya ###: ");
		X[] xa = new X[5];
		Y[] ya = new Y[5];
		xa = ya;
		System.out.println("xa=ya");
		
		/*System.out.println("\n### Testing ya = (Y[])xa ###: ");
		X[] xa2 = new X[5];
		Y[] ya2 = new Y[5];
		ya2 = (Y[])xa2;
		System.out.println("ya=(Y[])xa");*/
		
		System.out.println("\n### Testing ya = xa ###: ");
	}
}