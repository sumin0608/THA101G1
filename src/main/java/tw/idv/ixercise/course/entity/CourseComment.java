package tw.idv.ixercise.course.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import tw.idv.ixercise.core.Core;

@Setter
@Getter
@AllArgsConstructor

@Entity
@Table(name = "course_comment")
public class CourseComment extends Core{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer commentId;
	private Integer courseId;
	private Integer accountIdReviewed;
	private Integer accountIdReviewer;
	private String commentContent;
	private Integer commentRating;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public CourseComment() {
	}
}
