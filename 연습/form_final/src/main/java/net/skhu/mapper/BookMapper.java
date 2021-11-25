package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import net.skhu.dto.Book;

@Mapper
public interface BookMapper {

    @Select("SELECT * FROM Book")
    List<Book> findAll();

    @Select("SELECT * FROM Book WHERE title = #{title}")
    Book findByBookTitle(String title);

    @Insert("INSERT Book (title, author, price, publisher, categoryId)                " +
            "VALUES (#{title}, #{author}, #{price}, #{publisher}, #{categoryId}")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void insert(Book Book);
}

