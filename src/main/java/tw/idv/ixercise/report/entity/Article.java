package tw.idv.ixercise.report.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Article {

	
	public Article(int articleId, int accountId, String articleTitle, Timestamp articleTime,
			Integer articleState, Integer articleType) {
	
		this.articleId = articleId;
		this.accountId = accountId;
		this.articleTitle = articleTitle;
		this.articleTime = articleTime;
		this.articleState = articleState;
		this.articleType = articleType;
	}
	
	public Article(int articleId, int accountId, String articleTitle, Date articleTime, int articleState, int articleType) {
		this.articleId = articleId;
		this.accountId = accountId;
		this.articleTitle = articleTitle;
		this.articleTime = (Timestamp) articleTime;
		this.articleState = articleState;
		this.articleType = articleType;
	}
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer articleId;
	
	@Column
	 private Integer accountId;
	@Column 
	private Integer sportType; 
	
	@Column
	 private String articleTitle;
	@Column 
	private String articleText;
	@Column 
	private Timestamp articleTime;
	@Column 
	private Timestamp articleChamgeTime;
	@Column 
	private Integer articleState; 
	@Column 
	private Integer articleType;
	
}
