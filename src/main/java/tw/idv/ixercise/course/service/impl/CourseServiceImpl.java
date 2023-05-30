package tw.idv.ixercise.course.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.ixercise.course.dao.CourseDao;
import tw.idv.ixercise.course.entity.Course;
import tw.idv.ixercise.course.entity.DistrictsDto;
import tw.idv.ixercise.course.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDao dao;

	@Transactional
	@Override
	public boolean save(Course course) {
		return dao.insertCourse(course) > 0;
	}

	@Override
	public boolean remove(Integer courseId) {
		return dao.deleteByCourseId(courseId)>0;
	}
	
	@Override
	public boolean edit(Course course) {
		return dao.upateByCourseId(course)>0;
	}


	@Override
	public List<Course> findall() {
		return dao.selectAll();
	}
	
	@Override
	public List<Course> findCity(String city) {
		if(dao.selectByCity(city)==null) {
			List<Course> courses =new ArrayList<>();
			Course course1= new Course();
			course1.setMessage("找不到城市");
			courses.add(course1);
			return courses;
		}
		return dao.selectByCity(city);
	}

	@Override
	public List<Course> findcategoryId(String categoryId) {
		if(dao.selectBycategoryId(categoryId)==null) {
			List<Course> courses =new ArrayList<>();
			Course course1= new Course();
			course1.setMessage("找不到相關分類");
			courses.add(course1);
			return courses;
		}
		return dao.selectBycategoryId(categoryId);
	}

	@Override
	public List<DistrictsDto> getDistricts(String city) {
		return dao.getDistricts(city);
	}
}
