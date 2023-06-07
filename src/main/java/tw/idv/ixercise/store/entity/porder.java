package tw.idv.ixercise.store.entity;

import java.io.Serializable;
import java.util.Date;

public class porder implements Serializable {
	private Integer id;
	private String porderNo;
	private String memberNo;
	private String name;
	private String productName;
	private Integer pamount;

	private Date pdate;
	private String phone;
	private String email;
	
	public porder() {
		super();
		// TODO Auto-generated constructor stub
		this.pdate = new Date();
	}

	public porder(String porderNo, String memberNo, String name, String productName, Integer pamount, String phone,
			String email) {
		super();
		this.porderNo = porderNo;
		this.memberNo = memberNo;
		this.name = name;
		this.productName = productName;
		this.pamount = pamount;
		
		this.phone = phone;
		this.email = email;
		this.pdate = new Date();
	}
	

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPorderNo() {
		return porderNo;
	}

	public void setPorderNo(String porderNo) {
		this.porderNo = porderNo;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getPamount() {
		return pamount;
	}

	public void setPamount(Integer pamount) {
		this.pamount = pamount;
	}

	public Date getPdate() {
		return pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
