package tw.idv.ixercise.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.ixercise.course.entity.CourseComment;
import tw.idv.ixercise.course.service.CourseCommentService;
import tw.idv.ixercise.core.Core;
import java.sql.Timestamp;

@RestController
@RequestMapping("/coursecomment")
public class CourseCommentController {

	@Autowired
	private CourseCommentService service;

	// 測試
//	@GetMapping("/hello")
//    public String hello() {
//		System.out.println("前端成功抵達~");
//        return "Hello, World!";
//    }

	@GetMapping("/{accountIdReviewed}")
	public List<CourseComment> getAccountIdReviewed(@PathVariable("accountIdReviewed") Integer accountIdReviewed) {
		System.out.println("成功查到");
		return service.find(accountIdReviewed);
	}

	@PostMapping
	public Core save(@RequestBody CourseComment courseComment) {
		final Core core = new Core();
		if (courseComment.getCommentContent() =="") {
			core.setMessage("無輸入資訊");
			core.setSuccessful(false);
		} else {
			Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
			courseComment.setCreatedAt(currentTimestamp);
			courseComment.setUpdatedAt(currentTimestamp);
			core.setMessage("新增成功");
			core.setSuccessful(service.save(courseComment));
		}
		System.out.println(core.isSuccessful());
		return core;
	}

	@DeleteMapping("/{commentId}")
	public boolean deleteComment(@PathVariable("commentId") Integer commentId) {
		System.out.println("成功刪除");
		return service.remove(commentId);
	}
}
