package tw.idv.ixercise.course.service.impl;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.ixercise.course.dao.*;
import tw.idv.ixercise.course.entity.*;
import tw.idv.ixercise.course.service.CourseAttendeeService;

@Service
public class CourseAttendeeServiceImpl implements CourseAttendeeService {

	@Autowired
	private CourseAttendeeRepository repository;
	private static final Map<Integer, String> statusMap;

	static {
//       1.參加待審核 2.通過 3.未通過 4:退出待審核 5.退出成功
		statusMap = new HashMap<>();
		statusMap.put(1, "參加待審核");
		statusMap.put(2, "通過");
		statusMap.put(3, "未通過");
		statusMap.put(4, "退出待審核");
		statusMap.put(5, "退出成功");
	}

	@Autowired
	private CourseDao courseDao;
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public boolean save(CourseAttendee courseAttendee) {
		CourseAttendee savedAttendee = null;
		Timestamp attendDeadline = null;
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		Course course = courseDao.selectByCourseId(courseAttendee.getCourseId());

		if (course != null) {
			// 拿到欲報名課程的最後省和時間
			attendDeadline = course.getRegistrationDeadline();

			// 判斷此課程報名時間是否已截止
			if (attendDeadline.before(currentTimestamp)) {
//				courseAttendee.setAttendTime(currentTimestamp);  //通過驗證才需做的動作
				savedAttendee = repository.save(courseAttendee);
			} else {
				System.out.println("The attend time is over");
				// set message -> The attend time is over
			}

		} else {
			// set message -> no such courseId
		}

		System.out.println("成功到savedAttendee>");
		// return core;
		return savedAttendee != null;
	}

	@Transactional
	@Override
	public void remove(CourseAttendee courseAttendee) {
		System.out.println("成功到remove(CourseAttendee)>");
		repository.delete(courseAttendee);
	}

	@Transactional
	@Override
	public boolean updateStatusById(Integer attendId, Integer status) {
		System.out.println("成功到updateStatusById>" + "attendId:" + attendId + " status:" + status);
		return repository.updateCourseAttendeeStatus(attendId, status) > 0;
	}

	@Transactional
	@Override
	public boolean updateCourseAttendeeReason(Integer attendId, String reason) {
		System.out.println("成功到updateeAttendeeReason>" + "attendId:" + attendId + " reason:" + reason);
		return repository.updateCourseAttendeeReason(attendId, reason) > 0;
	}

	@Transactional
	@Override
	public boolean updateCourseAttendeeCommentStatus(Integer attendId, Integer commentStatus) {
		System.out.println(
				"成功到updateCourseAttendeeCommentStatus>" + "attendId:" + attendId + " commentStatus:" + commentStatus);
		return repository.updateCourseAttendeeCommentStatus(attendId, commentStatus) > 0;
	}

	@Override
	public List<CourseAttendee> getAllAttendeesSortedByAttendTime(Sort sort) {
		System.out.println("成功到ffindAll(sort)>" + sort);
		return repository.findAll(sort);
	}

	@Override
	public List<CourseAttendee> getAttendeesByCommentStatus(Integer commentStatus) {
		System.out.println("成功到findByCommentStatus>>" + commentStatus);
		return repository.findByCommentStatus(commentStatus);
	}

	@Override
	public List<CourseAttendee> getStatus(Integer status) {
		System.out.println("成功到findByStatus>>" + status);
		List<CourseAttendee> ca = repository.findByStatus(status);
		if (!ca.isEmpty()) {
			ca.get(0).setSuccessful(true);
			ca.get(0).setMessage("第一筆資料成功");
		} else {
			CourseAttendee ca1 = new CourseAttendee();
			ca1.setSuccessful(false);
			ca1.setMessage("沒有資料");
			ca.add(ca1);
		}
		return ca;
	}

	@Override
	public List<CourseAttendee> getAttendeesByAccountId(Integer accountId) {
		System.out.println("成功到findByAccountId>>" + accountId);
		return repository.findByAccountId(accountId);
	}

	@Override
	public List<CourseAttendee> getAttendeesByCourseId(Integer courseId) {
		System.out.println("成功到findByCourseId>>" + courseId);
		return repository.findByCourseId(courseId);
	}

	@Override
	public CourseAttendee getAttendeesByAttendId(Integer attendId) {
		System.out.println("成功到findByAttendId>>" + attendId);
		return repository.findByAttendId(attendId);
	}

	@Override
	public List<Course> getCalendar(Integer accountId) {
		List<CourseAttendee> byAccountId = repository.findByAccountId(accountId);
		System.out.println(byAccountId);
		// prepare an empty list -> for ids (selected by accountId)
		List<Integer> ids = new ArrayList<>();
		// purpose -> get calendar / get attended courses haven't started yet
		// 1. get a list of courseId by accountId
		// 2. use each courseId -> to find the(each) corresponding course
		// 3. compare course Start time with now or by status
//		Course course = courseDao.selectByCourseId(courseAttendee.getCourseId());
		byAccountId.forEach(courseAttendee -> ids.add(courseAttendee.getCourseId()));
		System.out.println("list of IDS");
		System.out.println(ids);

		List<Course> byIdIn = courseRepository.findByCourseIdIn(ids);
		System.out.println("print out each course for an account");
		byIdIn.forEach(System.out::println);
		return byIdIn;
	}

}
