import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket sock = new ServerSocket(6013);
		
		while(true) {
			
			Socket client = sock.accept();

			System.out.println("New client connected");
			
			PrintWriter pout = new PrintWriter(client.getOutputStream(),true);
			
			pout.println(new Date());
			
			
			client.close();
		}
		
	}
	
}
