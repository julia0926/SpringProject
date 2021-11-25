package net.skhu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Book;
import net.skhu.model.BookRegister;
import net.skhu.service.CategoryService;
import net.skhu.service.BookService;

@Controller
@RequestMapping("book")
public class BookController {

    @Autowired BookService BookService;
    @Autowired CategoryService CategoryService;

    @GetMapping("list")
    public String list(Model model) {
        model.addAttribute("books", BookService.findAll());
        return "book/list";
    }

    @GetMapping("register")
    public String register(Model model) {
        model.addAttribute("bookRegister", new BookRegister());
        model.addAttribute("categorys", CategoryService.findAll());
        return "book/register";
    }

    @PostMapping("register")
    public String register(Model model,
            @Valid BookRegister BookRegister, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categorys", CategoryService.findAll());
            return "book/register";
        }
        Book Book = BookService.findByBookTitle(BookRegister.getTitle());
        if (Book != null) {
            bindingResult.rejectValue("title", null, "책 제목이 중복됩니다.");
            model.addAttribute("categorys", CategoryService.findAll());
            return "book/register";
        }
        BookService.insert(BookRegister);
        return "redirect:list";
    }
}

