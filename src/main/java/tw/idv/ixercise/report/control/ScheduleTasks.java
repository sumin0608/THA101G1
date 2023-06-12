package tw.idv.ixercise.report.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import tw.idv.ixercise.report.service.reportServiceImpl;

@Component
public class ScheduleTasks {
		
	@Autowired
	private reportServiceImpl service;
	
	static Integer count=15;

	@Scheduled(cron = "0 2 14 * * ?")
	public void delete() {
			service.remove(count);
			count++;
	}
}
