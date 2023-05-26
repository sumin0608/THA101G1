package tw.idv.ixercise.report.dao;

import tw.idv.ixercise.report.Core.CoreDao;
import tw.idv.ixercise.report.entity.Article;
import tw.idv.ixercise.report.entity.Report;

public interface articleDao extends CoreDao<Article, Integer> {

	

	Article selectById(Integer id);
	

}
