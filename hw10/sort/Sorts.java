/* Sorts.java */

package sort;
import java.util.*;
import java.lang.*;

public class Sorts {

  /**
   *  Place any final static fields you would like to have here.
   **/
   


  /**
   *  countingSort() sorts an array of int keys according to the
   *  values of _one_ of the base-16 digits of each key.  "whichDigit"
   *  indicates which digit is the sort key.  A zero means sort on the least
   *  significant (ones) digit; a one means sort on the second least
   *  significant (sixteens) digit; and so on, up to a seven, which means
   *  sort on the most significant digit.
   *  @param key is an array of ints.  Assume no key is negative.
   *  @param whichDigit is a number in 0...7 specifying which base-16 digit
   *    is the sort key.
   *  @return an array of type int, having the same length as "keys"
   *    and containing the same keys sorted according to the chosen digit.
   *
   *    Note:  Return a _newly_ created array.  DO NOT CHANGE THE ARRAY keys.
   **/
  public static int[] countingSort(int[] keys, int whichDigit) {
    // Replace the following line with your solution.
	int[] resultArray = new int[keys.length];
	int[] processKeys = new int[keys.length];
	LinkedList[] storage = new LinkedList[16];
	for(int i = 0; i < 16; i++){
		storage[i] = new LinkedList();
	}	
	
	for(int i = 0; i<keys.length; i++){
		processKeys[i] = keys[i];
		if(whichDigit != 0){
			processKeys[i] = processKeys[i]/((int)Math.pow(16, whichDigit));
		}
		storage[processKeys[i] & 15].add(keys[i]);
		
	}
	/*for(int i = 0; i<16; i++){
		System.out.println(storage[i]);
	}*/
	
	
	int index = 0;
	for(int i = 0; i<16;i++){
		int size = storage[i].size();
		while(size!=0){
			//System.out.println(storage[i].remove());
			resultArray[index]=(int)storage[i].removeFirst();
			
			size--;
			//System.out.println(index);
			//System.out.println(index+": "+resultArray[index]);	
			index++;			
		}
		
	}
		
	
	/*System.out.print("[");
	for(int i = 0; i<keys.length; i++){
		System.out.print(Integer.toString(resultArray[i], 16)+", ");		
	}
	System.out.println(" ");*/
	
    return resultArray;
  }

  /**
   *  radixSort() sorts an array of int keys (using all 32 bits
   *  of each key to determine the ordering).
   *  @param key is an array of ints.  Assume no key is negative.
   *  @return an array of type int, having the same length as "keys"
   *    and containing the same keys in sorted order.
   *
   *    Note:  Return a _newly_ created array.  DO NOT CHANGE THE ARRAY keys.
   **/
  public static int[] radixSort(int[] keys) {
    // Replace the following line with your solution.
	//int[] result = new int[keys.length];
	for(int i=0; i<8;i++){   //*******************************should be 8 rather than 1
		keys = countingSort(keys, i);
		//yell(result);
	}
    return keys;
  }

  /**
   *  yell() prints an array of int keys.  Each key is printed in hexadecimal
   *  (base 16).
   *  @param key is an array of ints.
   **/
  public static void yell(int[] keys) {
    System.out.print("keys are [ ");
    for (int i = 0; i < keys.length; i++) {
		System.out.print(Integer.toString(keys[i], 16) + " ");
		//System.out.print(keys[i] + " ");
    }
    System.out.println("]");
  }

  /**
   *  main() creates and sorts a sample array.
   *  We recommend you add more tests of your own.
   *  Your test code will not be graded.
   **/
  public static void main(String[] args) {
    int[] keys = { Integer.parseInt("60013879", 16),
                   Integer.parseInt("11111119", 16),
                   Integer.parseInt("2c735010", 16),
                   Integer.parseInt("2c732010", 16),
                   Integer.parseInt("7fffffff", 16),
                   Integer.parseInt("4001387c", 16),
                   Integer.parseInt("10111119", 16),
                   Integer.parseInt("529a7385", 16),
                   Integer.parseInt("1e635010", 16),
                   Integer.parseInt("28905879", 16),
                   Integer.parseInt("00011119", 16),
                   Integer.parseInt("00000000", 16),
                   Integer.parseInt("7c725010", 16),
                   Integer.parseInt("1e630010", 16),
                   Integer.parseInt("111111e5", 16),
                   Integer.parseInt("61feed0c", 16),
                   Integer.parseInt("3bba7387", 16),
                   Integer.parseInt("52953fdb", 16),
                   Integer.parseInt("40013879", 16) };

    yell(keys);
	
	//System.out.println("Before sorting: " + keys);
    keys = radixSort(keys);
    yell(keys);
  }

}
