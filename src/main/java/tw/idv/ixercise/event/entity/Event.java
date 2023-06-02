package tw.idv.ixercise.event.entity;


import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.springframework.data.jpa.domain.support.*;
import tw.idv.ixercise.core.*;
import tw.idv.ixercise.event.repository.CustomTimeDeserializer;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.sql.*;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EVENT")
// 啟用審計(Auditing)的實體中都必須註冊這個 Listener，否則是沒有效果
@EntityListeners(AuditingEntityListener.class)
// (Java端)類別名 與 (資料庫端)資料表名 相同時，可省略name
public class Event extends Core {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Mysql's auto increment in hibernate -> IDENTITY 資料庫端的⾃動編號機制產⽣
    @Column(name = "eventId")  //Upper lower case doesn't matter
    private Integer eventId;
    private Integer creatorId;
    @Column(name = "eventName") //若 程式端名稱 與 資料庫端名稱 相同(不區分⼤⼩寫)時，會⾃動映射 --> 可省略 @Column
    private String eventName;
    private Integer price;
    @Future
    private Date eventDate;
    //    @JsonDeserialize(using = CustomTimeDeserializer.class)
    @JsonFormat(pattern = "HH:mm:ss")
    private Time startTime;
    @Future
    private Timestamp deadline;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    @Column(insertable = false)
    private Timestamp createDate;
    private Integer maxAttendees;
    private String description;
    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] photo;
    private String location;
    private String address;
    private String city;
    private String district;
    //    @JsonIgnore
//    @JsonInclude(JsonInclude.Include.NON_NULL) // Include the property during deserialization if it's not null
    private Integer categoryId;
    @Column(insertable = false)
    private Integer currentAttendees;
    @Column(insertable = false)
    private Integer status;
    //    @JsonIgnore
//    @JsonInclude(JsonInclude.Include.NON_NULL) // Include the property during deserialization if it's not null
    private Integer paymentMethod;

    //====== messages =====
//    @Transient
//    private String messages;
//    @Transient
//    private boolean successful;
    // ===== reformatting ======
    @Transient
    private String moneyDivisionMethod;
    @Transient
    private String eventStatus;
    @Transient
    private String lastVerifyDateAndTime;
    @Transient
    private String eventStartDate;
    @Transient
    private String eventStartTime;

    @Transient
    private List<Event> eventList;


    public Event(String eventName, Integer price) {
        this.eventName = eventName;
        this.price = price;
    }


    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", creatorId=" + creatorId +
                ", eventName='" + eventName + '\'' +
                ", price=" + price +
                ", eventDate=" + eventDate +
                ", startTime=" + startTime +
                ", deadline=" + deadline +
                ", createDate=" + createDate +
                ", maxAttendees=" + maxAttendees +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", categoryId=" + categoryId +
                ", currentAttendees=" + currentAttendees +
                ", status=" + status +
                ", paymentMethod=" + paymentMethod +
                ", moneyDivisionMethod='" + moneyDivisionMethod + '\'' +
                ", lastVerifyDateAndTime='" + lastVerifyDateAndTime + '\'' +
                ", eventStartDate='" + eventStartDate + '\'' +
                ", eventStartTime='" + eventStartTime + '\'' +
                ", eventList=" + eventList +
                '}';
    }
}




