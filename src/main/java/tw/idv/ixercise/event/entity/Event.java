package tw.idv.ixercise.event.entity;


import lombok.*;
import org.springframework.data.jpa.domain.support.*;

import javax.persistence.*;
import java.sql.*;
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EVENT")
// 啟用審計(Auditing)的實體中都必須註冊這個 Listener，否則是沒有效果
@EntityListeners(AuditingEntityListener.class)
// (Java端)類別名 與 (資料庫端)資料表名 相同時，可省略name
public class Event{


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Mysql's auto increment in hibernate -> IDENTITY 資料庫端的⾃動編號機制產⽣
    @Column(name = "eventId")  //Upper lower case doesn't matter
    private Integer eventId;
    private Integer creatorId;
    @Column(name = "eventName") //若 程式端名稱 與 資料庫端名稱 相同(不區分⼤⼩寫)時，會⾃動映射 --> 可省略 @Column
    private String eventName;
    private Integer price;
    private Date eventDate;
    private Time startTime;
    private Date deadline;
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
    private Integer categoryId;
    private Integer currentAttendees;
    private Integer status;
    private Integer paymentMethod;


    public Event(String eventName,Integer price){
        this.eventName=eventName;
        this.price=price;
    }

}




