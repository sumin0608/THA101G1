package tw.idv.ixercise.course.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import tw.idv.ixercise.course.entity.*;

public interface CourseAttendeeService {

	boolean save(CourseAttendee courseAttendee);

	void remove(CourseAttendee courseAttendee);

	boolean updateStatusById(Integer attendId, Integer status);

	boolean updateCourseAttendeeReason(Integer attendId, String reason);

	boolean updateCourseAttendeeCommentStatus(Integer attendId, Integer commentStatus);

	List<CourseAttendee> getAllAttendeesSortedByAttendTime(Sort sort);

	List<CourseAttendee> getAttendeesByCommentStatus(Integer commentStatus);

	List<CourseAttendee> getStatus(Integer status);

	List<CourseAttendee> getAttendeesByAccountId(Integer accountId);


	List<CourseAttendee> getAttendeesByCourseId(Integer courseId);
	
	CourseAttendee getAttendeesByAttendId(Integer attendId);

	List<Course> getCalendar(Integer accountId);

    List<CourseAndAttendeesEntity> getCalendarList(Integer accountId);
}
