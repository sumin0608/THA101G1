package tw.idv.ixercise.event.repository;

import org.springframework.data.jpa.repository.*;
import tw.idv.ixercise.course.entity.*;
import tw.idv.ixercise.event.entity.*;

import java.util.*;

public interface EventAndAttendeesRepository extends JpaRepository<EventAndAttendees, Integer> {

    List<EventAndAttendees> findByAccountId(Integer accountId);

    List<EventAndAttendees> findByEventId(Integer eventId);

    List<EventAndAttendees> findByEventIdAndAndAttendeeStatus(Integer eventId, Integer attendeesStatus);
}
