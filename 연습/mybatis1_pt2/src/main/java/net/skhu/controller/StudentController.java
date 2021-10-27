package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.Department;
import net.skhu.dto.Student;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.mapper.StudentMapper;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired StudentMapper StudentMapper;
    @Autowired DepartmentMapper departmentMapper;


    @RequestMapping("list")
    public String list(Model model) {
        List<Student> Students = StudentMapper.findAll();
        model.addAttribute("students", Students);
        return "student/list";
    }

    @GetMapping("create")
    public String create(Model model) {
    	Student student = new Student();
        model.addAttribute("student", student);
        List<Department> departments = departmentMapper.findAll();
        model.addAttribute("departments", departments);
        return "student/edit";
    }

    @PostMapping("create")
    public String create(Model model, Student student) {
    	StudentMapper.insert(student);
        return "redirect:list";
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("id") int id) {
        Student student = StudentMapper.findOne(id);
        List<Department> departments = departmentMapper.findAll();
        model.addAttribute("student", student);
        model.addAttribute("departments", departments);
        return "student/edit";
    }

    @PostMapping("edit")
    public String edit(Model model, Student Student) {
    	StudentMapper.update(Student);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(Model model, @RequestParam("id") int id) {
    	StudentMapper.delete(id);
        return "redirect:list";
    }
}

