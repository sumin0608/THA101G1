package tw.idv.ixercise.course.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.ixercise.course.entity.CourseAttendee;

public interface CourseAttendeeRepository extends JpaRepository<CourseAttendee, Integer> {

	//更新status
	@Transactional
	@Modifying
	@Query(value = "UPDATE CourseAttendee ca SET ca.status = :Status WHERE ca.attendId = :attendId", 
			nativeQuery = true)
	int updateCourseAttendeeStatus(@Param("attendId") Integer attendId, @Param("Status") Integer status);

	
	//更新reason
	@Transactional
	@Modifying
	@Query(value = "UPDATE CourseAttendee ca SET ca.reason = :reason WHERE ca.attendId = :attendId", 
			nativeQuery = true)
	int updateCourseAttendeeReason(@Param("attendId") Integer attendId, @Param("reason") String reason);
	
	//更新commentStatus
	@Transactional
	@Modifying
	@Query(value = "UPDATE CourseAttendee ca SET ca.commentStatus = :commentStatus WHERE ca.attendId = :attendId", 
			nativeQuery = true)
	int updateCourseAttendeeCommentStatus(@Param("attendId") Integer attendId, @Param("commentStatus") Integer commentStatus);
	

	List<CourseAttendee> findByCommentStatus(Integer commentStatus);

	List<CourseAttendee> findByStatus(Integer status);
	
	List<CourseAttendee> findByAccountId(Integer accountId);

	List<CourseAttendee> findByCourseId(Integer courseId);

	CourseAttendee findByAttendId(Integer attendId);
}
