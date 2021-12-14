package net.skhu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Book;
import net.skhu.model.Pagination;

public interface BookRepository  extends JpaRepository<Book, Integer> {

    public default List<Book> findAll(Pagination pagination) {
        Page<Book> page = this.findAll(PageRequest.of(pagination.getPg() - 1, pagination.getSz(),
                                           Sort.Direction.ASC, "id"));
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }
    
    Page<Book> findByCategoryId(int CategoryId, Pageable pageable);
    
    public default List<Book> findByCategoryId(Pagination pagination) {
    	
        if (pagination.getDi() == 0) return findAll(pagination); //조회할 카테고리  id가 0이라면 
        Page<Book> page = this.findByCategoryId(pagination.getDi(),
                PageRequest.of(pagination.getPg() - 1, pagination.getSz(), Sort.Direction.ASC, "id"));
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }

}

