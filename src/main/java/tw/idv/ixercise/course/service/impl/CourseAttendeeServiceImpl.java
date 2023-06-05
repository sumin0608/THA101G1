package tw.idv.ixercise.course.service.impl;

import java.sql.*;
import java.util.*;
import java.util.stream.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tw.idv.ixercise.core.*;
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
			//拿到欲報名課程的最後省和時間
			attendDeadline = course.getRegistrationDeadline();

			//判斷此課程報名時間是否已截止
			if (attendDeadline.before(currentTimestamp)) {
//				courseAttendee.setAttendTime(currentTimestamp);  //通過驗證才需做的動作
				savedAttendee = repository.save(courseAttendee);
			} else {
				System.out.println("The attend time is over");
				//set message ->  The attend time is over
			}

		} else {
			//set message -> no such courseId
		}

		System.out.println("成功到savedAttendee>");
		// return core;
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
		System.out.println("成功到findByAccountId>>" + accountId);
		return repository.findByAccountId(accountId);
	}

	@Override
	public List<CourseAttendee> getAttendeesByCourseId(Integer courseId) {
		System.out.println("成功到findByCourseId>>" + courseId);
		return repository.findByCourseId(courseId);
	}

	@Override
	public List<Course> getCalendar(Integer accountId) {
		//purpose -> get calendar / get attended courses haven't started yet
		//1. get a list of courseId  by accountId
		//2. use each courseId -> to find the(each) corresponding course
		//3. filter result -> compare course Start time with now or by status
		//4. return filtered list
		//reference --> Test04FindFirstLazy.java
		List<Course> filteredCourseList;
		List<CourseAttendee> byAccountId = repository.findByAccountId(accountId);

		if (!byAccountId.isEmpty()) {
			//prepare an empty list -> for ids (selected by accountId)
			List<Integer> ids = new ArrayList<>();

			//get all attended courses' ID BY his accountId
			byAccountId.forEach(courseAttendee -> ids.add(courseAttendee.getCourseId()));

			//拿當下時間
			Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

			//查詢並過濾已開始(結束)的課程壢
			// List<course> ->  stream -> filter(time) -> collect.toList
			filteredCourseList = courseRepository.findByCourseIdIn(ids).stream()
					.peek(e -> System.out.println(e))
					.filter(course -> course.getCourseStartTime().after(currentTimestamp))
//					.peek(course -> {course.setSuccessful(true); course.setMessage("成功查詢參加課程");})
					.collect(Collectors.toList());
			if (filteredCourseList.isEmpty()) {
				System.out.println("<<<<<isEmpty>>>>>>>>");
				filteredCourseList.add(new Course.Builder().setMessage("未有任何活動即將開始").setSuccessful(false).build());
			}
		} else {
			filteredCourseList = new ArrayList<>();
			filteredCourseList.add(new Course.Builder().setMessage("此Id未參加任何課程").setSuccessful(false).build());
		}

		System.out.println("calendar ->sss");
		System.out.println(filteredCourseList);
		return filteredCourseList;
	}

}
