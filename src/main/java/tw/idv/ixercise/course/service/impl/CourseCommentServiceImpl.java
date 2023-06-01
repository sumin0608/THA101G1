package tw.idv.ixercise.course.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.ixercise.course.dao.CourseCommentDao;
import tw.idv.ixercise.course.entity.CourseComment;
import tw.idv.ixercise.course.service.CourseCommentService;

@Service
public class CourseCommentServiceImpl implements CourseCommentService {

	@Autowired
	CourseCommentDao dao;

	@Override
	public List<CourseComment> find(Integer accountIdReviewed) {
		if (dao.selectCourseCommentByaccountIdReviewed(accountIdReviewed) == null) {
			List<CourseComment> courseComments = new ArrayList<>();
			CourseComment courseComment1 = new CourseComment();
			courseComment1.setMessage("沒有被評論過");
			courseComment1.setSuccessful(false);
			courseComments.add(courseComment1);
			return courseComments;
		}
		return dao.selectCourseCommentByaccountIdReviewed(accountIdReviewed);
	}
	
	@Override
	public List<CourseComment> findaccountIdReviewer(Integer accountIdReviewer) {
		if (dao.selectCourseCommentByaccountIdReviewer(accountIdReviewer) == null) {
			List<CourseComment> courseComments = new ArrayList<>();
			CourseComment courseComment1 = new CourseComment();
			courseComment1.setMessage("沒有評論過");
			courseComment1.setSuccessful(false);
			courseComments.add(courseComment1);
			return courseComments;
		}
		return dao.selectCourseCommentByaccountIdReviewer(accountIdReviewer);
	}
	
	@Transactional
	@Override
	public boolean save(CourseComment courseComment) {
		return dao.insertCourseComment(courseComment)>0;
	}

	@Transactional
	@Override
	public boolean remove(Integer commentId) {
		return dao.deleteCourseComment(commentId) > 0;
	}


}
