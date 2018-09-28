import java.rmi.Naming;


public class MailboxServer {

	MailboxServer(){

		try {

			Mailbox m = new MailboxImpl();

			Naming.rebind("RMI://127.0.0.1:6013/mailbox",m);

		} catch (Exception e){

			e.printStackTrace();

		}

	}

	public static void main(String[] args) {
	
		new MailboxServer();


	}


}