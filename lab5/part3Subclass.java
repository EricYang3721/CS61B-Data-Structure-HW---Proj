/* part3Subclass */
import java.io.*;

public class part3Subclass extends part3SuperClass implements part3Interface{
	public static void main(String[] args){
		System.out.println("pi value from part3SuperClass is: "+part3SuperClass.pi);
		System.out.println("pi value from par3Interface is: "+part3Interface.pi);
	}
}