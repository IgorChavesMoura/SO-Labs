
public class Mail {

	private String sender;
	private String receiver;

	private String content;


	public Mail(String sender, String receiver, String content){

		this.sender = sender;
		this.receiver = receiver;
		this.content = content;


	}

	public String getSender(){

		return this.sender;

	}

	public String getReceiver(){

		return this.receiver;

	}

	public String getContent(){

		return this.content;

	}

}
