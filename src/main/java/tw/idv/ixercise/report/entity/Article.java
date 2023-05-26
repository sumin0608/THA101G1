package tw.idv.ixercise.report.entity;

import java.sql.Timestamp;

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
@Table
public class Article {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer articleId;
	
	 private Integer accountId;
	
	 private String articleTitle;
	 private Timestamp articleTime;
	 private Integer articleState; 
	 private Integer articleType;
	 
	
}
