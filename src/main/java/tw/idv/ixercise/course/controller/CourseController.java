package tw.idv.ixercise.course.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
	
	
	@PutMapping
	@ResponseBody
	public Core edit(@RequestBody Course course) {
		final Core core = new Core();
		if (course.getDescription() == "") {
			core.setMessage("請輸入課程描述");
			core.setSuccessful(false);
		} else {
		core.setMessage("修改成功");
		core.setSuccessful(service.edit(course));
		}
		System.out.println("修改成功");
		return core;
	}
	
	@GetMapping
	public List<Course> findAll() {
		System.out.println("成功查到!");
		List<Course> courses = service.findall();
		courses.get(0).setSuccessful(true);
		courses.get(0).setMessage("第一筆資料");
		return courses;
	}
	
	@GetMapping("/{city}")
	public List<Course> findCity(@RequestParam("city") String city) {
		System.out.println("成功查到!");
		List<Course> courses = service.findCity(city);
		courses.get(0).setSuccessful(true);
		courses.get(0).setMessage("第一筆資料");
		return courses;
	}
	
	@PostMapping("/upload-photo")
	public String uploadPhoto(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return "上傳的文件為空";
		}
		try {
			String projectRootPath = System.getProperty("user.dir");
			String relativePath = "src/main/resources/static/lib/img/";
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			// 构建存储文件的路径
			String filePath =  projectRootPath + "/" + relativePath + "course/"+fileName;
			// 创建目标文件对象
			File destFile = new File(filePath);
			
			System.out.println("儲存位置>>"+destFile);
			file.transferTo(destFile);
			// 返回存储的文件路径，可以在保存评论的控制器中使用?
			return filePath;
		} catch (IOException e) {
			e.printStackTrace();
			return "文件上傳失敗";
		}
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
