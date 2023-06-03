package tw.idv.ixercise.course.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import tw.idv.ixercise.core.Core;

@Setter
@Getter
@AllArgsConstructor

@Entity
@Table(name = "course_attendees")
public class CourseAttendee extends Core {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer attendId;
	private Integer courseId;
	private Integer accountId;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp attendTime;
	private Integer status;
	private String reason;
	private Integer paymentStatus;
	private Integer commentStatus;

	public CourseAttendee() {
	}
}
