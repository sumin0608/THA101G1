package tw.idv.ixercise.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.ixercise.course.entity.CourseComment;
import tw.idv.ixercise.course.service.CourseCommentService;

@RestController
@RequestMapping("/coursecomment")
public class CourseCommentController {

	@Autowired
	private CourseCommentService service;

	@GetMapping("{/getAccountIdReviewed}")
	public List<CourseComment> getAccountIdReviewed(Integer accountIdReviewed) {
		System.out.println("前端成功抵達~");
		
		return service.find(accountIdReviewed);
	}

	@DeleteMapping("{/commentId}")
	public boolean deleteComment(Integer commentId) {
		System.out.println("前端成功抵達~");
		return true;
//		return service.remove(commentId);
	}
}
