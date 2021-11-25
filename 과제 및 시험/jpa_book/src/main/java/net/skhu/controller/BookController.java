package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.entity.Category;
import net.skhu.entity.Book;
import net.skhu.repository.CategoryRepository;
import net.skhu.repository.BookRepository;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired BookRepository BookRepository;
    @Autowired CategoryRepository CategoryRepository;

    @RequestMapping("list")
    public String list(Model model) {
        List<Book> Books = BookRepository.findAll();
        model.addAttribute("books", Books);
        return "book/list";
    }

    @GetMapping("create")
    public String create(Model model) {
        Book Book = new Book();
        List<Category> Categorys = CategoryRepository.findAll();
        model.addAttribute("book", Book);
        model.addAttribute("categorys", Categorys);
        return "book/edit";
    }

    @PostMapping("create")
    public String create(Model model, Book Book) {
        BookRepository.save(Book);
        return "redirect:list";
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("id") int id) {
        Book Book = BookRepository.findById(id).get();
        List<Category> Categorys = CategoryRepository.findAll();
        model.addAttribute("book", Book);
        model.addAttribute("categorys", Categorys);
        return "book/edit";
    }

    @PostMapping("edit")
    public String edit(Model model, Book Book) {
        BookRepository.save(Book);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(Model model, @RequestParam("id") int id) {
        BookRepository.deleteById(id);
        return "redirect:list";
    }
}

