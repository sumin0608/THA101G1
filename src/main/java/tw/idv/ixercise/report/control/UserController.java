package tw.idv.ixercise.report.control;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	


	@RequestMapping("/test")
	public String login(HttpSession session) {
	
		System.out.println("session 被調用");
		
		String aaa = (String) session.getAttribute("backmemberid1");
		if(aaa == null) {
			session.setAttribute("backmemberid1", "1111");
			
		}
		
//	    System.out.println("backmemberid1 的值：" + session.getAttribute("backmemberid1"));
//	    return "{\"status\": \"OK\"}";
	    return "{\"status\": \"" + aaa + "\"}";
	}
	
	@RequestMapping("/testsession")
	public String logintest(HttpSession session) {
		
		System.out.println("session 被調用");
		String a=(String)session.getAttribute("backmemberid1");
	    System.out.println(a);
	    	return a;
	}
	
	
}
