package tw.idv.ixercise.course.entity;

import java.sql.Timestamp;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;
import tw.idv.ixercise.core.Core;

@Setter
@Getter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "CourseAttendee")
public class CourseAttendee extends Core {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer attendId;
	private Integer courseId;
	private Integer accountId;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp attendTime;
	@Column(insertable = false)
	private Integer status;
	private String reason;
	@Column(insertable = false)
	private Integer paymentStatus;
	@Column(insertable = false)
	private Integer commentStatus;

	public CourseAttendee() {
	}
}
