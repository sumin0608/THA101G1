package tw.idv.ixercise.event.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import tw.idv.ixercise.event.entity.*;
import tw.idv.ixercise.event.repository.*;

import java.util.*;

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

    public List<Event> findAllEvent() {
        System.out.println("findEventById");
        List<Event> eventList = eventRepository.findAll();
        System.out.println(eventList);
        return eventList;
    }

    //blob
//    public byte[] readBlobData(Integer entityId) {
//        // 通过ID从数据库中获取实体对象
//        byte[] entity = eventRepository.findPhotoByEventId(entityId);
////        Event entity = eventRepository.findById(entityId).orElse(null);
//        if (entity != null) {
//            // 返回Blob数据
//            return entity.getPhoto();
//        }
//
//        return null;
//    }


    // 其他操作方法省略
}
