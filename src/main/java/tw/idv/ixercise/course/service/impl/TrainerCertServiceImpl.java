package tw.idv.ixercise.course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.idv.ixercise.course.dao.TrainerCertDao;
import tw.idv.ixercise.course.entity.TrainerCert;
import tw.idv.ixercise.course.service.TrainerCertService;

@Service
public class TrainerCertServiceImpl implements TrainerCertService {

	@Autowired
	private TrainerCertDao dao;

	@Override
	public TrainerCert addnew(TrainerCert trainerCert) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TrainerCert edit(TrainerCert trainerCert) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TrainerCert> getall() {
		System.out.println("到service成功");
		if (dao.getAll() != null) {
			return dao.getAll();
		} else {
			return null;
		}
	}

	@Override
	public List<TrainerCert> get(String certName) {
		List<TrainerCert> trainerCerts = dao.selectTrainerCertByName(certName);
		if ((trainerCerts).isEmpty()) {
			TrainerCert trainerCert = new TrainerCert(); // 要new新的，因trainerCert回傳null
			trainerCert.setNumber(0);
			trainerCert.setCertName("none");
			trainerCert.setEnglishCertName("none");
			trainerCert.setAbbrName("none");
			trainerCert.setSuccessful(false);
			trainerCert.setMessage("搜尋失敗?");
			trainerCerts.add(trainerCert);
			System.out.println("service印出搜尋失敗");
			return trainerCerts;
		} else {
			for (TrainerCert trainerCert : trainerCerts) {
				trainerCert.setSuccessful(true);
				trainerCert.setMessage("搜尋成功!");
				System.out.println("service印出" + trainerCert);
			}
			return trainerCerts;
		}
	}

}
