package tw.idv.ixercise.event.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import tw.idv.ixercise.event.entity.*;
import tw.idv.ixercise.event.repository.*;

import java.sql.*;
import java.sql.Date;
import java.text.*;
import java.util.*;
import java.util.stream.*;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    private static final Map<Integer, String> statusMap;
    private static final Map<Integer, String> MONEY_DIVISION_MAP;

    static {
        // Mapping of status values to their Traditional Chinese string representation

//        1.可參加 (未开始)  2. 活動已結束(+3) 3. 截止報名 4:滿團自行下架 5:自行下架 6:強制下架 ?? 未开始 进行中 (預計結束時間
        statusMap = new HashMap<>();
        statusMap.put(1, "可參加");
        statusMap.put(2, "活動已結束");
        statusMap.put(3, "截止報名");
        statusMap.put(4, "滿團");
        statusMap.put(5, "自行下架");
        statusMap.put(6, "強制下架");

        //  1.我出錢 2.各付各的 3. 平均分攤 4. 我請客 你出錢
        MONEY_DIVISION_MAP = new HashMap<>();
        MONEY_DIVISION_MAP.put(1, "我出錢");
        MONEY_DIVISION_MAP.put(2, "各付各的");
        MONEY_DIVISION_MAP.put(3, "平均分攤");
        MONEY_DIVISION_MAP.put(4, "我請客 你出錢");
    }


//    @Autowired
//    public EventService(EventRepository eventRepository) {
//        System.out.println("EventService 被創建");
//        this.eventRepository = eventRepository;
//    }

    public Event saveEvent(Event event) {


        System.out.println("saveEvent");
        Event savedEvent = eventRepository.save(event);
        System.out.println(savedEvent);
        //price < 100000
        return savedEvent;
    }

//    public String dateFormate(String formate, ){
//        SimpleDateFormat sdfTimeStamp = new SimpleDateFormat("yyyy年 MMMM dd日 a hh:mm", Locale.TAIWAN);
//        sdfTimeStamp.format(;
//    }

    public Event findEventById(Integer eventId) {
        System.out.println("findEventById");
        Event event = eventRepository.findById(eventId).orElse(null);

        if (event != null) {
            // ==== time reformat == start ==
            Timestamp deadline = event.getDeadline();
            Date eventDate = event.getEventDate();
            Time startTime = event.getStartTime();
            Integer paymentMethod = event.getPaymentMethod();
            Integer status = event.getStatus();

            SimpleDateFormat sdfTimeStamp = new SimpleDateFormat("yyyy年 MMMM dd日 a hh:mm", Locale.TAIWAN);
            SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy年 MMMM dd日", Locale.TAIWAN);
            SimpleDateFormat sdfTime = new SimpleDateFormat("a hh:mm", Locale.TAIWAN);

            event.setLastVerifyDateAndTime(sdfTimeStamp.format(deadline));
            event.setEventStartDate(sdfDate.format(eventDate));
            event.setEventStartTime(sdfTime.format(startTime));
            // ==== time reformat == end ==

            // ==== map the "paymentMethod" : int to String  ==========
//            1.我出錢 2.各付各的 3. 平均分攤 4. 我請客 你出錢
            event.setMoneyDivisionMethod(MONEY_DIVISION_MAP.getOrDefault(paymentMethod, "未知分錢法"));
            event.setEventStatus(statusMap.getOrDefault(status, "未知狀態"));

            return event;
        }
        Event eventError = new Event();
        eventError.setSuccessful(false);
        eventError.setMessage("No such event found");
        return eventError;
    }

    public void findByEventName(String event) {
        System.out.println("saveEvent");
        eventRepository.findByEventName(event);
    }

    public List<Event> findAllEvent() {
        System.out.println("findEventById");
        List<Event> eventList = eventRepository.findAll();
        System.out.println(eventList);
        return eventList;
    }

    public List<Event> findEventsByInput(String searchInput) {
        String trimmedInput = searchInput.trim();

        List<Event> eventList = null;
        try {
            eventList = eventRepository.findByEventNameContainingIgnoreCaseAndStatusOrLocationContainingIgnoreCaseOrAddressContainsIgnoreCaseOrDescriptionContainsIgnoreCaseOrderByEventDateDesc(trimmedInput, 1, trimmedInput, trimmedInput, trimmedInput);
//            ).stream().collect(Collectors.toList(Collectors.toList())
//            eventList = eventRepository.findByEventNameContainingOrLocationContaining(trimmedInput, trimmedInput);
            System.out.println("<<<<< service : Input search >>>>>>");
            System.out.println(eventList);
            if (!eventList.isEmpty()) {
                System.out.println("return success");
                return eventList;
            } else {
                System.out.println("throws exception");
                throw new NullPointerException();
//                throw new IndexOutOfBoundsException();
//                Event event = new Event();
//                return ;
            }
        } catch (Exception e) {
//            eventList = new ArrayList<>();
            System.out.println("No search results");
            Event errorevent = new Event();
            errorevent.setMessage("No search results");
            errorevent.setSuccessful(false);
            eventList.add(errorevent);
            e.printStackTrace();
            return eventList;
        }


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
