package tw.idv.ixercise.event.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import tw.idv.ixercise.event.entity.*;
import tw.idv.ixercise.event.ropository.*;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

//    @Autowired
//    public EventService(EventRepository eventRepository) {
//        System.out.println("EventService 被創建");
//        this.eventRepository = eventRepository;
//    }

    public Event saveEvent(Event event) {
        System.out.println("saveEvent");
        Event savedEvent = eventRepository.save(event);
        System.out.println(savedEvent);
        return savedEvent;
    }
    public void findByEventName(String event) {
        System.out.println("saveEvent");
        eventRepository.findByEventName(event);
    }

    public Event findEventById(Integer eventId) {
        System.out.println("findEventById");
        Event event = eventRepository.findById(eventId).orElse(null);
        System.out.println(event);
        return event;
    }


    // 其他操作方法省略
}
