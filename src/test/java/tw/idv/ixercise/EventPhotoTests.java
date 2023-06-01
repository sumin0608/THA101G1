package tw.idv.ixercise;

import org.aspectj.lang.annotation.Before;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.junit4.SpringRunner;
import tw.idv.ixercise.event.entity.*;
import tw.idv.ixercise.event.repository.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class EventPhotoTests {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventDaoImpl eventDao;


    public void setUp() {
        // 刪除所有資料
//		eventRepository.deleteAll();
    }


    @Test
    void contextLoads() throws Exception {
        Event photo = eventDao.getPhoto(204);
        System.out.println(photo);
        eventRepository.save(new Event("來踢球", 333));
        eventRepository.save(new Event("打code", 444));
        eventRepository.save(new Event("好累", 555));
        eventRepository.save(new Event("想睡覺", 666));
        eventRepository.save(new Event("外面再打雷", 777));

//        System.out.println(eventRepository.findById(1));

        System.out.println("======================================================");
        System.out.println(eventRepository.findAll());

        // 測試findAll, 查詢所有資料
        Assert.assertEquals(5, eventRepository.findAll().size());

//        // 測試findByName, 查詢姓名為FFF的Customer
        Assert.assertEquals(444, eventRepository.findByEventName("打code").getPrice().longValue());


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


//		import com.example.springdemo.event.entity.*;
//		import com.example.springdemo.event.ropository.*;
//		import org.junit.*;
//		import org.junit.runner.*;
//		import org.springframework.beans.factory.annotation.*;
//		import org.springframework.boot.test.context.*;
//		import org.springframework.test.context.junit4.*;




