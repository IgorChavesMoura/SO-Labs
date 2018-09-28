import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.net.Socket;
import java.net.UnknownHostException;



public class MathExpClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket sock = new Socket("127.0.0.1", 6013);

		PrintWriter pout = new PrintWriter(sock.getOutputStream(),true);

		Scanner sc = new Scanner(System.in);

		pout.println(sc.nextLine());
		
		InputStream in = sock.getInputStream();

		while(in.available() == 0){

			

		}
		
		BufferedReader bin = new BufferedReader(new InputStreamReader(in));
		
		String line;
		
		while((line = bin.readLine()) != null) {
			
			System.out.println(line);
			
		}
		
		sock.close();
		
	}

}