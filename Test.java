import java.io.*;

public class Test {
	public static void main(String[] args){
		double total = 98000.0*0.15;
		for(int i = 2; i < 30; i++){
			total = total*1.08 + 98000*0.15;
		}
		
		
		/*int age=60;
		while (total > 0){
			total = (total-100000);
			age++;
		}*/
		//System.out.println(age);
		System.out.println(total);
	}
}