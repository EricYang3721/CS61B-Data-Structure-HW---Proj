public class Comparator implements Comparable{
	Object item;
	public static int compareTo(Object obj1, Object obj2){
	   return Integer.compare((int)this.item, (int)((Comparator)obj).item);
  }

}