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
    private Integer skillId;
    @Column
    private Integer accountId;
    @Column
    private String licenseName;
    @Column
    private Integer sportType;
    @Column
    private byte[] licensePhoto;
    @Column
    private Integer skillState;
    @Transient
    private String accountName;

    public CoachSkill(boolean success,String message){
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
}
