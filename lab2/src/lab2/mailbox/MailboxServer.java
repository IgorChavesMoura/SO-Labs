import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import java.util.*;


public class MailboxServer {

	private static HashMap<String,List<Mail>> mails = new HashMap();


	public static void main(String[] args) throws UnknownHostException, IOException {
		
		ServerSocket sock = new ServerSocket(6013);


		while(true) {

			Socket client = sock.accept();

			InputStream in = client.getInputStream();
		
			BufferedReader bin = new BufferedReader(new InputStreamReader(in));
		
			String line = bin.readLine();

			String[] toks = line.split(":");

			PrintWriter pout = new PrintWriter(client.getOutputStream(),true);

			System.out.println(line);

			if(toks[0].equals("get")){

				Boolean found;

				List<Mail> clientMails = mails.get(toks[1]);

				if(clientMails == null){

					found = false;

				} else {

					found = true;

				}

				
				if(found){

					for(Mail mail : clientMails){

						pout.println("From: " + mail.getSender());
						pout.println();
						pout.println("	" + mail.getContent());
						pout.println("--------------------------");

					}

				} else {


					pout.println("Client not found or no messages!");

					
				}

			} else if(toks[0].equals("send")){

				Mail mail = new Mail(toks[1],toks[2],toks[3]);

				List<Mail> receiverMails = mails.get(toks[2]);

				if(receiverMails == null){

					receiverMails = new ArrayList();


				}

				receiverMails.add(mail);

				mails.put(toks[2],receiverMails);

				pout.println("Message sent successfully!");

			}

			System.out.println(mails);

			client.close();


		}
	}


}