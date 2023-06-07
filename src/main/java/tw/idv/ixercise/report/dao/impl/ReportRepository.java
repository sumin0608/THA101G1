package tw.idv.ixercise.report.dao.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.idv.ixercise.report.entity.Comment;
import tw.idv.ixercise.report.entity.Report;

//街口泛型說明 <T, ID> T表示操作的實體類是誰,在實體類上配置和表的映射關係 id為主件數具類型
//pageable 一個分頁對象
//?1把後面參數第一個給到裡面

public interface ReportRepository extends JpaRepository<Report,Integer>{
	 
	//可以增刪改查  nativeQuery = true要開啟
	@Query(value="select COUNT(*) from report where reportStatus =1 ",nativeQuery = true)
	Integer getCount( );
	
	@Query(value="select COUNT(*) from report where memberId =?1 and memberId2=?2 ",nativeQuery = true)
	 Integer getcheck(Integer memberId,Integer memberId2) ;
	
	   @Query(value="select * FROM  report ORDER BY reportId DESC",nativeQuery = true)
	    Page<Report> findByStatus( Pageable pageable);
	

}
