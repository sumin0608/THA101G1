package tw.idv.ixercise.course.dao;

import java.util.List;

import tw.idv.ixercise.course.entity.Course;

public interface CourseDao {

	public int insertCourse(Course course);

	public int deleteByCourseId(Integer courseId);

	public int upateByCourseId(Integer courseId);

	public List<Course> selectAll();

	public Course selectByName(String eventName);

	public List<Course> selectBycategoryId(String categoryId);

	public List<Course> selectByCity(String city);

	public List<Course> selectByCreator(Integer creator);
}
