package tw.idv.ixercise.course.service.impl;

import java.sql.*;
import java.util.*;
import java.util.stream.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Autowired
	private CourseAndAttendeesRepository caar;


	@Override
	public Core save(CourseAttendee courseAttendee) {
		System.out.println("<<<<<<<<<<save>>>>>>>>>>>");
		CourseAttendee savedAttendee = null;
		Timestamp attendDeadline;
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		List<CourseAndAttendeesEntity> byCourseID = caar.findByCourseID(courseAttendee.getCourseId());
		int size = byCourseID.size();
//		System.out.println(size);
		Course course = courseDao.selectByCourseId(courseAttendee.getCourseId());

//		int size = repository.findByCourseId(courseAttendee.getCourseId()).size();

//		List<CourseAttendee> size = repository.findByCourseId(24);
		System.out.println("size");
		System.out.println(size);

//		if (course != null) {
//			System.out.println(course);
//			// 拿到欲報名課程的最後省和時間
		attendDeadline = course.getRegistrationDeadline();
////			courseAttendee
		Integer maximumCapacity = course.getMaximumCapacity();
		System.out.println(maximumCapacity);
		boolean lessOrEqualsToMaxCapacity = (size + 1) <= maximumCapacity;
		boolean equalsToMaxCapacity = (size + 1) == maximumCapacity;
		boolean afterDeadLine = attendDeadline.before(currentTimestamp);

//		System.out.println(b);
		Integer courseStatus = course.getCourseStatus();
		boolean b1 = course.getCourseStatus() == 5;
		Integer accountId = courseAttendee.getAccountId();
		Integer courseId = courseAttendee.getCourseId();
		System.out.println(accountId);
		System.out.println(courseId);
		//判斷是否此用戶已參加過
		List<CourseAttendee> byCourseIdAndAccountId = repository.findByCourseIdAndAccountId(courseAttendee.getCourseId(), courseAttendee.getAccountId());
		System.out.println(byCourseIdAndAccountId);
		Core core = new Core();
		//5. 已滿團  6.報名時間已截止>.<   ELSE此課程不可參加   1. 可參加
		if (!byCourseIdAndAccountId.isEmpty()) {
			System.out.println("您她媽的已參加過了");
			core.setMessage("您已報名過了");
			core.setSuccessful(false);
		} else if (maximumCapacity == size) {
//			courseStatus == 5 &&
			core.setMessage("已滿團");
			core.setSuccessful(false);

//			5. 已滿團

		} else if (afterDeadLine) {
//			courseStatus == 6 ||
			if (afterDeadLine) {
				course.setCourseStatus(6);
			}
			core.setMessage("報名失敗: 報名時間已截止>.<");
			core.setSuccessful(false);
//			6.報名時間已截止>.<
		} else if (lessOrEqualsToMaxCapacity) {
//			courseStatus == 1 &&
			if (equalsToMaxCapacity) {
				course.setCourseStatus(5);
				System.out.println("<<<<<滿團>>>>>>>>");
			}
			courseAttendee.setAttendTime(currentTimestamp);  //通過驗證才需做的動作
			System.out.println("<<<<<<<save to DB>>>>>");
			savedAttendee = repository.save(courseAttendee);
			if (savedAttendee != null) {
				course.setCourseStatus(1);
				System.out.println(savedAttendee);
				System.out.println("成功到savedAttendee>");
				core.setMessage("報名成功 請等待審核 後付款");
				core.setSuccessful(true);
			}
//					1. 可參加

		} else {
			core.setMessage("此課程不可參加");
			core.setSuccessful(false);

//			此課程不可參加
		}

//		courseDao.
		//跟新狀態
//		courseRepository.save(course);
		System.out.println(course);
		System.out.println(core);
		return core;


//		if(courseStatus == 1 && attendDeadline.after(currentTimestamp) && b){
//			}else {
//			}
//			core.setMessage("此課程不可參加");
//				if (c){
//					course.setCourseStatus(5);
//					System.out.println("<<<<<滿團>>>>>>>>");
//				}
//				courseAttendee.setAttendTime(currentTimestamp);  //通過驗證才需做的動作
//			System.out.println("<<<<<<<save to DB>>>>>");
//				savedAttendee = repository.save(courseAttendee);
//			System.out.println(savedAttendee);
//			System.out.println("成功到savedAttendee>");
//			} else if (attendDeadline.after(currentTimestamp)) {
//			if (){
//				course.setCourseStatus(2);
//				System.out.println("<<<<< 已結束 >>>>>>>>");
//			}
//		} else {
		//reject
		//System.out.println("The attend time is over");
//				//set message ->  The attend time is over
//			}
//
//			//判斷此課程報名時間是否已截止
//			if (attendDeadline.after(currentTimestamp)) {
////				courseAttendee.setAttendTime(currentTimestamp);  //通過驗證才需做的動作
//				savedAttendee = repository.save(courseAttendee);
//			} else {
//				System.out.println("The attend time is over");
//				//set message ->  The attend time is over
//			}
//
//		} else {
//			//set message -> no such courseId
//		}


		// return core;
//		return savedAttendee != null;
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

	//purpose -> get calendar / get attended courses haven't started yet
	//1. get a list of courseId  by accountId
	//2. use each courseId -> to find the corresponding course
	//3. filter result -> compare course Start time with now or by status
	//4. return filtered list
	//reference --> Test04FindFirstLazy.java
	@Override
	public List<CourseAndAttendeesEntity> getCalendarList(Integer accountId) {
		List<CourseAndAttendeesEntity> filteredCourseList;
		System.out.println("<<<<<getCalendarList>>>>>>>>>>>>>");

		//查詢 get all attended courses BY his accountId
		List<CourseAndAttendeesEntity> findByAccountId = caar.findByAccountId(accountId);

		//empty check
		if (!findByAccountId.isEmpty()) {

			//get current Time 拿當下時間
			Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

			//過濾已開始(結束)的課程 並設定對應狀態
			// List<CourseAndAttendees> ->  stream -> filter(time) -> set Status map to String (HashMap)-> collect.toList
			filteredCourseList = findByAccountId.stream()
					.filter(course -> course.getCourseStartTime().after(currentTimestamp))
					.peek(attendees -> attendees.setAttendeesStatus(statusMap.getOrDefault(attendees.getStatus(), "無此狀態")))
//					.peek(course -> {course.setSuccessful(true); course.setMessage("成功查詢參加課程");})
					.collect(Collectors.toList());

			if (filteredCourseList.isEmpty()) {
				System.out.println("<<<<<isEmpty>>>>>>>>");
				CourseAndAttendeesEntity caae = new CourseAndAttendeesEntity();
				caae.setMessage("未有任何活動即將開始");
				caae.setSuccessful(false);
				filteredCourseList.add(caae);
			}
		} else {
			filteredCourseList = new ArrayList<>();
			CourseAndAttendeesEntity caae = new CourseAndAttendeesEntity();
			caae.setMessage("此Id未參加任何課程");
			caae.setSuccessful(false);
			filteredCourseList.add(caae);
			filteredCourseList.add(caae);
		}
		System.out.println("getCalendarList()");
		filteredCourseList.forEach(System.out::println);
		return filteredCourseList;
	}

}
