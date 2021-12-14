package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.entity.Engineer;
import net.skhu.model.Pagination;
import net.skhu.repository.RoleRepository;
import net.skhu.repository.EngineerRepository;

@Controller
@RequestMapping("engineer")
public class EngineerController {

    @Autowired EngineerRepository EngineerRepository;
    @Autowired RoleRepository RoleRepository;

    @RequestMapping("list")
    public String list(Model model, Pagination pagination) {
        List<Engineer> Engineers = EngineerRepository.findByRoleId(pagination);
        model.addAttribute("engineers", Engineers);
        model.addAttribute("roles", RoleRepository.findAll());
        return "engineer/list";
    }

    @GetMapping("create")
    public String create(Model model, Pagination pagination) {
        model.addAttribute("engineer", new Engineer());
        model.addAttribute("roles", RoleRepository.findAll());
        return "engineer/edit";
    }

    @PostMapping("create")
    public String create(Model model, Engineer Engineer, Pagination pagination) {
        EngineerRepository.save(Engineer);
        pagination.setDi(0);
        int lastPage = (int)Math.ceil((double)EngineerRepository.count() / pagination.getSz());
        pagination.setPg(lastPage);
        return "redirect:list?" + pagination.getQueryString();
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("id") int id, Pagination pagination) {
        Engineer Engineer = EngineerRepository.findById(id).get();
        model.addAttribute("engineer", Engineer);
        model.addAttribute("roles", RoleRepository.findAll());
        return "engineer/edit";
    }

    @PostMapping(value="edit", params="cmd=save")
    public String edit(Model model, Engineer Engineer, Pagination pagination) {
        EngineerRepository.save(Engineer);
        return "redirect:list?" + pagination.getQueryString();
    }

    @PostMapping(value="edit", params="cmd=delete")
    public String delete(Model model, @RequestParam("id") int id, Pagination pagination) {
        EngineerRepository.deleteById(id);
        return "redirect:list?" + pagination.getQueryString();
    }
}

