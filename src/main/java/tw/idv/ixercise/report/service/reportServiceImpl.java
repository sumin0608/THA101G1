package tw.idv.ixercise.report.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.idv.ixercise.account.entity.Account;
import tw.idv.ixercise.report.dao.impl.reportDaoImpl;
import tw.idv.ixercise.report.entity.Report;

@Service
public class reportServiceImpl {
	

	
	

		
		@Autowired
		private reportDaoImpl dao;
		
		
		
		

		public List<Report> findAll() {
			
			return dao.selectAll();
			
		}
		
		public Account getAccount(Integer id) {
			return	dao.getAccount(id);
		}
		
		
		public Report findone(Integer id) {
			return dao.selectById(id);
		}
		
		public boolean update(Integer id,Integer status) {
		 return	dao.update(id,status);
		}
		
		public boolean updatereport(Integer id) {
			 return	dao.updatereport(id);
			}
			
	

		@Transactional
		public boolean remove(Integer id) {
			return dao.deleteById(id);
		}

		@Transactional
		public boolean save(Report report) {
			System.out.println(report.getReportTime());
			return dao.insert(report) ;
		}

	}


