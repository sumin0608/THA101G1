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
import java.util.Arrays;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class ApplyCoachDTO extends Core {

    private static final long serialVersionUID = -4157805481963417348L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    private String accountBank;

    private Integer sportType;

    private String licenseName;

    private byte[] licensePhoto;

    @Override
    public String toString() {
        return "ApplyCoachDTO{" +
                "accountId=" + accountId +
                ", accountBank='" + accountBank + '\'' +
                ", sportType=" + sportType +
                ", licenseName='" + licenseName + '\'' +
                ", licensePhoto=" + Arrays.toString(licensePhoto) +
                '}';
    }
}
