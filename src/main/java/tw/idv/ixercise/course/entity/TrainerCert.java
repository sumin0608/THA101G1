package tw.idv.ixercise.course.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import tw.idv.ixercise.core.Core;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter

@Entity
@Table(name = "trainer_cert")
public class TrainerCert extends Core{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "number",insertable = false)
	private Integer number;
	@Column(name = "cert_name")
	private String certName;
	@Column(name = "english_cert_name")
	private String englishCertName;
	@Column(name = "abbr_name")
	private String abbrName;

	// Constructor
	public TrainerCert() {
		
	}
	
	public TrainerCert(String certName, String englishCertName, String abbrName) {
		this.certName = certName;
		this.englishCertName = englishCertName;
		this.abbrName = abbrName;
	}
	
	public TrainerCert(int number, String certName, String englishCertName, String abbrName) {
		this.number = number;
		this.certName = certName;
		this.englishCertName = englishCertName;
		this.abbrName = abbrName;
	}


//	public int getNumber() {
//		return number;
//	}
//
//	public String getCertName() {
//		return certName;
//	}
//
//	public String getEnglishCertName() {
//		return englishCertName;
//	}
//
//	public String getAbbrName() {
//		return abbrName;
//	}
//
//	public void setNumber(int number) {
//		this.number = number;
//	}
//
//	public void setCertName(String certName) {
//		this.certName = certName;
//	}
//
//	public void setEnglishCertName(String englishCertName) {
//		this.englishCertName = englishCertName;
//	}
//
//	public void setAbbrName(String abbrName) {
//		this.abbrName = abbrName;
//	}

	@Override
	public String toString() {
		return "TrainerCert資料{" + "number=" + number + ", certName='" + certName + '\'' + ", englishCertName='"
				+ englishCertName + '\'' + ", abbrName='" + abbrName + '\'' + '}';
	}

}
