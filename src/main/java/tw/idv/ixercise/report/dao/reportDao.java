package tw.idv.ixercise.report.dao;

import tw.idv.ixercise.report.entity.Article;
import tw.idv.ixercise.report.entity.Report;

public interface reportDao {
	
	public Article selectById(Integer id);


}
