package tw.idv.ixercise.event.entity;

import lombok.*;
import tw.idv.ixercise.core.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "event_and_attendees")
public class EventAndAttendees extends Core {
    @Id
    @Column(name = "eventId")
    private Integer eventId;

    @Column(name = "creatorId")
    private Integer creatorId;

    @Column(name = "eventName")
    private String eventName;

    @Column(name = "price")
    private Integer price;

    @Column(name = "eventDate")
    private Date eventDate;

    @Column(name = "startTime")
    private Time startTime;

    @Column(name = "deadline")
    private Timestamp deadline;

    @Column(name = "createDate")
    private Timestamp createDate;

    @Column(name = "maxAttendees")
    private Integer maxAttendees;

    @Column(name = "description")
    private String description;

    @Column(name = "photo")
    private byte[] photo;

    @Column(name = "location")
    private String location;

    @Column(name = "address")
    private String address;

    @Column(name = "addressUrl")
    private String addressUrl;

    @Column(name = "addressNickname")
    private String addressNickname;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "categoryId")
    private Integer categoryId;

    @Column(name = "currentAttendees")
    private Integer currentAttendees;

    @Column(name = "status")
    private Integer status;

    @Column(name = "paymentMethod")
    private Integer paymentMethod;

    @Column(name = "attendId")
    private Integer attendId;

    @Column(name = "accountId")
    private Integer accountId;

    @Column(name = "attendTime")
    private Timestamp attendTime;

    @Column(name = "attendeeStatus")
    private Integer attendeeStatus;

    @Column(name = "reason")
    private String reason;

    @Column(name = "commentStatus")
    private Integer commentStatus;
}


