package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.Lecture;
import net.skhu.dto.Professor;
import net.skhu.mapper.LectureMapper;
import net.skhu.mapper.ProfessorMapper;

@Controller
@RequestMapping("lecture")
public class LectureController {

    @Autowired LectureMapper lectureMapper;
    @Autowired ProfessorMapper professorMapper;


    @RequestMapping("list")
    public String list(Model model) {
        List<Lecture> lectures = lectureMapper.findAll();
        model.addAttribute("lectures", lectures);
        return "lecture/list";
    }

    @GetMapping("create")
    public String create(Model model) {
    	Lecture lecture = new Lecture();
        model.addAttribute("lecture", lecture);
        List<Professor> professors = professorMapper.findAll();
        model.addAttribute("professors", professors);
        return "lecture/edit";
    }

    @PostMapping("create")
    public String create(Model model, Lecture lecture) {
    	lectureMapper.insert(lecture);
        return "redirect:list";
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("id") int id) {
        Lecture Lecture = lectureMapper.findOne(id);
        List<Professor> professors = professorMapper.findAll();
        model.addAttribute("lecture", Lecture);
        model.addAttribute("professors", professors);
        return "lecture/edit";
    }

    @PostMapping("edit")
    public String edit(Model model, Lecture lecture) {
    	lectureMapper.update(lecture);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(Model model, @RequestParam("id") int id) {
    	lectureMapper.delete(id);
        return "redirect:list";
    }
}

