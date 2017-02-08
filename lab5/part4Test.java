/* part4Test.java */

public class part4Test{
	public static void main(String[] args){
		part4Subclass subObj = new part4Subclass();
		System.out.println("Answer to Part 4 question (a) is: "+((part4SuperClass)subObj).theMethod());
		
		part4SuperClass superObj = new part4SuperClass();
		System.out.println("Answer to Part 4 question (b) is: "+((part4Subclass)subObj).theMethod());
		
		part4Subclass subObj2 = new part4Subclass();
		
		System.out.println("Answer to Part 4 question (c) is: "+subObj2.getSuperMethod());

	}
}