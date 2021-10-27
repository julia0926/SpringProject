package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.mapper.DepartmentMapper;

@Controller
public class DepartmentController {

    @Autowired DepartmentMapper departmentMapper;

    @RequestMapping("department/list")
    public String list(Model model) {
        model.addAttribute("departments", departmentMapper.findAll());
        return "department/list";
    }

}

