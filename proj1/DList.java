/* DList */

/** The list to store Run-length encoded images */
/** it contains a sentinal and  size of the list */

public class DList{
	protected int size;
	protected DNode sentinal;
	
	public DList(){
		size = 0;
		sentinal = new DNode(null, 0, sentinal, sentinal);
	}
	
	public boolean isEmpty(){
		return (size == 0);
	}
	
	public void insertFront(DNode fro){
		if(size == 0){
			sentinal.next = fro;
			sentinal.prev = fro;
			fro.next = sentinal;
			fro.prev = sentinal;
			size++;
		} else{
			sentinal.prev.prev = fro;
			fro.next = sentinal.prev;
			sentinal.prev = fro;
			fro.prev = sentinal;
			size++;
		}
	}
	
	public void insertEnd(DNode end){
		if(size == 0){
			sentinal.next = end;
			sentinal.prev = end;
			end.next = sentinal;
			end.prev = sentinal;
			size++;
		} else{
			end.next = sentinal;
			end.prev = sentinal.next;
			sentinal.next.next = end;
			sentinal.next = end;
			size++;
		}
	}
	
	public String toString(){
		String str = "[";
		DNode ptr = sentinal.prev;
		while(ptr != sentinal){
			str = str + ptr.toString();
			ptr = ptr.next;			
		}
		return str;
	}
}