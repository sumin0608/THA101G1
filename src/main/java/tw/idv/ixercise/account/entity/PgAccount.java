package tw.idv.ixercise.account.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tw.idv.ixercise.core.Core;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class PgAccount extends Core {

    private static final long serialVersionUID = -4157805481963417348L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
    private Integer accountLevel;
    private Integer accountState;
    private byte[] accountPhoto;
    private String AccountNickname;
    private String accountAddress;
    private Integer accountGender;
    private String accountIntro;
    private List<CoachSkill> CoachSkillList;

    public PgAccount(Boolean result, String msg) {
        super(result, msg);
    }

    public PgAccount(Account account, List<CoachSkill> CoachSkillList) {
        super(account.isSuccessful(), account.getMessage());
        this.accountId = account.getAccountId();
        this.accountLevel = account.getAccountLevel();
        this.accountState = account.getAccountState();
        this.accountPhoto = account.getAccountPhoto();
        this.AccountNickname = account.getAccountNickname();
        this.accountAddress = account.getAccountAddress();
        this.accountGender = account.getAccountGender();
        this.accountIntro = account.getAccountIntro();
        this.CoachSkillList = CoachSkillList;
    }

    public PgAccount(Account account) {
        super(account.isSuccessful(), account.getMessage());
        this.accountId = account.getAccountId();
        this.accountLevel = account.getAccountLevel();
        this.accountState = account.getAccountState();
        this.accountPhoto = account.getAccountPhoto();
        this.AccountNickname = account.getAccountNickname();
        this.accountAddress = account.getAccountAddress();
        this.accountGender = account.getAccountGender();
        this.accountIntro = account.getAccountIntro();

    }
}
