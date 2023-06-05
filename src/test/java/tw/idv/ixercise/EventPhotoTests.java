package tw.idv.ixercise;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.junit4.SpringRunner;
import tw.idv.ixercise.course.entity.*;
import tw.idv.ixercise.course.service.*;
import tw.idv.ixercise.course.service.impl.*;
import tw.idv.ixercise.event.repository.*;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class EventPhotoTests {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventDaoImpl eventDao;

    @Autowired
    private CourseAttendeeService courseAttendeeService;
    @Autowired
    private CourseService courseService;


    public void setUp() {
        // 刪除所有資料
//		eventRepository.deleteAll();
    }


    @Test
    void contextLoads() throws Exception {
//       //報名課程測試 --> passed
//        CourseAttendee courseAttendee = new CourseAttendee();
//        courseAttendee.setCourseId(23);
//        courseAttendee.setAccountId(5);
//        courseAttendee.setStatus(2);
//        courseAttendee.setReason("朋友");
//        System.out.println(courseAttendeeService.save(courseAttendee));

//        //課程狀態對應回傳測試 --> passed
//        List<Course> coursesByCreator = courseService.findCoursesByCreator(2);
//        coursesByCreator.forEach(System.out::println);

        //getCalendar --> passed
        List<Course> calendar = courseAttendeeService.getCalendar(5);
        System.out.println(calendar);
//        calendar.forEach(System.out::println);

        // get photo test --> passed
//        Event photo = eventDao.getPhoto(204);
//        System.out.println(photo);


        //save event test --> passed
//        eventRepository.save(new Event("來踢球", 333));
//        eventRepository.save(new Event("打code", 444));
//        eventRepository.save(new Event("好累", 555));
//        eventRepository.save(new Event("想睡覺", 666));
//        eventRepository.save(new Event("外面再打雷", 777));

//        System.out.println(eventRepository.findById(1));

        System.out.println("====================== passed history ================================");
//        System.out.println(eventRepository.findAll());

        // 測試findAll, 查詢所有資料
//        Assert.assertEquals(5, eventRepository.findAll().size());

//        // 測試findByName, 查詢姓名為FFF的Customer
//        Assert.assertEquals(100000, eventRepository.findByEventNameContaining("\uD83C\uDF3A\uD83C\uDF34足球好8。").get(0).getPrice().longValue());
////        String str = "\uD83C\uDF34nn足";
//        String strs = " \uD83C\uDF3A\uD83C\uDF34拍繡球花、烤肉玩水一日遊。 ";
//        String str = strs.trim();
//        Assert.assertEquals(9, eventRepository.findByEventNameContaining(str).size());
//        Assert.assertEquals(9, eventRepository.findByEventNameContainingOrLocationContaining(str, str).size());
////        Assert.assertEquals(9, eventRepository.findByEventNameContainingAndLocationContaining(str, str).size());
//        Assert.assertEquals(9, eventRepository.findByEventNameContainingOrLocationContainingOrAddressContainsOrDescriptionContains(str, str, str, str).size());
//
//        Assert.assertEquals(9, eventRepository.findByEventNameContainingIgnoreCaseAndStatusOrLocationContainingIgnoreCaseOrAddressContainsIgnoreCaseOrDescriptionContainsIgnoreCaseOrderByEventDateDesc(str, 1, str, str, str).size());
//        Assert.assertEquals(1000000, eventRepository.findByEventNameContainingOrLocationContaining(str, str).get(0).getPrice().longValue());


    }

    //    public void saveEvent(Event event) {
//        System.out.println("saveEvent");
//        eventRepository.save(event);
//    }
//
//    public Event getEventById(Integer id) {
//        System.out.println("getEventById");
//        return eventRepository.findById(id).orElse(null);
}



