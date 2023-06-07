package tw.idv.ixercise.report.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import tw.idv.ixercise.report.dao.impl.ReportRepository;
import tw.idv.ixercise.report.entity.Report;

@Service
public class ReportServiceImplJpa {
	
	@Autowired
	private ReportRepository reportRepository;
	
	  public Page<Report> findByStatus(Pageable pageable) {
	        return reportRepository.findByStatus(pageable);
	    }
	  
	  public Integer getcheck(Integer memberId,Integer memberId2) {
		  return reportRepository.getcheck(memberId,memberId2);
	  } 
	  
	  
	  public Integer getCount( ) {
		  return reportRepository.getCount( );
	  } 
}
