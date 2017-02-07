/* Nuke2.java*/ 

import java.io.*;

class Nuke2{
	public static void main(String[] args) throws Exception{
		BufferedReader keyboard;
		String inputLine;

		keyboard = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Please enter the name of a company (without spaces): ");
		System.out.flush();        /* Make sure the line is printed immediately. */
		
		inputLine = keyboard.readLine();
		
		String output = inputLine.substring(0,1)+inputLine.substring(2);
		
		System.out.println(output);
	}
}