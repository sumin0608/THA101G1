package tw.idv.ixercise.report.dao.impl;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import tw.idv.ixercise.account.entity.Account;
import tw.idv.ixercise.report.dao.reportDao;
import tw.idv.ixercise.report.entity.Article;
import tw.idv.ixercise.report.entity.Report;

@Repository
public class reportDaoImpl implements reportDao {

	@PersistenceContext
	private Session session;
	
	
	
	
	public boolean insert(Report report) {
		session.persist(report);
			return true;
		}
	
	public boolean deleteById(Integer id) {
		 Report report = session.get(Report.class, id);
		 session.remove(report);
		 System.out.println();
		 return true;
	}
	
	@Transactional
	public boolean update(Integer id, Integer reportStatus){
		
		Report report = session.get(Report.class,id);
			report.setReportStatus(reportStatus);
		return true;
	}
	
	@Transactional
	public boolean updatereport(Integer id){
		
		Account account = session.get(Account.class,id);
		Integer accountReport = account.getAccountReport();
		System.out.println( accountReport);
		account.setAccountReport((accountReport+1));
		return true;
	}
	

	@Override
	public Report selectById(Integer id) {
	System.out.println(session.get(Report.class, id));
		return session.get(Report.class, id);
	}
	
	
	public List <Report> selectAll() {
		final String hql = " FROM  Report ORDER BY id DESC ";
		return session
				.createQuery(hql,  Report.class)
				.getResultList();
	}
	

	

	
}
