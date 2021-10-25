package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.Course;
import net.skhu.dto.Department;
import net.skhu.dto.Professor;
import net.skhu.mapper.CourseMapper;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.mapper.ProfessorMapper;

@Controller
@RequestMapping("course")
public class CourseController {

    @Autowired CourseMapper courseMapper;
    @Autowired DepartmentMapper departmentMapper;
    @Autowired ProfessorMapper professorMapper;

    @RequestMapping("list")
    public String list(Model model) {
        List<Course> courses = courseMapper.findAll();
        model.addAttribute("courses", courses);
        return "course/list";
    }

    @GetMapping("create")
    public String create(Model model) {
        Course course = new Course();
        List<Department> departments = departmentMapper.findAll();
        List<Professor> professors = professorMapper.findAll();
        model.addAttribute("course", course);
        model.addAttribute("departments", departments);
        model.addAttribute("professors", professors);
        return "course/edit";
    }

    @PostMapping("create")
    public String create(Model model, Course course) {
    	courseMapper.insert(course);
        return "redirect:list";
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("id") int id) {
        Course course = courseMapper.findOne(id);
        List<Department> departments = departmentMapper.findAll();
        List<Professor> professors = professorMapper.findAll();
        model.addAttribute("course", course);
        model.addAttribute("departments", departments);
        model.addAttribute("professors", professors);
        return "course/edit";
    }

    @PostMapping("edit")
    public String edit(Model model, Course course) {
        courseMapper.update(course);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(Model model, @RequestParam("id") int id) {
        courseMapper.delete(id);
        return "redirect:list";
    }
}

