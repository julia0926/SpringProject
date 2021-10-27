package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.mapper.CourseMapper;

@Controller
public class CourseController {

    @Autowired CourseMapper courseMapper;

    @RequestMapping("course/list")
    public String list(Model model) {
        model.addAttribute("courses", courseMapper.findAll());
        return "course/list";
    }

}

