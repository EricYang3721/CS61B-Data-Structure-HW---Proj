import java.io.*;

public class Test {
	public static void plusSSS(String tt){
		tt = tt+"SSS";
		System.out.println(tt);
	}
   public static void main(String args[]) {
      String str1 = "Strings are immutable";
      String str2 = new String("Strings are immutable");
      String str3 = new String("Integers are not immutable");
      plusSSS(str1);
	  System.out.println(str1);
	  
	  
	  /*Integer p1 = new Integer(10);
	  Integer p2 = new Integer(5);
	  System.out.println(p1.compareTo(p2));
	  
      int result = str1.compareTo( str2 );
      System.out.println(result);
      
      result = str2.compareTo( str3 );
      System.out.println(result);*/
   }
}