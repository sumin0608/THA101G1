package tw.idv.ixercise.report.entity;

import java.sql.Time;
import java.util.Arrays;

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
		private Integer MemberId;
	    private Integer reportType;
	    private Integer articleId;
	    private Time reportTime;
	    private String reportReason;
	    private Integer reportStatus;
	    private Byte[] reportPicture;
	    
	    @Override
	    public String toString() {
	    	return "Report [reportId=" + reportId + ", MemberId=" + MemberId + ", reportType=" + reportType + ", articleId="
	    			+ articleId + ", reportTime=" + reportTime + ", reportReason=" + reportReason + ", reportStatus="
	    			+ reportStatus + ", reportPicture=" + Arrays.toString(reportPicture) + "]";
	    }
	    
		
		
	
}
