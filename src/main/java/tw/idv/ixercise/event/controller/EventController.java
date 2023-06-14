package tw.idv.ixercise.event.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;
import tw.idv.ixercise.event.entity.*;
import tw.idv.ixercise.event.repository.*;
import tw.idv.ixercise.event.service.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

@RestController
@RequestMapping("event")
public class EventController {

    private final EventRepository eventRepository;
    private final EventService eventService;
    private final EventDaoImpl eventDao;

    @Autowired
    public EventController(EventRepository eventRepository, EventService eventService, EventDaoImpl eventDao) {
        this.eventRepository = eventRepository;
        this.eventService = eventService;
        this.eventDao = eventDao;
    }

    @GetMapping("tttt")
    public String test() {
        return "Hi";
    }

    //crud - get post put delete
    //read create update delete

    //
    @PostMapping(value = "/create")
    public Integer createEvent(@RequestBody Event event) {
        System.out.println(event);
        return eventService.saveEvent(event).getEventId();
    }


    // Get : (eventId) ;  Read by id -   : return an Event
    @GetMapping("/get/{eventId}")
    public Event getEventById(@PathVariable Integer eventId) {
        Event eventById = eventService.findEventById(eventId);
        return eventById;
    }

    // Get : (nothing) ; Read All events : return a List<Event>
    @GetMapping("/get")
    public List<Event> getallevent() {
        List<Event> referenceById = eventRepository.findAll();
        System.out.println(referenceById);
        return referenceById;
    }

    //    @GetMapping("/get/input/{searchInput}")
    @GetMapping("/get/input")
//    public List<Event> getEventsByInput(@PathVariable String searchInput){
    public List<Event> getEventsByInput(@RequestParam String searchInput) {
        List<Event> eventsByInput = eventService.findEventsByInput(searchInput);
        System.out.println(eventsByInput);
        return eventsByInput;
    }

    @PutMapping(value = "/create/image/{eventId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public boolean uploadEvent(@RequestParam("photo") MultipartFile photo, @PathVariable Integer eventId) throws IOException {
        try {
            InputStream is = photo.getInputStream();
            byte[] bytes = is.readAllBytes();
            is.close();

            Event event = eventService.findEventById(eventId);
            if (event != null) {
                System.out.println("<====not null=====>>>>");
                event.setPhoto(bytes);
                Event save = eventRepository.save(event);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    //read image by id - get (eventId) : return byte[] of binary of the specific photo
    //difficulty - request header is too large
    @GetMapping(value = "/image/{eventId}")
    public byte[] getEventImage(@PathVariable Integer eventId) throws IOException {
        Event findEventById = eventRepository.findById(eventId).orElseGet(() -> null);
        byte[] photo = findEventById.getPhoto();
//      return eventDao.getPhoto(eventId);
        return photo;
    }

    @GetMapping("/get/image/{eventId}")
    public Event getImage(@PathVariable Integer eventId, HttpServletResponse res) throws IOException {
        Event referenceById = eventRepository.findById(eventId).orElse(null);
        System.out.println(referenceById);
        res.setContentType("image/*");
        ServletOutputStream out = res.getOutputStream();
        byte[] photo = referenceById.getPhoto();
        out.write(photo);
        out.close();
        return referenceById;
    }


//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>



}
