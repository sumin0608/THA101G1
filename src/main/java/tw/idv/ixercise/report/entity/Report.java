package tw.idv.ixercise.report.entity;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tw.idv.ixercise.core.Core;


@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Report {
	
	private static final long serialVersionUID = -4157805481963417348L;

	   @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
     	private Integer reportId;
		private Integer accountId;
	    private String reportType;
	    private Integer accountId2;
	    private Timestamp reportTime;
	    private String reportReason;
	    private Integer reportStatus;
	    private String reportPicture;
		@Override
		public String toString() {
			return "Report [reportId=" + reportId + ", accountId=" + accountId + ", reportType=" + reportType
					+ ", accountId2=" + accountId2 + ", reportTime=" + reportTime + ", reportReason=" + reportReason
					+ ", reportStatus=" + reportStatus + ", reportPicture=" + reportPicture + "]";
		}
	    

	   

	
	    
	    
	    
	    
		
		
	
}
