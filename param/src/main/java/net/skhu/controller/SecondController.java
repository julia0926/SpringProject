package net.skhu.controller;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.Person;

@Controller
@RequestMapping("second")
public class SecondController {

    @RequestMapping("test1")
    public String test1(Model model, @RequestParam("name") String name,
                                     @RequestParam("weight") double weight,
                                     @RequestParam("birthday") String birthday) {
        model.addAttribute("name", name);
        model.addAttribute("weight", weight);
        model.addAttribute("birthday", birthday);
        return "second/test2";
    }

    @RequestMapping("test2")
    public String test2(Model model,
            @RequestParam("name") String name,
            @RequestParam("weight") double weight,
            @RequestParam("birthday") @DateTimeFormat(pattern="yyyy-MM-dd") Date birthday) {
        model.addAttribute("name", name);
        model.addAttribute("weight", weight);
        model.addAttribute("birthday", birthday);
        return "second/test2";
    }

    @RequestMapping("test3")
    public String test3(Model model, Person person) { //객체에 채워서 받는다 .
        model.addAttribute("name", person.getName());
        model.addAttribute("weight", person.getWeight());
        model.addAttribute("birthday", person.getBirthday());
        return "second/test3";
    }

    @RequestMapping("test4")
    public String test4(Model model, Person person) {
        model.addAttribute("person", person); //객체를 전달하면 자동으로 생성됨, 클래스이름으로 전달됨
        return "second/test4";
    }

    //자동으로 모델에 저장되어 뷰에 저장
    @RequestMapping("test5")
    public String test5(Model model, Person p) {
        return "second/test4";
    }
}

