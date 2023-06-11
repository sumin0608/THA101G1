package tw.idv.ixercise.event.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import tw.idv.ixercise.core.*;
import tw.idv.ixercise.course.entity.*;
import tw.idv.ixercise.course.service.*;
import tw.idv.ixercise.event.entity.*;
import tw.idv.ixercise.event.service.*;

import java.util.*;

@RestController
@RequestMapping("/eventAttendee")
public class AttendeesController {

    @Autowired
    private EventAttendeesService service;

    // 測試
    @GetMapping("/hello2")
    public String hello() {
        System.out.println("前端成功抵達~");
        return "Hello, World! My bro";
    }

    @PostMapping
    public Core save(@RequestBody Attendees ca) {
        final Core core = new Core();
        System.out.println("save:  " + ca.getReason());
//        if ( "".equals(ca.getReason())) {
        if (ca.getReason() == "" || ca.getReason() == null) {
            core.setMessage("請輸入課程描述");
            core.setSuccessful(false);
            return core;
        } else {

            Core save = service.save(ca);
            System.out.println("參加成功!!!");
            return save;
        }

    }


//    @GetMapping("calander/{accountId}")
//    public List<CourseAndAttendeesEntity> getCalendar(@PathVariable("accountId") Integer accountId) {
////		List<Course> calendarList = service.getCalendar(accountId);
//        System.out.println("getCalendar>>>>>>");
//        List<CourseAndAttendeesEntity> calendarList = service.getCalendarList(accountId);
//        System.out.println(calendarList);
//        return calendarList;
//    }
}
