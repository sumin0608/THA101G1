package tw.idv.ixercise.course.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseStatusDto {

    private boolean applicationDeadlinePassed;

    private boolean courseStarted;

    private boolean alreadyApplied;

    private Integer courseStatus;

    private Integer courseAttendeesStatus;

    private boolean isCreator;

    private String attendeesStatusString;

}
