package tw.idv.ixercise.course.dao.impl;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import tw.idv.ixercise.course.dao.CourseCommentDao;
import tw.idv.ixercise.course.entity.CourseComment;

@Repository
public class CourseCommentDaoImpl implements CourseCommentDao{

	@PersistenceContext
	private Session session; 
	
	@Override
	public int insertCourseComment(CourseComment courseComment) {
		session.persist(courseComment);
		return 1;
	}

	@Override
	public int deleteCourseComment(Integer commentId) {
		CourseComment courseComment=session.load(CourseComment.class, commentId);
		session.remove(courseComment);
		return 1;
	}

	@Override
	public int upateCourseComment(CourseComment courseComment) {
		final StringBuilder hql = new StringBuilder();
		hql.append("UPDATE course_comment SET ");
		
		hql.append("commentContent = :commentContent, ")
			.append("commentRating = :commentRating, ")
      		.append("updatedAt = NOW(), ")
      		.append("WHERE commentId = :commentId");
		
		Query query = session.createQuery(hql.toString());
		return query.setParameter("commentContent",courseComment.getCommentContent())
			.setParameter("commentRating",courseComment.getCommentRating())
			.setParameter("commentId",courseComment.getCommentId())
			.executeUpdate();
	}

	@Override
	public List<CourseComment> selectAll() {
		final String sql = "SELECT * FROM course_comment";
		return session.createNativeQuery(sql, CourseComment.class).getResultList();
	}

	@Override
	public List<CourseComment> selectCourseCommentByaccountIdReviewed(Integer accountIdReviewed) {
		final String sql = "SELECT * FROM course_comment where accountIdReviewed= :accountIdReviewed";
		return session.createNativeQuery(sql, CourseComment.class)
				.setParameter("accountIdReviewed",accountIdReviewed)
				.getResultList();
	}

	@Override
	public List<CourseComment> selectCourseCommentByaccountIdReviewer(Integer accountIdReviewer) {
		final String sql = "SELECT * FROM course_comment where accountIdReviewer= :accountIdReviewer";
		return session.createNativeQuery(sql, CourseComment.class)
				.setParameter("accountIdReviewer",accountIdReviewer)
				.getResultList();
	}

	//測試
//	public static void main(String[] args) {
//		CourseCommentDaoImpl dao = new CourseCommentDaoImpl();
//		
//		List<CourseComment> allComments = dao.selectAll();
//        System.out.println("All comments:");
//        for (CourseComment comment : allComments) {
//            System.out.println(comment);
//        }

        // 测试根据被评论的账号 ID 查询课程评论
//        int accountIdReviewed = 1001; // 被评论的账号 ID
//        List<CourseComment> commentsByReviewedAccount = dao.selectCourseCommentByaccountIdReviewed(accountIdReviewed);
//        System.out.println("Comments by reviewed account:");
//        for (CourseComment comment : commentsByReviewedAccount) {
//            System.out.println(comment);
//        }

        // 测试根据评论者的账号 ID 查询课程评论
//        int accountIdReviewer = 2002; // 评论者的账号 ID
//        List<CourseComment> commentsByReviewerAccount = dao.selectCourseCommentByaccountIdReviewer(accountIdReviewer);
//        System.out.println("Comments by reviewer account:");
//        for (CourseComment comment : commentsByReviewerAccount) {
//            System.out.println(comment);
//        }
        
//	}
	
	
	
}
