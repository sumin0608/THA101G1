package tw.idv.ixercise.course.dao;

import java.util.List;

import tw.idv.ixercise.course.entity.*;

public interface TrainerCertDao {

	public List<TrainerCert> getAll();
	public List<TrainerCert> selectTrainerCertByName(String cert_name);
	public TrainerCert ckeckTrainerCertByName(String cert_name);
//	public TrainerCert selectTrainerCertById(Integer id);
	
	public int addTrainerCert(TrainerCert trainerCert);
	public int deleteTrainerCert(Integer id);
	public int updateTrainerCert(TrainerCert trainerCert);
}
