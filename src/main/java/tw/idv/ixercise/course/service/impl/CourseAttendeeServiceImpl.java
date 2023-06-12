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
	private static final Map<Integer, String> courseStatusMap;

	static {
//       1.參加待審核 2.通過 3.未通過 4:退出待審核 5.退出成功
		statusMap = new HashMap<>();
		statusMap.put(1, "參加待審核");
		statusMap.put(2, "通過");
		statusMap.put(3, "未通過");
		statusMap.put(4, "退出待審核");
		statusMap.put(5, "退出成功");

		// Mapping of status values to their Chinese(Taiwanese) string representation

//        1.可參加 (未开始)  2. 活動已結束(+3) 3. 截止報名 4:滿團自行下架 5:自行下架 6:強制下架 ?? 未开始 进行中 (預計結束時間
//		1.可參加 2. 暫停報名 3. 截止報名 4:滿團 5:強制下架
		courseStatusMap = new HashMap<>();
		courseStatusMap.put(1, "可參加");
		courseStatusMap.put(2, "暫停報名");
		courseStatusMap.put(3, "截止報名");
		courseStatusMap.put(4, "滿團");
		courseStatusMap.put(5, "強制下架");
//		courseStatusMap.put(5, "自行下架");
//		courseStatusMap.put(6, "活動已結束"); //!!!
//		courseStatusMap.put(7, "即將開始");
//		statusMap.put(7, "进行中");
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
		List<CourseAndAttendeesEntity> byCourseID = caar.findByCourseIDAndStatus(courseAttendee.getCourseId(), 2);
		int passedSize = byCourseID.size();

		Course course = courseDao.selectByCourseId(courseAttendee.getCourseId());

//		List<CourseAttendee> size = repository.findByCourseId(24);
		System.out.println("size");
		System.out.println(passedSize);

//		if (course != null) {
//			System.out.println(course);
//			// 拿到欲報名課程的最後省和時間
		attendDeadline = course.getRegistrationDeadline();
////			courseAttendee
		Integer maximumCapacity = course.getMaximumCapacity();
		System.out.println(maximumCapacity);
		boolean lessOrEqualsToMaxCapacity = (passedSize + 1) <= maximumCapacity;
		boolean equalsToMaxCapacity = (passedSize + 1) == maximumCapacity;
		boolean afterDeadLine = attendDeadline.before(currentTimestamp);

//		System.out.println(b);
		Integer courseStatus = course.getCourseStatus();
//		boolean b1 = course.getCourseStatus() == 5;
		Integer accountId = courseAttendee.getAccountId();
		Integer courseId = courseAttendee.getCourseId();
		System.out.println(accountId);
		System.out.println(courseId);
		//判斷是否此用戶已參加過
		List<CourseAttendee> byCourseIdAndAccountId = repository.findByCourseIdAndAccountId(courseAttendee.getCourseId(), courseAttendee.getAccountId());
		System.out.println(byCourseIdAndAccountId);
		Core core = new Core();

		//5. 已滿團  6.報名時間已截止>.<   ELSE此課程不可參加   1. 可參加
//		1.可參加 2. 暫停報名 3. 截止報名 4:滿團 5:強制下架

		if (afterDeadLine) {
//			courseStatus == 6 ||
//			if (courseStatus != 3) {
//				course.setCourseStatus(3);  // 3. 截止報名
//				courseRepository.save(course);
//			}
			core.setMessage("報名失敗: 報名時間已截止>.<");
			core.setSuccessful(false);
//			6.報名時間已截止>.<
		} else if (!byCourseIdAndAccountId.isEmpty()) {
			System.out.println("您她媽的已參加過了");
			core.setMessage("您已報名過了");
			core.setSuccessful(false);
		} else if (maximumCapacity == passedSize) {
//			courseStatus == 5 &&
			if (courseStatus != 4) {
				course.setCourseStatus(4);  // 4:滿團
				courseRepository.save(course);
			}
			core.setMessage("已滿團");
			core.setSuccessful(false);

//			5. 已滿團
		} else if (lessOrEqualsToMaxCapacity && courseStatus != 2 && courseStatus != 5) {
//			courseStatus == 1 &&
			if (equalsToMaxCapacity) {
				course.setCourseStatus(4); // 4:滿團
				courseRepository.save(course);
				System.out.println("<<<<<滿團>>>>>>>>");
			}
			courseAttendee.setAttendTime(currentTimestamp);  //通過驗證才需做的動作
			System.out.println("<<<<<<<save to DB>>>>>");
			savedAttendee = repository.save(courseAttendee);
			if (savedAttendee != null) {
				course.setCourseStatus(1);  //1.可參加
				courseRepository.save(course);  //<<<<< 可省略

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

	@Override
	public CourseAttendee countAttendeesByCourseId(Integer courseId) {
		
		return repository.countAttendeesByCourseId(courseId);
	}

	@Override
	public List<CourseAndAttendeesEntity> getAttendeesCountList(Integer courseId) {
		System.out.println("查參加人數service");
		List<CourseAndAttendeesEntity> getView = caar.findByCourseID(courseId);
		if (!getView.isEmpty()) {
			getView.get(0).setSuccessful(true);
			getView.get(0).setMessage("getView第一筆資料成功");
		} else {
			CourseAndAttendeesEntity getView1 = new CourseAndAttendeesEntity();
			getView1.setSuccessful(false);
			getView1.setMessage("getView沒有資料");
			getView.add(getView1);
		}

		return getView;
	}

	@Override
	public CourseStatusDto validatingUserForApplying(Integer courseId, Integer accountId) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		CourseStatusDto courseStatusDto = new CourseStatusDto();

		Course course = courseRepository.findByCourseId(courseId);

		if (course != null) {

			Timestamp attendDeadline = course.getRegistrationDeadline();
			Timestamp courseStartTime = course.getCourseStartTime();
			boolean afterDeadLine = currentTimestamp.after(attendDeadline);
			boolean courseStarted = currentTimestamp.after(courseStartTime);
			boolean isCreator = course.getCreator() == accountId;
			Integer courseStatus = course.getCourseStatus();

			courseStatusDto.setCourseStatus(courseStatus); //課程狀態
			courseStatusDto.setCreator(isCreator);  //是否為creator
			courseStatusDto.setApplicationDeadlinePassed(afterDeadLine);  //是否為creator
			courseStatusDto.setCourseStarted(courseStarted);  //是否為creator

			if (!isCreator) {  //不是創辦者才執行 << 可省略 (嗎?
				List<CourseAttendee> byCourseIdAndAccountId = repository.findByCourseIdAndAccountId(courseId, accountId);

				if (byCourseIdAndAccountId.isEmpty()) {
					courseStatusDto.setAlreadyApplied(false); //是否有報名該課程
					if (afterDeadLine) {
						courseStatusDto.setAttendeesStatusString("報名時間已截止");
					} else if (courseStatus != 1) {
						courseStatusDto.setAttendeesStatusString(courseStatusMap.get(courseStatus));
					}
				} else {
					courseStatusDto.setAlreadyApplied(true); //是否有報名該課程
					Integer attendeeStatus = byCourseIdAndAccountId.get(0).getStatus();
					courseStatusDto.setCourseAttendeesStatus(attendeeStatus); //此用戶參加這個課程的狀態
					courseStatusDto.setAttendeesStatusString(statusMap.getOrDefault(attendeeStatus, "狀態錯誤"));

				}
			}
		}


		System.out.println("== 回傳courseStatusDto = service ==");
		System.out.println(courseStatusDto);
		return courseStatusDto;
	}
//	private boolean applicationDeadlinePassed;
//	private boolean courseStarted;
//	private boolean alreadyApplied;
//	private Integer courseStatus;
//	private Integer courseAttendeesStatus;

}
