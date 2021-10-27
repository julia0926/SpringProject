package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.mapper.StudentMapper;


@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired StudentMapper studentMapper;

    @RequestMapping("list")
    public String list(Model model) {
        model.addAttribute("students", studentMapper.findAll());
        return "student/list";
    }

}

