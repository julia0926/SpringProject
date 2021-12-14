package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.entity.Course;
import net.skhu.model.Pagination;
import net.skhu.repository.ProfessorRepository;
import net.skhu.repository.CourseRepository;

@Controller
@RequestMapping("course")
public class CourseController {

    @Autowired CourseRepository courseRepository;
    @Autowired ProfessorRepository professorRepository;

    @RequestMapping("list")
    public String list(Model model, Pagination pagination) {
        List<Course> courses = courseRepository.findByprofessorId(pagination);
        model.addAttribute("courses", courses);
        model.addAttribute("professors", professorRepository.findAll());
        return "course/list";
    }

    @GetMapping("create")
    public String create(Model model, Pagination pagination) {
        model.addAttribute("course", new Course());
        model.addAttribute("professors", professorRepository.findAll());
        return "course/edit";
    }

    @PostMapping("create")
    public String create(Model model, Course course, Pagination pagination) {
        courseRepository.save(course);
        pagination.setDi(0);
        int lastPage = (int)Math.ceil((double)courseRepository.count() / pagination.getSz());
        pagination.setPg(lastPage);
        return "redirect:list?" + pagination.getQueryString();
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("id") int id, Pagination pagination) {
    	Course course = courseRepository.findById(id).get();
        model.addAttribute("course", course);
        model.addAttribute("professors", professorRepository.findAll());
        return "course/edit";
    }

    @PostMapping(value="edit", params="cmd=save")
    public String edit(Model model, Course course, Pagination pagination) {
        courseRepository.save(course);
        return "redirect:list?" + pagination.getQueryString();
    }

    @PostMapping(value="edit", params="cmd=delete")
    public String delete(Model model, @RequestParam("id") int id, Pagination pagination) {
        courseRepository.deleteById(id);
        return "redirect:list?" + pagination.getQueryString();
    }
}

