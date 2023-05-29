package tw.idv.ixercise.course.service;

import java.util.List;

import tw.idv.ixercise.course.entity.Course;

public interface CourseService {

	boolean save(Course course);

	boolean remove(Integer courseId);

	boolean edit(Course course);

	List<Course> findall();

	List<Course> findCity(String city);

	List<Course> findcategoryId(String categoryId);
	
	List<Object[]> getDistricts(Integer city);

}
