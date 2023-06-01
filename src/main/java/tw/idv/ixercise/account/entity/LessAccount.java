package tw.idv.ixercise.account.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tw.idv.ixercise.core.Core;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LessAccount extends Core {

        private static final long serialVersionUID = -4157805481963417348L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer accountId;

        private String accountPhone;

        private String accountPassword;

        private String accountEmail;

        private String accountNickname;

        private Integer accountLevel;

        private Integer accountState;

        private String accountAddress;

        private String accountName;

        private Date accountBirthday;
        @Column(insertable = false)
        @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
        private Timestamp accountCreatetime;
        @Column(insertable = false)
        @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
        private Timestamp accountUpdatetime;

        private Integer accountGender;

        private byte[] accountPhoto;

        private byte[] accountIdoc;

        private String accountIntro;

        private Integer accountReport;

        private String accountBank;

        private String accountVerify;
}
