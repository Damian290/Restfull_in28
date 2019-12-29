package com.example.rest.webServices.Restfull.HelloWorld;

import com.example.rest.webServices.Restfull.HelloWorld.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

/**
 * Created by Acer on 2019-12-13.
 */
@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/hello-world")
    public String helloWorld(){

        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World2");
    }

    @GetMapping(path = "/hello-world/path-params/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){

        return new HelloWorldBean(String.format("Hello World, %s ", name));
    }

    @GetMapping(path = "/hello-world/internationalized")
    public String helloWorldInternationalized(){

        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }

}
