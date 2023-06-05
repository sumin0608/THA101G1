package tw.idv.ixercise.course.service.impl;

import java.text.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.ixercise.course.dao.CourseDao;
import tw.idv.ixercise.course.dao.CourseRepository;
import tw.idv.ixercise.course.entity.Course;
import tw.idv.ixercise.course.entity.DistrictsDto;
import tw.idv.ixercise.course.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository repository;

	@Autowired
	CourseDao dao;

	private static final Map<Integer, String> statusMap;

	static {
		// Mapping of status values to their Chinese(Taiwanese) string representation

//        1.可參加 (未开始)  2. 活動已結束(+3) 3. 截止報名 4:滿團自行下架 5:自行下架 6:強制下架 ?? 未开始 进行中 (預計結束時間
		statusMap = new HashMap<>();
		statusMap.put(1, "可參加");
		statusMap.put(2, "暫停報名");
		statusMap.put(3, "截止報名");
		statusMap.put(4, "滿團");
		statusMap.put(5, "強制下架");
//		statusMap.put(5, "自行下架");
		statusMap.put(6, "活動已結束");
//		statusMap.put(7, "即將開始");
//		statusMap.put(7, "进行中");
	}

	@Transactional
	@Override
	public boolean save(Course course) {
		return dao.insertCourse(course) > 0;
	}

	@Override
	public boolean remove(Integer courseId) {
		return dao.deleteByCourseId(courseId) > 0;
	}

	@Override
	public boolean edit(Course course) {
		return dao.upateByCourseId(course) > 0;
	}

	@Override
	public List<Course> findall() {
		return dao.selectAll();
	}

	@Override
	public List<Course> findCity(String city) {
		if (dao.selectByCity(city) == null) {
			List<Course> courses = new ArrayList<>();
			Course course1 = new Course();
			course1.setMessage("找不到城市");
			courses.add(course1);
			return courses;
		}
		return dao.selectByCity(city);
	}

	@Override
	public Course findcorseId(Integer corseId) {
		if (dao.selectByCourseId(corseId) == null) {
			Course course1 = new Course();
			course1.setMessage("找不到Id");
			return course1;
		}
		return dao.selectByCourseId(corseId);
	}

	@Override
	public List<Course> findcategoryId(String categoryId) {
		if (dao.selectBycategoryId(categoryId) == null) {
			List<Course> courses = new ArrayList<>();
			Course course1 = new Course();
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

	@Override
	public List<Course> findCoursesByInput(String searchInput) {
		String trimmedInput = searchInput.trim();
		List<Course> searchCourse = new ArrayList<>();
		searchCourse = repository
				.findByEventNameContainingIgnoreCaseAndCourseStatusOrCityContainingIgnoreCaseOrLocationContainingIgnoreCaseOrDetailedAddressContainsIgnoreCaseOrDescriptionContainsIgnoreCaseOrderByCourseStartDateDesc(
						trimmedInput, 1, trimmedInput, trimmedInput, searchInput, trimmedInput);
		if (!searchCourse.isEmpty()) {
			System.out.println("模糊查詢成功");
		} else {
			System.out.println("模糊查詢失敗");
		}
		return searchCourse;
	}

	@Override
	public List<Course> findCoursesByCreator(Integer creator) {
		System.out.println("到Service層findCoursesByCreator" + creator);
		List<Course> searchCourse = repository.findByCreator(creator);

		System.out.println("creator's courses: " + searchCourse);
		if (!searchCourse.isEmpty()) {
			//Consumer -> lambda expression (設定回傳的課程 狀態)
			searchCourse.forEach(course -> course.setStatusString(statusMap.getOrDefault(course.getCourseStatus(), "無此課程狀態，請洽詢管理員")));
			System.out.println("此Creator查詢成功");
		} else {
			System.out.println("此Creator查詢無資料");
			// set message -> 您無創辦課程紀錄
		}
		return searchCourse;
	}

}
