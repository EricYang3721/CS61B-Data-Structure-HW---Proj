/* DList */

/** The list to store Run-length encoded images */
/** it contains a sentinal and  size of the list */

public class DList{
	protected int size;
	protected DNode header, tailer;
	
	public DList(){
		size = 0;
		header = new DNode(null,0, null,null);
		tailer = new DNode(null,0, header, null);
	}
	
	public boolean isEmpty(){
		return (size == 0);
	}
	
	public void insertFront(DNode fro){
		if(size == 0){
			header.next = fro;			
			fro.prev = header;
			fro.next = tailer;
			tailer.next = fro;
			size++;
		} else{
			header.next.prev = fro;
			fro.next = header.next;
			fro.prev = header;
			header.next = fro;
			size++;
		}
	}
	
	public void insertEnd(DNode end){
		if(size == 0){
			header.next = end;			
			end.prev = header;
			end.next = tailer;
			tailer.next = end;
			size++;
		} else{
			end.next = tailer;
			end.prev = tailer.next;
			tailer.next.next = end;
			tailer.next = end;
			size++;
		}
	}
	
	public String toString(){
		String str = "[";
		DNode ptr = header.next;
		while(ptr!=tailer){
			str = str + ptr.toString();
			ptr = ptr.next;
			
		}
		str = str+"]";
		return str;
	}
}