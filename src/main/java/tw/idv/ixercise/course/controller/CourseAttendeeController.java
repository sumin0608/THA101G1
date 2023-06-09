package tw.idv.ixercise.course.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.ixercise.core.Core;
import tw.idv.ixercise.course.entity.*;
import tw.idv.ixercise.course.service.CourseAttendeeService;

@RestController
@RequestMapping("/courseAttendee")
public class CourseAttendeeController {

	@Autowired
	private CourseAttendeeService service;

	// 測試
//	@GetMapping("/hello2")
//    public String hello() {
//		System.out.println("前端成功抵達~");
//        return "Hello, World! My bro";
//    }

	@PostMapping
	public Core save(@RequestBody CourseAttendee ca) {
		final Core core = new Core();
		if (ca.getReason() == "") {
			core.setMessage("請輸入課程描述");
			core.setSuccessful(false);
			return core;
		} else {
//			Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
//			ca.setAttendTime(currentTimestamp);
//			core.setMessage("參加成功");
//			core.setSuccessful(service.save(ca));
			Core save = service.save(ca);
			System.out.println("參加成功!!!");
			return save;
		}

	}

	@PutMapping("/updateStatusById/{attendId}")
	public Core updateStatusById(@PathVariable("attendId") Integer attendId, @RequestBody Integer status) {
		System.out.println("現在是updateStatusById~");
		final Core core = new Core();
		core.setSuccessful(service.updateStatusById(attendId, status));
		if (!core.isSuccessful()) {
			core.setMessage("修改Status失敗");
		} else {
			core.setMessage("修改Status成功");
		}
		return core;
	}

	@PutMapping("/updateCourseAttendeeReason")
	public Core updateCourseAttendeeReason(Integer attendId, String reason) {
		System.out.println("現在是updateCourseAttendeeReason~");
		final Core core = new Core();
		core.setSuccessful(service.updateCourseAttendeeReason(attendId, reason));
		if (!core.isSuccessful()) {
			core.setMessage("修改Reason失敗");
		} else {
			core.setMessage("修改Reason成功");
		}
		return core;
	}

	@PutMapping("/updateCourseAttendeeCommentStatus/{attendId}")
	public Core updateCourseAttendeeCommentStatus(@PathVariable("attendId") Integer attendId, @RequestBody Integer commentStatus) {
		System.out.println("現在是updateCourseAttendeeCommentStatus~");
		final Core core = new Core();
		core.setSuccessful(service.updateCourseAttendeeCommentStatus(attendId, commentStatus));
		if (!core.isSuccessful()) {
			core.setMessage("修改CommentStatus失敗");
		} else {
			core.setMessage("修改CommentStatus成功");
		}
		return core;
	}

	@GetMapping
	public List<CourseAttendee> getAllAttendeesSortedByAttendTime() {
		System.out.println("成功查到!getAllAttendeesSortedByAttendTime");
		Sort sort = Sort.by(Sort.Direction.DESC, "attendTime");
		List<CourseAttendee> ca = service.getAllAttendeesSortedByAttendTime(sort);
		ca.get(0).setSuccessful(true);
		ca.get(0).setMessage("第一筆資料");
		return ca;
	}

	@GetMapping("/commentStatus/{commentStatus}")
	public List<CourseAttendee> getAttendeesByCommentStatus(@PathVariable("commentStatus") Integer commentStatus) {
		System.out.println("成功查到!getAttendeesByCommentStatus");
		List<CourseAttendee> ca = service.getAttendeesByCommentStatus(commentStatus);
		ca.get(0).setSuccessful(true);
		ca.get(0).setMessage("第一筆資料");
		return ca;
	}

	@GetMapping("/status/{status}")
	public List<CourseAttendee> getStatus(@PathVariable("status") Integer status) {
		System.out.println("成功查到!getStatus");
		List<CourseAttendee> ca = service.getStatus(status);
		System.out.println(ca.get(0).getMessage());
		return ca;
	}

	@GetMapping("/accountId/{accountId}")
	public List<CourseAttendee> getAttendeesByAccountId(@PathVariable("accountId") Integer accountId) {
		System.out.println("成功到! getAttendeesByAccountId");
		List<CourseAttendee> ca = service.getAttendeesByAccountId(accountId);
		ca.get(0).setSuccessful(true);
		ca.get(0).setMessage("第一筆資料");
		return ca;
	}

	@GetMapping("/courseId/{courseId}")
	public List<CourseAttendee> getAttendeesByCourseId(@PathVariable("courseId") Integer courseId) {
		System.out.println("成功到!getAttendeesByCourseId");
		List<CourseAttendee> ca = service.getAttendeesByCourseId(courseId);
		ca.get(0).setSuccessful(true);
		ca.get(0).setMessage("第一筆資料");
		return ca;
	}

	@GetMapping("/attendId/{attendId}")
	public CourseAttendee getAttendeesByAttendId(@PathVariable("attendId") Integer attendId) {
		System.out.println("成功到!getAttendeesByAttendId");
		CourseAttendee ca = service.getAttendeesByAttendId(attendId);
		ca.setSuccessful(true);
		ca.setMessage("第一筆資料");
		return ca;
	}

	@GetMapping("calander/{accountId}")
	public List<CourseAndAttendeesEntity> getCalendar(@PathVariable("accountId") Integer accountId) {
//		List<Course> calendarList = service.getCalendar(accountId);
		System.out.println("getCalendar>>>>>>");
		List<CourseAndAttendeesEntity> calendarList = service.getCalendarList(accountId);
		System.out.println(calendarList);
		return calendarList;
	}
}
