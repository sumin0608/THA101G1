package tw.idv.ixercise.course.service;

import java.util.List;

import tw.idv.ixercise.course.entity.TrainerCert;

public interface TrainerCertService {
	TrainerCert addnew(TrainerCert trainerCert);

	List<TrainerCert> getall();

	boolean remove(Integer id);

	TrainerCert edit(TrainerCert trainerCert);

	List<TrainerCert> get(String certName);
}
