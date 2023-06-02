package tw.idv.ixercise.course.dao;

import java.util.List;

import tw.idv.ixercise.course.entity.Course;
import tw.idv.ixercise.course.entity.DistrictsDto;

public interface CourseDao {

	public int insertCourse(Course course);

	public int deleteByCourseId(Integer courseId);

	public int upateByCourseId(Course course);

	public List<Course> selectAll();

	public List<Course> selectByName(String eventName);

	public Course selectByCourseId(Integer corseId);

	public List<Course> selectBycategoryId(String categoryId);

	public List<Course> selectByCity(String city);

	public List<Course> selectByCreator(Integer creator);
	
	public List<DistrictsDto> getDistricts(String city);
}
