import java.rmi.Remote; 
import java.rmi.RemoteException; 
    
import java.util.*;

public interface Mailbox extends Remote { 
    
    static HashMap<String,List<Mail>> mails = new HashMap();

    public void send(String senderId, String receiverId, String content);
    public List<Mail> get(String id);



}