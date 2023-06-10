package tw.idv.ixercise.event.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;
//import org.springframework.web.multipart.support.*;
import tw.idv.ixercise.event.entity.*;
import tw.idv.ixercise.event.repository.*;
import tw.idv.ixercise.event.service.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

//@RestController
//@RequestMapping("/events")
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
//        return eventRepository.save(event).getEventId();

        System.out.println(event);
        System.out.println("createEvent(Event)");
        System.out.println("createEvssssssent(Event)");
        System.out.println("createEvssssssent(Event)");
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
//        Time startTime = event.getStartTime();
//        System.out.println(startTime);
//        String format = simpleDateFormat.format(startTime);

//        event.setStartTime(Time.valueOf(format));

        // Format startTime to "HH:mm:ss" format
//        LocalTime localTime = LocalTime.parse((CharSequence) event.getStartTime());
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//        String formattedStartTime = localTime.format(formatter);
//        event.setStartTime(formattedStartTime);

        return eventService.saveEvent(event).getEventId();
    }

    //read image by id - get (eventId) : return byte[] of binary of the specific photo
    //difficulty - request header is too large
    @GetMapping(value = "/image/{eventId}")
    public ResponseEntity<byte[]> getEventImage(@PathVariable Integer eventId) throws IOException {
        Event findEventById = eventRepository.findById(eventId).orElse(null);
//        System.out.println(findEventById);
        byte[] photo = findEventById.getPhoto();

        if (photo != null) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            outputStream.write(photo);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG); // Replace with the correct media type
            headers.setContentLength(outputStream.size());
            return ResponseEntity.ok().headers(headers).body(outputStream.toByteArray());
//            return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();

//        return photo;
    }

    //    @PostMapping(value = "/create/image/{eventId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    @PutMapping(value = "/create/image/{eventId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadEvent(@RequestParam("photo") MultipartFile photo, @PathVariable Integer eventId) throws IOException {
        System.out.println(photo);
        try {
            InputStream is = photo.getInputStream();
            byte[] bytes = is.readAllBytes();
            is.close();

            Event event = eventService.findEventById(eventId);
            if (event != null) {
                System.out.println("<====not null=====>>>>");
                event.setPhoto(bytes);
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
    @PutMapping(value = "/create/images/{eventId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadEvent1(HttpServletRequest req, HttpServletResponse res, @PathVariable Integer eventId) {
        byte[] photo = null;
        Part photoPart1 = null;
        Event save = null;
        // Retrieve the photo file from the request
        try {
//            MultipartHttpServletRequest req1 = (MultipartHttpServletRequest) req;
//            String photo1 = req1.getParameter("photo");
//            System.out.println(photo1);
            Event event = eventService.findEventById(eventId);
//            Object request = null;
//            StandardMultipartHttpServletRequest request1 = (StandardMultipartHttpServletRequest) request;

            photoPart1 = req.getPart("photo");
            InputStream photoStream = photoPart1.getInputStream();
            photo = photoStream.readAllBytes();
            photoStream.close();

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
//        return save;
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
