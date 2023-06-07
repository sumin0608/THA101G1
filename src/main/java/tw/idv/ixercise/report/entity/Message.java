package tw.idv.ixercise.report.entity;

import java.io.Serializable;
import java.sql.Timestamp;


import lombok.Data;

@Data
public class Message implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type;
	private Integer sender;
	private Integer receiver;
	
	private String message;
	private Timestamp messageTime;
	
	
	public Message(String type, Integer sender, Integer receiver, String message, Timestamp messageTime) {
		super();
		this.type = type;
		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
		this.messageTime = messageTime;
	}

	public Message(String type, Integer sender, Integer receiver, String message) {
		super();
		this.type = type;
		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [messageTime=" + messageTime + "]";
	}
	

	
	

}
