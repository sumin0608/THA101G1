package tw.idv.ixercise.account.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
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
public class LessAccount extends Core {

        private static final long serialVersionUID = -4157805481963417348L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer accountId;

        private Integer accountLevel;

        private Integer accountState;

        private String accountName;

        @Column(insertable = false)
        @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
        private Timestamp accountCreatetime;
        @Column(insertable = false)
        @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
        private Timestamp accountUpdatetime;

        public LessAccount(Account account) {
                super(account.isSuccessful(), account.getMessage());
                this.accountId = account.getAccountId();
                this.accountLevel = account.getAccountLevel();
                this.accountState = account.getAccountState();
                this.accountName = account.getAccountName();
                this.accountCreatetime = account.getAccountCreatetime();
                this.accountUpdatetime = account.getAccountUpdatetime();
        }
}
