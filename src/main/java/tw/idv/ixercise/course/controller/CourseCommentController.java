package tw.idv.ixercise.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.util.StringUtils;
import tw.idv.ixercise.course.entity.CourseComment;
import tw.idv.ixercise.course.service.CourseCommentService;
import tw.idv.ixercise.core.Core;
import java.sql.Timestamp;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/coursecomment")
public class CourseCommentController {

	@Autowired
	private CourseCommentService service;

	// 測試
//	@GetMapping("/hello")
//    public String hello() {
//		System.out.println("前端成功抵達~");
//        return "Hello, World!";
//    }

	@GetMapping("/{accountIdReviewed}")
	public List<CourseComment> getAccountIdReviewed(@PathVariable("accountIdReviewed") Integer accountIdReviewed) {
		System.out.println("成功查到");
		return service.find(accountIdReviewed);
	}

	@PostMapping
	public Core save(@RequestBody CourseComment courseComment) {
		final Core core = new Core();
		if (courseComment.getCommentContent() == "") {
			core.setMessage("無輸入資訊");
			core.setSuccessful(false);
		} else {
			Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
			courseComment.setCreatedAt(currentTimestamp);
			courseComment.setUpdatedAt(currentTimestamp);
			System.out.println("照片>>"+courseComment.getPhoto());
			core.setMessage("新增成功");
			core.setSuccessful(service.save(courseComment));
		}
		System.out.println(core.isSuccessful());
		return core;
	}

	@DeleteMapping("/{commentId}")
	public boolean deleteComment(@PathVariable("commentId") Integer commentId) {
		System.out.println("成功刪除");
		return service.remove(commentId);
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
			String filePath =  projectRootPath + "/" + relativePath + "comment/"+fileName;
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

}
