package net.skhu.controller;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("first")
public class FirstController {

    @RequestMapping("test1") //필수
    public String test1(Model model, @RequestParam("id") int id,
            @RequestParam("name") String name) {
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        return "first/test1";
    }

    @RequestMapping("test2")
    public String test2(Model model,
            @RequestParam(value="id", required=false, defaultValue="0") int id,
            @RequestParam(value="name", required=false, defaultValue="nobody") String name) {
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        return "first/test1";
    }

    @RequestMapping("test3") //파라미터 값이 없어도 된다.
    public String test3(Model model, int id, String name) {
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        return "first/test1";
    }

    @RequestMapping("test4") //파라미터 값이 없어도 된다.
    public String test4(Model model, @RequestParam("birthday") @DateTimeFormat(pattern="yyyy-MM-dd") Date birthday) {
        model.addAttribute("birthday", birthday);
        return "first/test1";
    }
}

