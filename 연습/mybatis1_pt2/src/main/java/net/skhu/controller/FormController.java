package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.Student;
import net.skhu.mapper.DepartmentMapper;

@Controller
@RequestMapping("form")
public class FormController {
	
    @Autowired DepartmentMapper departmentMapper;

	@GetMapping("edit")
    public String edit(Model model) {
        model.addAttribute("student", new Student()); //빈 객체 보낼 
        model.addAttribute("departments", departmentMapper.findAll());
        return "form/edit";
    }

    @PostMapping("edit")
    public String edit(Model model, Student student) {
    	model.addAttribute("message", "저장했습니다");
        model.addAttribute("departments", departmentMapper.findAll());
        return "form/edit";
    }
}
