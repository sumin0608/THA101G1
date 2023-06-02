package tw.idv.ixercise.event.entity;

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
    private Timestamp attendTime;
    private Integer commentStatus;

}
