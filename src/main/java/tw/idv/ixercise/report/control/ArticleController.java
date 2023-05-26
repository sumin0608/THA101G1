package tw.idv.ixercise.report.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.ixercise.report.entity.Article;
import tw.idv.ixercise.report.service.articleServiceImpl;

@Controller
@RequestMapping("/back/")
public class ArticleController {

	
	@Autowired
	private articleServiceImpl service;
	
	@CrossOrigin(origins = "http://127.0.0.1:5500/*")
	@GetMapping({"/article"})
	@ResponseBody
	public List<Article> articlelist( ) {
		List<Article> memberList = service.findAll();
		
		return memberList;
	}
}
