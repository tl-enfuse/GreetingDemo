package io.enfuse.Travis.demo.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greeting/{id}")
    public Greeting getGreeting(@PathVariable("id") Long id){
        return greetingService.getGreetingById(id);
    }

    //TODO how do we take in the Greeting data.
    @RequestMapping(
            method = {POST, PUT},
            path = "/greeting"
    )
    public Greeting createOrUpdateGreeting(@RequestBody Greeting greeting){
        return greetingService.createOrUpdateGreeting(greeting);
    }

    @DeleteMapping
    public void deleteGreeting(@RequestBody Greeting greeting){
        greetingService.deleteGreeting(greeting);
    }

}
