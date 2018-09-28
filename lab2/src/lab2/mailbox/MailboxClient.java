import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.net.Socket;
import java.net.UnknownHostException;


public class MailboxClient {


	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket sock = new Socket("127.0.0.1", 6013);

		PrintWriter pout = new PrintWriter(sock.getOutputStream(),true);

		Scanner sc = new Scanner(System.in);

		System.out.println("Comandos: ");
		System.out.println("s - Enviar mensagem");
		System.out.println("g - Ver minhas mensagens");


		System.out.println("Digite o comando: ");


		String cmd = sc.nextLine();		

		String request = "";

		if(cmd.equals("s")){

			System.out.println("Digite seu id");
			String senderId = sc.nextLine();

			System.out.println("Digite o destinatario");
			String receiverId = sc.nextLine();

			System.out.println("Digite a mensagem");
			String content = sc.nextLine();

			request = "send:" + senderId + ":" + receiverId + ":" + content;


		} else if(cmd.equals("g")){

			System.out.println("Digite seu id");
			String id = sc.nextLine();

			request = "get:" + id;


		}

		pout.println(request);

		InputStream in = sock.getInputStream();

		while(in.available() == 0);
		
		BufferedReader bin = new BufferedReader(new InputStreamReader(in));
		
		String line;
		
		while((line = bin.readLine()) != null) {
			
			System.out.println(line);
			
		}
		
		sock.close();


	}


}