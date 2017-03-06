public class Comparator implements Comparable{
	Object item;
	public int compareTo(Object obj){
	   return Integer.compare((int)this.item, (int)((Comparator)obj).item);
  }

}