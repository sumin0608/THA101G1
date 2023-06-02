package tw.idv.ixercise.account.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tw.idv.ixercise.core.Core;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class CourseAccount extends Core {

    private static final long serialVersionUID = -4157805481963417348L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    private byte[] accountPhoto;

    private String accountAddress;

    private String accountNickname;

    //    private Integer accountLevel;

//    private Integer accountState;
//
//    @Column(insertable = false)
//    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
//    private Timestamp accountCreatetime;
//    @Column(insertable = false)
//    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
//    private Timestamp accountUpdatetime;

    public CourseAccount(Account account) {
        super(account.isSuccessful(), account.getMessage());
        this.accountId = account.getAccountId();
        this.accountPhoto = account.getAccountPhoto();
        this.accountAddress = account.getAccountAddress();
        this.accountNickname = account.getAccountNickname();
    }
}
