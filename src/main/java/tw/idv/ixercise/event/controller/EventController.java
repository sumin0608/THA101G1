package tw.idv.ixercise.event.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.core.io.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
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

    @Autowired
    public EventController(EventRepository eventRepository, EventService eventService) {
        this.eventRepository = eventRepository;
        this.eventService = eventService;
    }

    @GetMapping("tttt")
    public String test() {
        return "Hi";
    }

    //crud - get post put delete
    //read create update delete
    @GetMapping("/get/{eventId}")
    public Event getevent(@PathVariable Integer eventId) {
        Event referenceById = eventRepository.findById(eventId).orElse(null);
        System.out.println(referenceById);
//        byte[] photo = referenceById.getPhoto();
        return referenceById;
    }

    @GetMapping("/get")
    public List<Event> getallevent() {
        List<Event> referenceById = eventRepository.findAll();
        System.out.println(referenceById);
        return referenceById;
    }

    @GetMapping(value = "/image/{eventId}")
    public ResponseEntity<byte[]> getEventImage(@PathVariable Integer eventId) throws IOException {
        Event findEventById = eventRepository.findById(eventId).orElse(null);
        System.out.println(findEventById);
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

//      return photo;
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
//    @GetMapping(value = "/blob/{id}")
//    public ResponseEntity<byte[]> getBlobData(@PathVariable Long id) throws IOException {
//        byte[] blobData = eventService.readBlobData(id);
//
//        if (blobData != null) {
//            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//            outputStream.write(blobData);
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.IMAGE_JPEG); // Replace with the correct media type
//            headers.setContentLength(outputStream.size());
//
//            return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);
//        }
//
//        return ResponseEntity.notFound().build();
//    }


//    @GetMapping(value = "/blob/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
//    public ResponseEntity<byte[]> getBlobData(@PathVariable Integer id) {
//        // 通过调用Service类中的方法获取Blob数据
//        byte[] blobData = eventService.readBlobData(id);
//
//        if (blobData != null) {
//            // 返回包含Blob数据的ResponseEntity
//            return ResponseEntity.ok().body(blobData);
//        }
//
//        // 如果未找到Blob数据，则返回404 Not Found
//        return ResponseEntity.notFound().build();
//    }
//}


}
