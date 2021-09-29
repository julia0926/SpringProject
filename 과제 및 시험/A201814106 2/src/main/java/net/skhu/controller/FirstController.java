package net.skhu.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Student;

@Controller
@RequestMapping("hello")
public class FirstController {

    @RequestMapping("index")
    public String test1(Model model, Student student, Date date) {
    	model.addAttribute("student", new Student("201814106","김지인"));
    	model.addAttribute("date", new Date());
        return "hello/index";
    }

}

