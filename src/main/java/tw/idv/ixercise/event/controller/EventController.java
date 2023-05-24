package tw.idv.ixercise.event.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("event")
public class EventController {

    @GetMapping("tttt")
    public String test(){

        return "Hi";
    }
}
