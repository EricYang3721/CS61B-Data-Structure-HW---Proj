import java.net.*;
import java.io.*;

public class URLReader {
    public static void main(String[] args) throws Exception {

        URL oracle = new URL("http://www.oracle.com/");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine;
		int i = 0;
        while (i<5){
            inputLine = in.readLine();
			System.out.println(inputLine);
			i++;
		}
        in.close();
    }
}