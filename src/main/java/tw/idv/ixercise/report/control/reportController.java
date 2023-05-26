package tw.idv.ixercise.report.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report/")
public class reportController {
	@GetMapping({"/{id}"})
	public String getbyid(@PathVariable Integer id) {
		return "hello"; 
	} 
	
	

}
