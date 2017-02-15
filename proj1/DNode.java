/* DNode.java */
/** The listnode to store
*/


public class DNode{
	protected Pixel pix;   //object store in DNode;
	protected int number;  //number of consecutive pixel pix;
	protected DNode prev, next; 
	//DNode constructor
	public DNode(){
		pix = new Pixel();
		number = 0;
		prev = null;
		next = null;
	}
	public DNode(Pixel pl, int num){
		pix = pl;
		number = num;
		prev = null;
		next = null;
	}
	public DNode(Pixel pl, int num, DNode pr, DNode nt){
		pix = pl;
		number = num;
		prev = pr;
		next = nt;		
	}
	
	//Get information from the DNode;
	public Pixel getPixel(){
		return pix;
	}
	public int getNumber(){
		return number;
	}
	public DNode getPrev(){
		return prev;
	}
	public DNode getNext(){
		return next;
	}
	
	public String toString(){
		return pix + ", time " + number + " | ";
	}
	
}