import java.io.*;

class tryIt {
	int x = 0;
	int y = 10;

	public void setX(int x) {
		this.x = x;
	}

	public tryIt newTry() {
		tryIt newOne = new tryIt();
		newOne.x = x;
		return newOne;
	}

	public String toString() {
		String str = "[" + x + "," + y + "]";
		return str;
	}

	public static void main(String[] args) {

		tryIt try1 = new tryIt();
		System.out.println(try1);
		try1.setX(5);
		System.out.println(try1);
		System.out.println(try1.newTry());

	}
}