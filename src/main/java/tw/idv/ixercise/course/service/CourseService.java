package tw.idv.ixercise.course.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import tw.idv.ixercise.course.entity.Course;
import tw.idv.ixercise.course.entity.DistrictsDto;

public interface CourseService {

	boolean save(Course course);

	boolean remove(Integer courseId);

	boolean edit(Course course);

	List<Course> findall();

	List<Course> findCity(String city);

	List<Course> findcategoryId(String categoryId);

	Course findcorseId(Integer courseId);

	List<DistrictsDto> getDistricts(String city);
	
	List<Course> findCoursesByInput(String searchInput);
	
	List<Course> findCoursesByCreator(Integer creator);
	
	void updateCourse(Integer courseId, String eventName, Integer expectedPrice, Date courseStartDate,
            Timestamp courseStartTime, String courseDuration, Timestamp registrationDeadline,
            Integer maximumCapacity, String description, String photo, String location,
            String city, String district, String detailedAddress, String categoryId,
            Integer courseStatus, Integer paidAdvertising, Timestamp paidAdvertisingTime);

	
	void updateCourseEventName(Integer courseId,String eventName,Integer expectedPrice);
}
