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
		System.out.println("成功到savedAttendee>");
		return savedAttendee != null;
	}

	@Override
	public void remove(CourseAttendee courseAttendee) {
		System.out.println("成功到remove(CourseAttendee)>");
		repository.delete(courseAttendee);
	}

	@Override
	public boolean updateStatusById(Integer attendId, Integer status) {
		System.out.println("成功到updateStatusById>"+"attendId:"+attendId+"status:"+status);
		return repository.updateCourseAttendeeStatus(attendId, status)>0;
	}

	@Override
	public boolean updateCourseAttendeeReason(Integer attendId, String reason) {
		System.out.println("成功到updateeAttendeeReason>"+"attendId:"+attendId+"reason:"+reason);
		return repository.updateCourseAttendeeReason(attendId, reason)>0;
	}

	@Override
	public boolean updateCourseAttendeeCommentStatus(Integer attendId, Integer commentStatus) {
		System.out.println("成功到updateCourseAttendeeCommentStatus>"+"attendId:"+attendId+"commentStatus:"+commentStatus);
		return repository.updateCourseAttendeeCommentStatus(attendId, commentStatus)>0;
	}

	@Override
	public List<CourseAttendee> getAllAttendeesSortedByAttendTime(Sort sort) {
		System.out.println("成功到ffindAll(sort)>"+sort);
		return repository.findAll(sort);
	}

	@Override
	public List<CourseAttendee> getAttendeesByCommentStatus(Integer commentStatus) {
		System.out.println("成功到findByCommentStatus>>"+commentStatus);
		return repository.findByCommentStatus(commentStatus);
	}

	@Override
	public List<CourseAttendee> getStatus(Integer status) {
		System.out.println("成功到findByStatus>>"+status);
		return repository.findByStatus(status);
	}

	@Override
	public List<CourseAttendee> getAttendeesByAccountId(Integer accountId) {
		System.out.println("成功到findByAccountId>>"+accountId);
		return repository.findByAccountId(accountId);
	}

	@Override
	public List<CourseAttendee> getAttendeesByCourseId(Integer courseId) {
		System.out.println("成功到findByCourseId>>"+courseId);
		return repository.findByCourseId(courseId);
	}

}
