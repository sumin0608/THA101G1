package tw.idv.ixercise.course.dao;

import java.util.List;

import tw.idv.ixercise.course.entity.CourseAttendee;

public interface CourseAttendeeDao {

	public int insertCourseAttendee(CourseAttendee courseAttendee);
	
	public int deleteByAttendId(Integer attendId);
	
	public int updateByAttendId(Integer attendId); 
	
	public List<CourseAttendee> selectByCourseId(Integer courseId);
	public List<CourseAttendee> selectByaccountId(Integer accountId);
}
