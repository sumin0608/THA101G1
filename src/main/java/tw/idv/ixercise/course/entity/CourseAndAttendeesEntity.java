package tw.idv.ixercise.course.entity;

import lombok.*;
import tw.idv.ixercise.core.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course_and_attendees")
public class CourseAndAttendeesEntity extends Core {
    @Id
    private Integer courseID;
    private Integer creator;
    private String eventName;
    private Integer expectedPrice;
    private Date courseStartDate;
    private Timestamp courseStartTime;
    private Time courseDuration;
    private Timestamp registrationDeadline;
    private Timestamp courseCreationDate;
    private Integer maximumCapacity;
    private String description;
    private String photo;
    private String location;
    private String city;
    private String district;
    private String detailedAddress;
    private String categoryID;
    private Integer currentEnrolment;
    private Integer courseStatus;
    private Integer paidAdvertising;
    private Timestamp paidAdvertisingTime;
    private Integer attendId;
    private int accountId; // Include accountId column
    private Timestamp attendTime;
    private Integer status;
    private String reason;
    private Integer paymentStatus;
    private Integer commentStatus;

    @Transient
    private String attendeesStatus;
}
