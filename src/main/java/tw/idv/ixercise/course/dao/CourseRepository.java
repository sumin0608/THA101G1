package tw.idv.ixercise.course.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.ixercise.course.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

//	模糊查詢
	List<Course> findByEventNameContainingIgnoreCaseAndCourseStatusOrCityContainingIgnoreCaseOrLocationContainingIgnoreCaseOrDetailedAddressContainsIgnoreCaseOrDescriptionContainsIgnoreCaseOrderByCourseStartDateDesc(
			String eventName, Integer courseStatus, String city, String location, String detailedAddress,
			String description);

//	查詢courseId
	List<Course> findByCreator(Integer creator);
	
//	更新
	    @Transactional
		@Modifying
	    @Query("UPDATE Course c SET c.eventName = :eventName, c.expectedPrice = :expectedPrice, " +
	            "c.courseStartDate = :courseStartDate, c.courseStartTime = :courseStartTime, " +
	            "c.courseDuration = :courseDuration, c.registrationDeadline = :registrationDeadline, " +
	            "c.maximumCapacity = :maximumCapacity, c.description = :description, c.photo = :photo, " +
	            "c.location = :location, c.city = :city, c.district = :district, " +
	            "c.detailedAddress = :detailedAddress, c.categoryId = :categoryId, " +
	            "c.courseStatus = :courseStatus, c.paidAdvertising = :paidAdvertising, " +
	            "c.paidAdvertisingTime = :paidAdvertisingTime " +
	            "WHERE c.courseId = :courseId")
	    void updateCourse(@Param("courseId") Integer courseId, @Param("eventName") String eventName,
	                      @Param("expectedPrice") Integer expectedPrice, @Param("courseStartDate") Date courseStartDate,
	                      @Param("courseStartTime") Timestamp courseStartTime, @Param("courseDuration") String courseDuration,
	                      @Param("registrationDeadline") Timestamp registrationDeadline,
	                      @Param("maximumCapacity") Integer maximumCapacity, @Param("description") String description,
	                      @Param("photo") String photo, @Param("location") String location,
	                      @Param("city") String city, @Param("district") String district,
	                      @Param("detailedAddress") String detailedAddress, @Param("categoryId") String categoryId,
	                      @Param("courseStatus") Integer courseStatus, @Param("paidAdvertising") Integer paidAdvertising,
	                      @Param("paidAdvertisingTime") Timestamp paidAdvertisingTime);	

}
