package tw.idv.ixercise.event.repository;

import org.hibernate.*;
import org.hibernate.query.*;
import org.hibernate.query.Query;
import org.springframework.stereotype.*;
import tw.idv.ixercise.event.entity.*;

import javax.persistence.*;

@Repository
public class EventDaoImpl {

    @PersistenceContext
    private Session session;

    public Event getPhoto(Integer eventId) {
        String hql = "SELECT * FROM event WHERE eventId = :evtId";
        Query<Event> evtId = session.createNativeQuery(hql, Event.class)
                .setParameter("evtId", eventId);

        Event event = evtId.getSingleResult();
        return event;
    }

}
