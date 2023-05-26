package tw.idv.ixercise.course.service;

import java.util.List;

import tw.idv.ixercise.course.entity.Course;

public interface CourseService {

	boolean save(Course course);

	boolean remove(Integer courseId);

	List<Course> findCity(String city);
	
	
}
