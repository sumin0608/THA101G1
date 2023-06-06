package tw.idv.ixercise.course.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tw.idv.ixercise.core.Core;
import tw.idv.ixercise.course.entity.Course;
import tw.idv.ixercise.course.entity.DistrictsDto;
import tw.idv.ixercise.course.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService service;

//	// 測試
//		@GetMapping("/hello3")
//	    public String hello() {
//			System.out.println("前端成功抵達~");
//	        return "Hello, World! My bro";
//	    }

	@PostMapping
	public Core save(@RequestBody Course course) {
		final Core core = new Core();
		if (course.getDescription() == "") {
			core.setMessage("請輸入課程描述");
			core.setSuccessful(false);
		} else {
			Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
			course.setCourseCreationDate(currentTimestamp);
			core.setMessage("新增成功");
			core.setSuccessful(service.save(course));
		}
		System.out.println("新增成功");
		return core;
	}

	@DeleteMapping("/courseId/{courseId}")
	public Core remove(@PathVariable("courseId") Integer courseId) {
		final Core core = new Core();
		core.setMessage("刪除成功");
		core.setSuccessful(service.remove(courseId));
		System.out.println("刪除成功");
		return core;
	}
	
	
	@PutMapping
	@ResponseBody
	public Core edit(@RequestBody Course course) {
		final Core core = new Core();
		if (course.getDescription() == "") {
			core.setMessage("請輸入課程描述");
			core.setSuccessful(false);
		} else {
			core.setMessage("修改成功");
			core.setSuccessful(true);
//			service.edit(course);
			service.updateCourse(course.getCourseId(), course.getEventName(),
		            course.getExpectedPrice(), course.getCourseStartDate(), course.getCourseStartTime(),
		            course.getCourseDuration(), course.getRegistrationDeadline(), course.getMaximumCapacity(),
		            course.getDescription(), course.getPhoto(), course.getLocation(), course.getCity(),
		            course.getDistrict(), course.getDetailedAddress(), course.getCategoryId(),
		            course.getCourseStatus(), course.getPaidAdvertising(), course.getPaidAdvertisingTime());
		}
		System.out.println("修改成功");
		return core;
	}

	@GetMapping
	public List<Course> findAll() {
		System.out.println("成功到!findAll");
		List<Course> courses = service.findall();
		courses.get(0).setSuccessful(true);
		courses.get(0).setMessage("第一筆資料");
		return courses;
	}

	@GetMapping("/{city}")
	public List<Course> findCity(@RequestParam("city") String city) {
		System.out.println("成功到!findCity");
		List<Course> courses = service.findCity(city);
		courses.get(0).setSuccessful(true);
		courses.get(0).setMessage("第一筆資料");
		return courses;
	}

	@GetMapping("/courseId/{courseId}")
	public Course findCity(@PathVariable("courseId") Integer corseId) {
		System.out.println("成功到!course/courseId/");
		Course course = service.findcorseId(corseId);
		course.setSuccessful(true);
		course.setMessage("第一筆資料");
		return course;
	}
	
	@GetMapping("/creator/{creator}")
	public List<Course> findCreator(@PathVariable("creator") Integer creator) {
		System.out.println("成功到!findCreator");
		List<Course> courses = service.findCoursesByCreator(creator);		
		System.out.println(courses.get(0).getMessage());
		return courses;
	}
	

//	模糊查詢
	@GetMapping("/fuzzySearch/{searchInput}")
	public Optional<List<Course>> fuzzySearch(@PathVariable("searchInput") String searchInput) {
		List<Course> courses = service.findCoursesByInput(searchInput);
		System.out.println("fuzzySearch:"+searchInput);
		LocalDate currentDate = LocalDate.now();
		List<Course> filteredCourses = courses.stream().
				filter(course -> {
					LocalDate startDate = course.getCourseStartDate().toLocalDate();
					return startDate.isAfter(currentDate); //回傳boolean
				}).peek(course ->System.out.println("偷看模糊查詢: "+course.getEventName()))
				.collect(Collectors.toList());
		if(!filteredCourses.isEmpty()) {
			filteredCourses.get(0).setSuccessful(true);
	        filteredCourses.get(0).setMessage("模糊查詢結果");
		}
		return Optional.ofNullable(filteredCourses);
	}

	@PostMapping("/upload-photo")
	public Core uploadPhoto(@RequestParam("file") MultipartFile file) {
		final Core core = new Core();
		if (file.isEmpty()) {
			core.setMessage("照片儲存失敗");
			return core;
		}
		try {
			String projectRootPath = System.getProperty("user.dir");
			String relativePath = "src/main/resources/static/lib/img/";
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			// 建存储路径
			String filePath = projectRootPath + "/" + relativePath + "course/" + fileName;
			// 创建目标文件对象
			File destFile = new File(filePath);
			System.out.println("儲存位置>>" + destFile);
			file.transferTo(destFile);
			// 返回存储的文件路径，可以在保存评论的控制器中使用?
			core.setMessage(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return core;
	}

	@GetMapping("/districts/{city}")
	public List<DistrictsDto> getDistricts(@PathVariable("city") String city) {
		List<DistrictsDto> districts = service.getDistricts(city);
		for (DistrictsDto district : districts) {

			System.out.println(district.getName());
		}

		return districts;
	}

}
