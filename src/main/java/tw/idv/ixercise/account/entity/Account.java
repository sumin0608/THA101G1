package tw.idv.ixercise.account.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tw.idv.ixercise.core.Core;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Account extends Core {
	private static final long serialVersionUID = -4157805481963417348L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer accountId;
	@Column
	private String accountPhone;
	@Column
	private String accountPassword;
	@Column
	private String accountEmail;
	@Column
	private String accountNickname;
	@Column
	private Integer accountLevel;
	@Column
	private Integer accountState;
	@Column
	private String accountAddress;
	@Column
	private String accountName;
	@Column
	private String accountBirthday;
	@Column
	private String accountCreatetime;
	@Column
	private String accountUpdatetime;
	@Column
	private Integer accountGender;
	@Column
	private byte[] accountPhoto;
	@Column
	private byte[] accountIdoc;
	@Column
	private String accountIntro;
	@Column
	private Integer accountReport;
	@Column
	private String accountBank;
	@Column
	private String accountVerify;
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountPhone=" + accountPhone + ", accountPassword="
				+ accountPassword + ", accountEmail=" + accountEmail + ", accountNickname=" + accountNickname
				+ ", accountLevel=" + accountLevel + ", accountState=" + accountState + ", accountAddress="
				+ accountAddress + ", accountName=" + accountName + ", accountBirthday=" + accountBirthday
				+ ", accountCreatetime=" + accountCreatetime + ", accountUpdatetime=" + accountUpdatetime
				+ ", accountGender=" + accountGender + ", accountPhoto=" + Arrays.toString(accountPhoto)
				+ ", accountIdoc=" + Arrays.toString(accountIdoc) + ", accountIntro=" + accountIntro
				+ ", accountReport=" + accountReport + ", accountBank=" + accountBank + ", accountVerify="
				+ accountVerify + "]";
	}
	
	
	
	
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "accountId")
//	private Integer accountId;
//	@Column
//	private String accountPhone;
//	@Column
//	private String accountPassword;
//	@Column
//	private String accountEmail;
//	@Column
//	private String accountNickname;
//	@Column
//	private Integer accountLevel;
//	@Column
//	private Integer accountState;
//	@Column
//	private String accountAddress;
//	@Column
//	private String accountName;
//	@Column
//	private String accountBirthday;
//	@Column
//	private String accountCreatetime;
//	@Column
//	private String accountUpdatetime;
//	@Column
//	private Integer accountGender;
//	@Column
//	private byte[] accountPhoto;
//	@Column
//	private byte[] accountIdoc;
//	@Column
//	private String accountIntro;
//	@Column
//	private Integer accountReport;
//	@Column
//	private String accountBank;
//	@Column
//	private String accountVerify;

}
