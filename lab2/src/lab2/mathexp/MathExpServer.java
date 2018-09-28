import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class MathExpServer {

	public static void main(String[] args) throws IOException {
		
		ServerSocket sock = new ServerSocket(6013);
		
		while(true) {
			
			Socket client = sock.accept();

			
			
			


			InputStream in = client.getInputStream();
		
			BufferedReader bin = new BufferedReader(new InputStreamReader(in));
		
			String line = bin.readLine();
		
				
			Double result = eval(line);

			String response;

			if(result == null){

				response = "Error at evaluate";

			} else {

				response = result.toString();

			}

			PrintWriter pout = new PrintWriter(client.getOutputStream(),true);

			pout.println(response);
			
			
			client.close();
		}
		
	}

	private static Double eval(String exp){

		String[] toks = exp.split(":");

		Double n1 = Double.valueOf(toks[1]);
		Double n2 = Double.valueOf(toks[2]);

		System.out.println(toks[0]);
		System.out.println(n1);
		System.out.println(n2);

		if(toks[0].equals("+")){

			return n1 + n2;

		} else if(toks[0].equals("-")){

			return n1 - n2;
		
		} else if(toks[0].equals("*")){

			return n1 * n2;
		
		} else if(toks[0].equals("/")){

			return n1 / n2;

		} 

		return null;

	}
}