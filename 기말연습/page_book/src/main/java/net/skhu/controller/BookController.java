package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.entity.Book;
import net.skhu.model.Pagination;
import net.skhu.repository.CategoryRepository;
import net.skhu.repository.BookRepository;

@Controller
@RequestMapping("book")
public class BookController {

    @Autowired BookRepository BookRepository;
    @Autowired CategoryRepository CategoryRepository;

    @RequestMapping("list")
    public String list(Model model, Pagination pagination) {
        List<Book> Books = BookRepository.findByCategoryId(pagination);
        model.addAttribute("books", Books);
        model.addAttribute("categorys", CategoryRepository.findAll());
        return "book/list";
    }

    @GetMapping("create")
    public String create(Model model, Pagination pagination) {
        model.addAttribute("book", new Book());
        model.addAttribute("categorys", CategoryRepository.findAll());
        return "book/edit";
    }

    @PostMapping("create")
    public String create(Model model, Book Book, Pagination pagination) {
        BookRepository.save(Book);
        pagination.setDi(0);
        int lastPage = (int)Math.ceil((double)BookRepository.count() / pagination.getSz()); 
//마지막 페이지수, 총 페이지 수
        pagination.setPg(lastPage);
        return "redirect:list?" + pagination.getQueryString();
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("id") int id, Pagination pagination) {
        Book Book = BookRepository.findById(id).get();
        model.addAttribute("book", Book);
        model.addAttribute("categorys", CategoryRepository.findAll());
        return "book/edit";
    }

    @PostMapping(value="edit", params="cmd=save")
    public String edit(Model model, Book Book, Pagination pagination) {
        BookRepository.save(Book);
        return "redirect:list?" + pagination.getQueryString();
    }

    @PostMapping(value="edit", params="cmd=delete")
    public String delete(Model model, @RequestParam("id") int id, Pagination pagination) {
        BookRepository.deleteById(id);
        return "redirect:list?" + pagination.getQueryString();
    }
}
