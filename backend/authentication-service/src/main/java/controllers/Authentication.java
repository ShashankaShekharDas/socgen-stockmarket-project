package controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/abcd")
@RestController
public class Authentication {

    @GetMapping()
    public String login(){
        return "OK";
    }
}
