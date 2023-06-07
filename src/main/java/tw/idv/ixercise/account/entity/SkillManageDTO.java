package tw.idv.ixercise.account.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tw.idv.ixercise.core.Core;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SkillManageDTO extends Core {
    private Integer skillId;
    private Integer accountId;
    private String accountName;
    private String licenseName;
    private Integer sportType;
    private Integer skillState;
    private byte[] licensePhoto;

    public SkillManageDTO(CoachSkill cs,String acname){
        this.skillId = cs.getSkillId();
        this.accountId = cs.getAccountId();
        this.licenseName = cs.getLicenseName();
        this.sportType = cs.getSportType();
        this.licensePhoto = cs.getLicensePhoto();
        this.skillState = cs.getSkillState();
        this.accountName = acname;
    }
}
