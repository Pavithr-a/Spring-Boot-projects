package com.luv2code.springboot.thymeleaf.controller;

import com.luv2code.springboot.thymeleaf.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//step2
@Controller
public class StudentController {

    @Value("${countries}")  //app.properites file
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){
        //create a student obj
        Student theStudent=new Student();

        //add student obj to model
        theModel.addAttribute("student",theStudent);

        // add list of countries to the model
        theModel.addAttribute("countries",countries);

        theModel.addAttribute("languages",languages);

        theModel.addAttribute("systems",systems);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){
        //log the input data
        System.out.println("theStudent: "+theStudent.getFirstName()+" "+theStudent.getLastName());


        return "student-confirmation";
    }
}
