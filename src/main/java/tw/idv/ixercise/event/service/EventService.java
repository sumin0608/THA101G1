package tw.idv.ixercise.event.service;

import tw.idv.ixercise.core.*;
import tw.idv.ixercise.event.entity.*;

import java.util.*;

public interface EventService {
    Event saveEvent(Event event);

    Event findEventById(Integer eventId);

    void findByEventName(String event);

    List<Event> findAllEvent();

    List<Event> findEventsByInput(String searchInput);

}
