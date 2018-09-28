import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject; 

public class MailboxImpl implements Mailbox {

	private static HashMap<String,List<Mail>> mails = new HashMap();

    public void send(String senderId, String receiverId, String content){

    	List<Mail> receiverMails = mails.get(receiverId);

    	if(receiverMails == null){

    		receiverMails = new ArrayList();


    	}

    	receiverMails.add(new Mail(senderId,receiverId,content));

    	mails.put(receiverMails);

    }
    public List<Mail> get(String id){

    	return mails.get(id);

    }

}