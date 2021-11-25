package net.skhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.dto.Book;
import net.skhu.mapper.BookMapper;
import net.skhu.model.BookRegister;

@Service
public class BookService {

    @Autowired
    public BookMapper BookMapper;

    public List<Book> findAll() {
        return BookMapper.findAll();
    }

    public Book findByBookTitle(String title) {
        return BookMapper.findByBookTitle(title);
    }

    public Book createDto(BookRegister BookRegister) {
        Book Book = new Book();
        Book.setTitle(BookRegister.getTitle());
        Book.setAuthor(BookRegister.getAuthor());
        Book.setPrice(BookRegister.getPrice());
        Book.setPublisher(BookRegister.getPublisher());
        if (BookRegister.getCategoryId() != 0)
            Book.setCategoryId(BookRegister.getCategoryId());
        return Book;
    }

    public void insert(BookRegister BookRegister) {
        Book Book = createDto(BookRegister);
        BookMapper.insert(Book);
    }

}

