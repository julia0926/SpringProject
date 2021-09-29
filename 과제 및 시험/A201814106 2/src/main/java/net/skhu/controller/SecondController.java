package net.skhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Book;

@Controller
@RequestMapping("book")
public class SecondController {

    @GetMapping("edit")
    public String test2(Model model) {
        model.addAttribute("book", new Book());
        return "book/edit";
    }

    @PostMapping("edit")
    public String test2(Model model, Book book) {
        // TODO: 저장하는 코드를 구현해야 함.
        model.addAttribute("message", "저장되었습니다");
        return "book/edit";
    }
}

