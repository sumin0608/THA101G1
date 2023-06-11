package tw.idv.ixercise.event.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import tw.idv.ixercise.core.*;

import javax.persistence.*;
import java.sql.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EVENT_ATTENDEES")
public class Attendees extends Core {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attendId;
    private Integer eventId;
    private Integer accountId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp attendTime;
    @Column(insertable = false)
    private Integer attendeeStatus;
    private String reason;
    @Column(insertable = false)
    private Integer commentStatus;


}
