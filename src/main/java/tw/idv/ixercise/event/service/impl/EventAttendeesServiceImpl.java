package tw.idv.ixercise.event.service.impl;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import tw.idv.ixercise.core.*;

import tw.idv.ixercise.event.entity.*;
import tw.idv.ixercise.event.repository.*;
import tw.idv.ixercise.event.service.*;

import java.sql.*;
import java.util.*;

@Service
public class EventAttendeesServiceImpl implements EventAttendeesService {


    private static final Map<Integer, String> statusMap;

    static {
//       1.參加待審核 2.通過 3.未通過 4:退出待審核 5.退出成功
        statusMap = new HashMap<>();
        statusMap.put(1, "參加待審核");
        statusMap.put(2, "通過");
        statusMap.put(3, "未通過");
        statusMap.put(4, "退出待審核");
        statusMap.put(5, "退出成功");
    }

    @Autowired
    private AttendeesRepository attendeesRepo;
    //    @Autowired
//    private eventDao eventDao;
    @Autowired
    private EventRepository eventRepo;
    @Autowired
    private EventAndAttendeesRepository aaar;


    @Override
    public Core save(Attendees attendees) {
        System.out.println("<<<<<<<<<<save>>>>>>>>>>>");
        Attendees savedAttendee = null;
        Timestamp attendDeadline;
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        List<EventAndAttendees> byEventIdID = aaar.findByEventIdAndAndAttendeeStatus(attendees.getEventId(), 2);
        int passedSize = byEventIdID.size();

        Event event = eventRepo.findByEventId(attendees.getEventId());

//		List<eventAttendee> size = repository.findByeventId(24);
        System.out.println("size");
        System.out.println(passedSize);

//		if (event != null) {
//			System.out.println(event);
//			// 拿到欲報名課程的最後省和時間
        attendDeadline = event.getDeadline();
////			eventAttendee
        Integer maximumCapacity = event.getMaxAttendees();
        System.out.println(maximumCapacity);
        boolean lessOrEqualsToMaxCapacity = (passedSize + 1) <= maximumCapacity;
        boolean equalsToMaxCapacity = (passedSize + 1) == maximumCapacity;
        boolean afterDeadLine = attendDeadline.before(currentTimestamp);

//		System.out.println(b);
        Integer eventStatus = event.getStatus();
        boolean b1 = event.getStatus() == 5;
        Integer accountId = attendees.getAccountId();
        Integer eventId = attendees.getEventId();
        System.out.println(accountId);
        System.out.println(eventId);
        //判斷是否此用戶已參加過
        List<Attendees> byeventIdAndAccountId = attendeesRepo.findByEventIdAndAccountId(attendees.getEventId(), attendees.getAccountId());
        System.out.println(byeventIdAndAccountId);
        Core core = new Core();

        //5. 已滿團  6.報名時間已截止>.<   ELSE此課程不可參加   1. 可參加
        if (!byeventIdAndAccountId.isEmpty()) {
            System.out.println("您她媽的已參加過了");
            core.setMessage("您已報名過了");
            core.setSuccessful(false);
        } else if (maximumCapacity == passedSize) {
//			eventStatus == 5 &&
            core.setMessage("已滿團");
            core.setSuccessful(false);

//			5. 已滿團

        } else if (afterDeadLine) {
//			eventStatus == 6 ||
            if (afterDeadLine) {
                event.setStatus(6);
            }
            core.setMessage("報名失敗: 報名時間已截止>.<");
            core.setSuccessful(false);
//			6.報名時間已截止>.<
        } else if (lessOrEqualsToMaxCapacity) {
//			eventStatus == 1 &&
            if (equalsToMaxCapacity) {
                event.setStatus(5);
                System.out.println("<<<<<滿團>>>>>>>>");
            }
            attendees.setAttendTime(currentTimestamp);  //通過驗證才需做的動作
            System.out.println("<<<<<<<save to DB>>>>>");


            savedAttendee = attendeesRepo.save(attendees);
            if (savedAttendee != null) {
//                event.setStatus(1);
                event.setCurrentAttendees(event.getCurrentAttendees() + 1);
                eventRepo.save(event);
                System.out.println(savedAttendee);
                System.out.println("成功到savedAttendee>");
                core.setMessage("報名成功 請等待主糾審核");
                core.setSuccessful(true);
            }
//					1. 可參加

        } else {
            core.setMessage("此課程不可參加");
            core.setSuccessful(false);

//			此課程不可參加
        }

//		eventDao.
        //跟新狀態
//		eventRepository.save(event);
        System.out.println(event);
        System.out.println(core);
        return core;


    }
}
