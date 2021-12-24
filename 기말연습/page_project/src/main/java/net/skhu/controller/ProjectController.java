package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.entity.Project;
import net.skhu.model.Pagination;
import net.skhu.repository.ManagerRepository;
import net.skhu.repository.ProjectRepository;

@Controller
@RequestMapping("project")
public class ProjectController {

    @Autowired ProjectRepository ProjectRepository;
    @Autowired ManagerRepository managerRepository;

    @RequestMapping("list")
    public String list(Model model, Pagination pagination) {
        List<Project> Projects = ProjectRepository.findByManagerId(pagination);
        model.addAttribute("projects", Projects);
        model.addAttribute("managers", managerRepository.findAll());
        return "project/list";
    }

    @GetMapping("create")
    public String create(Model model, Pagination pagination) {
        model.addAttribute("project", new Project());
        model.addAttribute("managers", managerRepository.findAll());
        return "project/edit";
    }

    @PostMapping("create")
    public String create(Model model, Project Project, Pagination pagination) {
        ProjectRepository.save(Project);
        pagination.setDi(0);
        int lastPage = (int)Math.ceil((double)ProjectRepository.count() / pagination.getSz());
        pagination.setPg(lastPage);
        return "redirect:list?" + pagination.getQueryString();
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("id") int id, Pagination pagination) {
        Project Project = ProjectRepository.findById(id).get();
        model.addAttribute("project", Project);
        model.addAttribute("managers", managerRepository.findAll());
        return "project/edit";
    }

    @PostMapping(value="edit", params="cmd=save")
    public String edit(Model model, Project Project, Pagination pagination) {
        ProjectRepository.save(Project);
        return "redirect:list?" + pagination.getQueryString();
    }

    @PostMapping(value="edit", params="cmd=delete")
    public String delete(Model model, @RequestParam("id") int id, Pagination pagination) {
        ProjectRepository.deleteById(id);
        return "redirect:list?" + pagination.getQueryString();
    }
}

