package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.skhu.mapper.CategoryMapper;
import net.skhu.model.Form1;

@Controller
public class Form1Controller {

    @Autowired
    CategoryMapper CategoryMapper;

    @ModelAttribute
    public void addSomething(Model model) {
        model.addAttribute("categorys", CategoryMapper.findAll());
    }

    @GetMapping("form1/edit1")
    public String edit1(Model model) {
        model.addAttribute("form1", new Form1());
        return "form1/edit1";
    }

    @PostMapping("form1/edit1")
    public String edit1(Model model, Form1 form1) {
        return "form1/edit1";
    }
}

