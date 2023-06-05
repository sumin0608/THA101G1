package tw.idv.ixercise.course.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.idv.ixercise.course.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	//	模糊查詢
	List<Course> findByEventNameContainingIgnoreCaseAndCourseStatusOrCityContainingIgnoreCaseOrLocationContainingIgnoreCaseOrDetailedAddressContainsIgnoreCaseOrDescriptionContainsIgnoreCaseOrderByCourseStartDateDesc(
			String eventName, Integer courseStatus, String city, String location, String detailedAddress,
			String description);

	//	查詢courseId
	List<Course> findByCreator(Integer creator);

	List<Course> findByCourseIdIn(List<Integer> ids);
}
