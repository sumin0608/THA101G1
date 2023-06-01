package tw.idv.ixercise.course.dao;

import tw.idv.ixercise.course.entity.CourseAttendee;

public interface CourseAttendeeDao {

	public int insertCourseAttendee(CourseAttendee courseAttendee);
	
	public int deleteByattendId(Integer attendId);
}
