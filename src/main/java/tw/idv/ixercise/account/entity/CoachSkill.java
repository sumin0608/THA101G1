package tw.idv.ixercise.account.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tw.idv.ixercise.core.Core;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CoachSkill extends Core {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer skillId;
    @Column
    private Integer accountId;
    @Column
    @NotNull
    private String licenseName;
    @Column
    @NotNull
    private Integer sportType;
    @Column
    @NotNull
    private byte[] licensePhoto;
    @Column
    private Integer skillState;
    @Transient
    private String accountName;

    public CoachSkill(boolean success, String message) {
        super(success, message);
    }
//    @Override
//    public String toString() {
//        return "CoachSkill{" +
//                "skillId=" + skillId +
//                ", accountId=" + accountId +
//                ", licenseId=" + licenseId +
//                ", sportType=" + sportType +
//                ", licensePhoto=" + Arrays.toString(licensePhoto) +
//                '}';
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CoachSkill that = (CoachSkill) o;

        if (!skillId.equals(that.skillId)) return false;
        if (!accountId.equals(that.accountId)) return false;
        if (!licenseName.equals(that.licenseName)) return false;
        if (!sportType.equals(that.sportType)) return false;
        if (!Arrays.equals(licensePhoto, that.licensePhoto)) return false;
        if (!skillState.equals(that.skillState)) return false;
        return Objects.equals(accountName, that.accountName);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + skillId.hashCode();
        result = 31 * result + accountId.hashCode();
        result = 31 * result + licenseName.hashCode();
        result = 31 * result + sportType.hashCode();
        result = 31 * result + Arrays.hashCode(licensePhoto);
        result = 31 * result + skillState.hashCode();
        result = 31 * result + (accountName != null ? accountName.hashCode() : 0);
        return result;
    }
}
