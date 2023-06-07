package tw.idv.ixercise.report.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;

@Data
public class Podcast implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Podcast(String type, Integer acountId, String message, String photo, Timestamp messagetime) {
		super();
		this.type = type;
		this.acountId = acountId;
		this.message = message;
		Photo = photo;
		this.messagetime = messagetime;
	}



	public Podcast(String type, String message) {
		super();
		this.type = type;
		this.message = message;
	}
	
	
	
	public Podcast(String type,  Integer acountId ,String message) {
		super();
		this.type = type;
		this.message = message;
		this.acountId = acountId;
	}



	public Podcast() {
		super();
	}



	private String type;
	private Integer acountId;
	private String message;
	private String Photo;
	private Timestamp messagetime;
	
	
	
	
	
}
