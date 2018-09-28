import java.rmi.Naming;


public class MailboxClient {

	public static void main(String[] args) {
		

		try {

			Mailbox m = (Mailbox) Naming.lookup("//127.0.0.1:6013/mailbox");

			Scanner sc = new Scanner(System.in);

			System.out.println("Comandos: ");
			System.out.println("s - Enviar mensagem");
			System.out.println("g - Ver minhas mensagens");


			System.out.println("Digite o comando: ");


			String cmd = sc.nextLine();		

		

			if(cmd.equals("s")){

				System.out.println("Digite seu id");
				String senderId = sc.nextLine();

				System.out.println("Digite o destinatario");
				String receiverId = sc.nextLine();

				System.out.println("Digite a mensagem");
				String content = sc.nextLine();

				m.send(senderId, receiverId, content);

				System.out.println("Message sent!");

			} else if(cmd.equals("g")){

				System.out.println("Digite seu id");
				String id = sc.nextLine();

				List<Mail> mails = m.get(id);

				if(mails == null){

					System.out.println("No messages or client not found");
					return;
				}

				for(Mail mail : mails){

					System.out.println("From: " + mail.getSender());
					System.out.println();
					System.out.println("	" + mail.getContent());
					System.out.println("--------------------------");

				}

			}


		} catch (Exception e){

			e.printStackTrace();
		}

		



	}


}