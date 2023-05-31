package tw.idv.ixercise.report.control;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.ixercise.report.entity.Article;
import tw.idv.ixercise.report.entity.Report;
import tw.idv.ixercise.report.service.articleServiceImpl;
import tw.idv.ixercise.report.service.reportServiceImpl;

@Controller
@RequestMapping("/back/")
public class reportController {
	
	
	@Autowired
	private reportServiceImpl service;
	
	
	@GetMapping({"/memberlist"})
	@ResponseBody
	public List<Report> reportlist( ) {
		List<Report> memberList = service.findAll();
		
		return memberList;
	}
	
	
	
	@PostMapping({"/reportmember"})
	@ResponseBody
	public boolean reportadd(@RequestBody Report report){
		return service.save(report);
//		System.out.println(report);
//		return false;
	
	}
	
	

	@PutMapping({"/reportmember"})
	@ResponseBody
	public boolean reportupdate(@RequestBody int reportStatus){
//		return service.save(reportStatus);
//		System.out.println(report);
		return false;	
	
	}
	

}
