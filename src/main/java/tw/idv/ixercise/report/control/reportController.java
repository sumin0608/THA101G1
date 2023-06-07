package tw.idv.ixercise.report.control;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
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

import tw.idv.ixercise.report.dao.impl.ReportRepository;
import tw.idv.ixercise.report.entity.Article;
import tw.idv.ixercise.report.entity.Comment;
import tw.idv.ixercise.report.entity.Report;
import tw.idv.ixercise.report.service.ReportServiceImplJpa;
import tw.idv.ixercise.report.service.articleServiceImpl;
import tw.idv.ixercise.report.service.reportService;
import tw.idv.ixercise.report.service.reportServiceImpl;

@Controller
@RequestMapping("/back/")
public class reportController {
	
	
	@Autowired
	private reportServiceImpl service;
	
	
	 
	@Autowired
	private ReportServiceImplJpa jpa;
	
	
	@GetMapping("/memberlist")
	@ResponseBody
	public Page<Report> reportlist(@RequestParam("page") int page) {
	    Pageable pageable = PageRequest.of(page, 10);
	    Page<Report> reportPage = jpa.findByStatus(pageable);
	    System.out.println(reportPage);
	    
	    return reportPage;
	}
	
	
	@PostMapping({"/reportmember"})
	@ResponseBody
	public boolean reportadd(@RequestBody Report report){
		
		Integer reportTime =  jpa.getcheck(report.getMemberId(), report.getMemberId2());
		
		if(reportTime ==0) {
		service.save(report);
		return true;
		}else {
			return false;
		}

	
	}
	
	
	@DeleteMapping({"/reportmember/{id}"})
	@ResponseBody
	public boolean reportdelete(@PathVariable Integer id){
		return service.remove(id);

	
	}
	
	@GetMapping({"/reportStatus"})
	@ResponseBody
	public boolean reportupdate(@RequestParam("id") Integer id, @RequestParam("status") Integer status){
		System.out.println(id+"  "+status);
		return service.update(id,status);

	}
	

	@GetMapping({"/reportmember/{id}"})
	@ResponseBody
	public Report article(@PathVariable Integer id ) {
		return service.findone( id);
		
		
	}
	
	@GetMapping({"/getReportCount"})
	@ResponseBody
	public Integer getCount( ) {
	
		return	 jpa.getCount();

	 }
	

}
