package tw.idv.ixercise.report.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.idv.ixercise.report.dao.impl.reportDaoImpl;
import tw.idv.ixercise.report.entity.Report;

@Service
public class reportServiceImpl {

	
	

		
		@Autowired
		private reportDaoImpl dao;
		
		
		
		

		public List<Report> findAll() {
			
			return dao.selectAll();
			
		}
		

		public Report findone(Integer id) {
			return dao.selectById(id);
		}
		
//		boolean update(int reportStatus) {
//			dao.update(reportStatus);
//		}
		

//		@Transactional
//		public boolean remove(Integer id) {
//			return dao.deleteById(id) > 0;
//		}

		@Transactional
		public boolean save(Report report) {
			return dao.insert(report) ;
		}

	}


