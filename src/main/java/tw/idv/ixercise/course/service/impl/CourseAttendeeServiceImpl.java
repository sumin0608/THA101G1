package tw.idv.ixercise.course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tw.idv.ixercise.course.dao.CourseAttendeeRepository;
import tw.idv.ixercise.course.entity.CourseAttendee;
import tw.idv.ixercise.course.service.CourseAttendeeService;

@Service
public class CourseAttendeeServiceImpl implements CourseAttendeeService {

	@Autowired
	private CourseAttendeeRepository repository;

	@Override
	public boolean save(CourseAttendee courseAttendee) {
		CourseAttendee savedAttendee = repository.save(courseAttendee);
		return savedAttendee != null;
	}

	@Override
	public void remove(CourseAttendee courseAttendee) {
		repository.delete(courseAttendee);
	}

	@Override
	public boolean updateStatusById(Integer attendId, Integer status) {
		return repository.updateCourseAttendeeStatus(attendId, status)>0;
	}

	@Override
	public boolean updateCourseAttendeeReason(Integer attendId, String reason) {
		return repository.updateCourseAttendeeReason(attendId, reason)>0;
	}

	@Override
	public boolean updateCourseAttendeeCommentStatus(Integer attendId, Integer commentStatus) {
		return repository.updateCourseAttendeeCommentStatus(attendId, commentStatus)>0;
	}

	@Override
	public List<CourseAttendee> getAllAttendeesSortedByAttendTime(Sort sort) {
		return repository.findAll(sort);
	}

	@Override
	public List<CourseAttendee> getAttendeesByCommentStatus(Integer commentStatus) {
		return repository.findByCommentStatus(commentStatus);
	}

	@Override
	public List<CourseAttendee> getStatus(Integer status) {
		return repository.findByStatus(status);
	}

	@Override
	public List<CourseAttendee> getAttendeesByAccountId(Integer accountId) {
		return repository.findByAccountId(accountId);
	}

	@Override
	public List<CourseAttendee> getAttendeesByCourseId(Integer courseId) {
		return repository.findByCourseId(courseId);
	}

}
