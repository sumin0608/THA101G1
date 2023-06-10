package tw.idv.ixercise.event.repository;

import org.springframework.data.jpa.repository.*;
import tw.idv.ixercise.event.entity.*;

import java.util.*;

public interface AttendeesRepository extends JpaRepository<Attendees, Integer> {

    List<Attendees> findByCommentStatus(Integer commentStatus);

    List<Attendees> findByAttendeeStatus(Integer status);

    List<Attendees> findByAccountId(Integer accountId);

    List<Attendees> findByEventId(Integer eventId);

    Attendees findByAttendId(Integer attendId);

    List<Attendees> findByEventIdAndAccountId(Integer eventId, Integer accountId);

}
