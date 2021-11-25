package net.skhu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.model.UserRegister;
import net.skhu.service.DepartmentService;
import net.skhu.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired UserService userService;
    @Autowired DepartmentService departmentService;

    @GetMapping("list")
    public String list(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user/list";
    }

    @GetMapping("register")
    public String register(Model model) {
        model.addAttribute("userRegister", new UserRegister());
        model.addAttribute("departments", departmentService.findAll());
        return "user/register";
    }

    @PostMapping("register")
    public String register(Model model,
            @Valid UserRegister userRegister, BindingResult bindingResult)
    {
        if (userService.hasErrors(userRegister, bindingResult)) {
            model.addAttribute("departments", departmentService.findAll());
            return "user/register";
        }
        userService.insert(userRegister);
        return "redirect:list";
    }
}

