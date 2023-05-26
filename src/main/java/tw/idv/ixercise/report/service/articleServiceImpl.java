package tw.idv.ixercise.report.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import tw.idv.ixercise.report.dao.articleDao;
import tw.idv.ixercise.report.dao.impl.articleDaoImpl;
import tw.idv.ixercise.report.entity.Article;

@Service
public class articleServiceImpl {
//	@Autowired
//	private articleDao dao;
	
	@Autowired
	private articleDaoImpl dao;
	
	

	public List<Article> findAll() {
		return dao.selectAll();
	}

	@Transactional
	public boolean remove(Integer id) {
		return dao.deleteById(id) > 0;
	}

//	@Transactional
//	public boolean save(Article article) {
//		return dao.update(article) > 0;
//	}

}
