import java.io.*;

public class Test {
	public static void main(String[] args){
		DList lst = new DList;
		DNode node1 = new DNode();
		lst.insterFront(node1);
		DNode node2 = new DNode(new Pixel(1,1,1), 2);
		lst.insterFront(node2);
		DNode node3 = new DNode(new Pixel(2,2,2), 3);
		lst.insertEnd(node3);
		System.out.println(lst);
		
	}
}