package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.entity.Manager;
import net.skhu.entity.Project;
import net.skhu.repository.ManagerRepository;
import net.skhu.repository.ProjectRepository;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired ProjectRepository ProjectRepository;
    @Autowired ManagerRepository ManagerRepository;

    @RequestMapping("list")
    public String list(Model model) {
        List<Project> Projects = ProjectRepository.findAll();
        model.addAttribute("projects", Projects);
        return "project/list";
    }

    @GetMapping("create")
    public String create(Model model) {
        Project Project = new Project();
        List<Manager> Managers = ManagerRepository.findAll();
        model.addAttribute("project", Project);
        model.addAttribute("managers", Managers);
        return "project/create";
    }

    @PostMapping("create")
    public String create(Model model, Project Project) {
        ProjectRepository.save(Project);
        return "redirect:list";
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("id") int id) {
        Project Project = ProjectRepository.findById(id).get();
        List<Manager> Managers = ManagerRepository.findAll();
        model.addAttribute("project", Project);
        model.addAttribute("managers", Managers);
        return "project/create";
    }

    @PostMapping("edit")
    public String edit(Model model, Project Project) {
        ProjectRepository.save(Project);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(Model model, @RequestParam("id") int id) {
        ProjectRepository.deleteById(id);
        return "redirect:list";
    }
}

