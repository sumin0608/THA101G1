package tw.idv.ixercise.event.controller.test;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("")
public class Practice {
    // 4 methods of -> retrieving parameters in http request
        //@RequestParam - url (?id=123&name=Daddy)
        //@RequestBody  -body
        //@RequestHeader-  e.g. @RequestHeader(name = Content-Type)   (methods similar to body)
        //@PathVariable - /event/create/123/Ryan
//                                     /{id}/{name}
    @GetMapping("test1")
    public String test1(@RequestParam(name = "testId") Integer id,
                        @RequestParam(required = false, defaultValue = "Siuuuuuu") String name){
                        //request parameter (Query string ? &)
        System.out.println("id: " + id);
        System.out.println("name: " + name);
        return "hello test1";
    }
    @PostMapping("test2")
    public String test2(@RequestBody EventTest eventTest){
        System.out.println("event id: " + eventTest.getName());
        System.out.println("event id: " + eventTest.getId());
        return "test2";
    }

    @PostMapping("test3")                                        //application/json
    public String test3(@RequestHeader(name = "Content-Type") String contentType, @RequestHeader String info){
        System.out.println("header info : " + info);
        System.out.println("header contentType : " + contentType);
        return "test3";
    }

    @PostMapping("test4/{id}/{name}")                                        //application/json
    public String test4(@PathVariable Integer id,
                        @PathVariable String name){
        System.out.println("Path id : " + id);
        System.out.println("Path name : " + name);
        return "test4";
    }


//    ====================== restful api design -> crud =====================
        //get
        //post
        //put
        //delete
    @PostMapping("create")
    public String create(@RequestBody @Valid EventTest eventTest){
        return "db insert method (save)";
    }

    @GetMapping("get/{eventId}")
    public String read(@PathVariable Integer eventId){
        System.out.println("eventId: " + eventId);
        return "db get event by id method";
    }


    @PutMapping("/update/{eventId}")
    public String update(@PathVariable Integer eventId, @PathVariable EventTest eventTest){
        return "db update by ID method";
    }

    @DeleteMapping("/delete/{eventId}")
    public String delete(@PathVariable Integer eventId){
        return "db delete by Id";
    }




}
