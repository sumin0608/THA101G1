package tw.idv.ixercise.report.dao.impl;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

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
	
	
	public boolean update(int reportStatus){
		session.get(Report.class,1);
		return true;
	}

	@Override
	public Report selectById(Integer id) {
	
		return session.get(Report.class, id);
	}
	
	
	public List <Report> selectAll() {
		final String hql = " FROM  Report ";
		return session
				.createQuery(hql,  Report.class)
				.getResultList();
	}
	

	

	
}
