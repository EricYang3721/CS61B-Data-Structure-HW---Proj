import java.io.*;

public class Test_Xin {
	public static void main(String[] args){
		DList lst = new DList();
		DNode node1 = new DNode();
		lst.insertFront(node1);
		DNode node2 = new DNode(new Pixel(1,1,1), 2);
		lst.insertEnd(node2);
		DNode node3 = new DNode(new Pixel(2,2,2), 3);
		lst.insertEnd(node3);
		DNode node4 = new DNode(new Pixel(3,3,3), 4);
		lst.insertFront(node4);
		
		System.out.println(lst);
		System.out.println(lst.size);
	}
}