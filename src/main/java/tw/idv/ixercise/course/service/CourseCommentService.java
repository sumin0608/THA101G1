package tw.idv.ixercise.course.service;

import java.util.List;

import tw.idv.ixercise.course.entity.CourseComment;

public interface CourseCommentService {

	List<CourseComment> find(Integer accountIdReviewed);
	
	List<CourseComment> findaccountIdReviewer(Integer accountIdReviewer);

	boolean save(CourseComment courseComment);

	boolean remove(Integer commentId);
}
