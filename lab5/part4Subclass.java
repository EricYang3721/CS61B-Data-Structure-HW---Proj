/* part4Subclass.java */
import java.io.*;

public class part4Subclass extends part4SuperClass{
	
	
	
	public String theMethod(){
		return "SubClass";
	}
	
	public String getSuperMethod(){
		return super.theMethod();
	}
}