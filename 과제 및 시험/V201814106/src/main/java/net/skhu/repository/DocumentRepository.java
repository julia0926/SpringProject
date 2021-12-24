package net.skhu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Document;
import net.skhu.model.Pagination;

public interface DocumentRepository  extends JpaRepository<Document, Integer> {

    public default List<Document> findAll(Pagination pagination) {
        Page<Document> page = this.findAll(PageRequest.of(pagination.getPg() - 1, pagination.getSz(),
                                           Sort.Direction.ASC, "id"));
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }

    Page<Document> findByFolderId(int departmentId, Pageable pageable);

    public default List<Document> findByFolderId(Pagination pagination) {
        if (pagination.getFi() == 0) return findAll(pagination);
        Page<Document> page = this.findByFolderId(pagination.getFi(),
                PageRequest.of(pagination.getPg() - 1, pagination.getSz(), Sort.Direction.ASC, "id"));
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }
}

