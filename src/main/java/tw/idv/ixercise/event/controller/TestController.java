package tw.idv.ixercise.event.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;
//import org.springframework.web.multipart.support.*;
import tw.idv.ixercise.event.entity.*;
import tw.idv.ixercise.event.ropository.*;
import tw.idv.ixercise.event.service.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

@RestController
@RequestMapping("/events")
public class TestController {
    private EventService eventService;

    private EventRepository eventRepository;

    @Autowired
    public TestController(EventService eventService, EventRepository eventRepository) {
        this.eventService = eventService;
        System.out.println("  <<this.eventService = eventService;");
        this.eventRepository = eventRepository;
    }

    @GetMapping("tttt")
    public String test(){

        return "Hi";
    }

    @PostMapping(value = "/create")
    public Integer createEvent(@RequestBody Event event) {
        System.out.println(event);
        System.out.println("createEvent(Event)");
        System.out.println("createEvssssssent(Event)");
        System.out.println("createEvssssssent(Event)");

        return eventService.saveEvent(event).getEventId();
    }

//    @PostMapping(value = "/create/image/{eventId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    @PutMapping( "/create/image/{eventId}")
    public String uploadEvent(@RequestParam("photo") MultipartFile photo, @PathVariable Integer eventId) throws IOException {
        System.out.println(photo);
        try {
//            byte[] bytes1 = photo.getInputStream().readAllBytes();
            photo.getInputStream();
            byte[] bytes = photo.getBytes();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);

            Event event = eventService.findEventById(eventId);
            if (event != null) {
                System.out.println("<====not null=====>>>>");
//                event.setPhoto(bytes1);
                Event save = eventRepository.save(event);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Hi``";
    }

//    @PostMapping("/upload/image")
//    public ResponseEntity<> uplaodImage(@RequestParam("image") MultipartFile file)
//            throws IOException {
//
//
//    }
    @PutMapping (value = "/create/images/{eventId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Event uploadEvent1(HttpServletRequest req, HttpServletResponse res, @PathVariable Integer eventId) {
        byte[] photo = null;
        Part photoPart1 = null;
        Event save = null;
        // Retrieve the photo file from the request
        try {
//            MultipartHttpServletRequest req1 = (MultipartHttpServletRequest) req;
//            String photo1 = req1.getParameter("photo");
//            System.out.println(photo1);
            Event event =eventService.findEventById(eventId);
//            Object request = null;
//            StandardMultipartHttpServletRequest request1 = (StandardMultipartHttpServletRequest) request;

            photoPart1 = req.getPart("photo");
            InputStream photoStream = photoPart1.getInputStream();
            photo = photoStream.readAllBytes();


            if(event != null){
                System.out.println("<====not null=====>>>>");
                event.setPhoto(photo);
                 save = eventRepository.save(event);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

        System.out.println(req);
        System.out.println(res);
        System.out.println("createEvent(Event)");
        System.out.println("createEvssssssent(Event)");
        System.out.println("createEvssssssent(Event)");
//        eventService.saveEvent(event);
        return save;
    }


    @GetMapping("/find/{eventId}")
    public Event findEvent(@PathVariable Integer eventId) {
        System.out.println("getEventById(@PathVariable Integer id)");
        Event event =eventService.findEventById(eventId);
        System.out.println(event);
        return event;
    }

    // 其他操作方法省略
}