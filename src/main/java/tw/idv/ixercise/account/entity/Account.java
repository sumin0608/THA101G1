package tw.idv.ixercise.account.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Integer accountId;

    @NotBlank(message = "手機為必填")
    @Pattern(regexp = "^09[0-9]{8}$", message = "手機號碼格式不正確")
    private String accountPhone;
    @NotBlank(message = "密碼為必填")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$", message = "密碼需要至少8個字符，包含數字和字母")
    private String accountPassword;
    @NotBlank(message = "信箱為必填")
    @Email
    private String accountEmail;
    @NotBlank(message = "綽號為必填")
    @Pattern(regexp = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$",message = "姓名只能是中、英、數字及_，且長度為2~10之間")
    private String accountNickname;

    private Integer accountLevel;

    private Integer accountState;
    @NotBlank(message = "地址為必填")
    private String accountAddress;
    @NotBlank(message = "姓名為必填")
    @Pattern(regexp = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$",message = "姓名只能是中、英、數字及_，且長度為2~10之間")
    private String accountName;

    @Past
//    @NotNull(message = "生日為必填")
    private Date accountBirthday;
    @Column(insertable = false)
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp accountCreatetime;
    @Column(insertable = false)
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp accountUpdatetime;
//    @NotNull(message = "性別為必填")
    private Integer accountGender;

    private byte[] accountPhoto;

    private byte[] accountIdoc;
    @NotBlank(message = "自我介紹為必填")
    private String accountIntro;

    private Integer accountReport;
    @Size(min = 12, max = 14, message = "銀行帳號長度必須在12到14位數字")
    private String accountBank;

    private String accountVerify;


    @Override
    public String toString() {
        return "[accountId=" + accountId + ", accountPhone=" + accountPhone + ", accountPassword="
                + accountPassword + ", accountEmail=" + accountEmail + ", accountNickname=" + accountNickname
                + ", accountLevel=" + accountLevel + ", accountState=" + accountState + ", accountAddress="
                + accountAddress + ", accountName=" + accountName + ", accountBirthday=" + accountBirthday
                + ", accountCreatetime=" + accountCreatetime + ", accountUpdatetime=" + accountUpdatetime
                + ", accountGender=" + accountGender + ", accountPhoto=" + "accountPhoto"
                + ", accountIdoc=" + Arrays.toString(accountIdoc) + ", accountIntro=" + accountIntro
                + ", accountReport=" + accountReport + ", accountBank=" + accountBank + ", accountVerify="
                + accountVerify + "]";
    }


}
