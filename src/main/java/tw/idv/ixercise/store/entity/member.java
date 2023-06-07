package tw.idv.ixercise.store.entity;

import tw.idv.ixercise.account.entity.Account;

import java.io.Serializable;

public class member implements Serializable{
	/*private Integer id;
	private String member_no;
	private String name;
	private String username;
	private String password;
	private String phone;
	private String email;*/
	private Integer accountId;
	private String accountName;
	private String accountPhone;
	private String accountPassword;
	private String accountEmail;
	
	
	
	public member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public member(Account account){
		this.accountName = account.getAccountName();
		this.accountPhone = account.getAccountPhone();
		this.accountPassword = account.getAccountPassword();
		this.accountEmail = account.getAccountEmail();
	}



	public member(String accountName, String accountPhone, String accountPassword,
			String accountEmail) {
		super();
		//this.member_no = member_no;
		this.accountName = accountName;
		this.accountPhone = accountPhone;
		this.accountPassword = accountPassword;
		this.accountEmail = accountEmail;
	}



	public Integer getId() {
		return accountId;
	}



	public void setId(Integer accountId) {
		this.accountId = accountId;
	}



	public String getName() {
		return accountName;
	}



	public void setName(String accountName) {
		this.accountName = accountName;
	}



	public String getUsername() {
		return accountPhone;
	}



	public void setUsername(String accountPhone) {
		this.accountPhone = accountPhone;
	}



	public String getPassword() {
		return accountPassword;
	}



	public void setPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}



	public String getEmail() {
		return accountEmail;
	}



	public void setEmail(String accountEmail) {
		this.accountEmail = accountEmail;
	}
	
	/*public member(String member_no, String name, String username, String password, String phone, String email) {
		super();
		this.member_no = member_no;
		this.name = name;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMember_no() {
		return member_no;
	}
	public void setMember_no(String member_no) {
		this.member_no = member_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	}*/
	

}
