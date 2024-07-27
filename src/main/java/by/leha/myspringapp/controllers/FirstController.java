package by.leha.myspringapp.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@org.springframework.stereotype.Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name",required = false) String name, @RequestParam(value = "surname",required = false) String surname) {

        System.out.println(name + " " + surname + " Helloooo" );

        return "first/hello";
    }


    @GetMapping("/goodbye")
    public String goodbyePage(){

        return "first/goodbye";
    }



}
