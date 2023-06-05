package tw.idv.ixercise.course.dao;

import java.util.List;

import tw.idv.ixercise.course.entity.CourseComment;

public interface CourseCommentDao {

	public int insertCourseComment(CourseComment courseComment);

	public int deleteCourseComment(Integer commentId);

	public int upateCourseComment(CourseComment courseComment);

	public List<CourseComment> selectAll();

	public List<CourseComment> selectCourseCommentByaccountIdReviewed(Integer accountIdReviewed);

	public List<CourseComment> selectCourseCommentByaccountIdReviewer(Integer accountIdReviewer);
	
}
