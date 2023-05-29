package tw.idv.ixercise.report.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	@GetMapping({"/reportmember"})
	@ResponseBody
	public List<Report> reportlist( ) {
		List<Report> memberList = service.findAll();
		
		return memberList;
	}
	

}
