package tw.idv.ixercise.account.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tw.idv.ixercise.core.Core;

import javax.persistence.*;

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
    Integer skillId;
    @Column
    Integer accountId;
    @Column
    String licenseName;
    @Column
    Integer sportType;
    @Column
    byte[] licensePhoto;
    @Column
    Integer skillState;

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
}
