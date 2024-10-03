package com.luv2code.springboot.thymeleaf.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.http.HttpRequest;


@Controller
public class HelloWorldController {
    //Step1
    //need a controller method to show HTML form
    //@RequestMapping("/showForm")
    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    //Step3
    //need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    //need a controller method to read form data and
    //add data to a model

    //example code for HttpServletRequest
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){
        //read request parameter from HTML form
        String theName=request.getParameter("studentName");

        //convert data to all caps
        theName=theName.toUpperCase();

        //create the msg
        String result="Yo! "+theName;

        //add msg to the model
        model.addAttribute("message",result);

        return "helloworld";
    }

    //This one using  @RequestParam
    //@RequestMapping("/processFormVersionThree")
    @PostMapping("/processFormVersionThree")
    public String ProcessFormVersionThree(@RequestParam("studentName") String theName , Model model){

        //here read request parameter from HTML form is removed bcoz we use @RequestParam

        //convert data to all caps
        theName=theName.toUpperCase();

        //create the msg
        String result="Heyyy dude whatzz up! "+theName;

        //add msg to the model
        model.addAttribute("message",result);

        return "helloworld";
    }

}
