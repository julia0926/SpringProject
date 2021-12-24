package net.skhu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Project;
import net.skhu.model.Pagination;

public interface ProjectRepository  extends JpaRepository<Project, Integer> {

    public default List<Project> findAll(Pagination pagination) {
        Page<Project> page = this.findAll(PageRequest.of(pagination.getPg() - 1, pagination.getSz(),
                                           Sort.Direction.ASC, "id"));
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }

    Page<Project> findByManagerId(int ManagerId, Pageable pageable);

    public default List<Project> findByManagerId(Pagination pagination) {
        if (pagination.getDi() == 0) return findAll(pagination);
        Page<Project> page = this.findByManagerId(pagination.getDi(),
                PageRequest.of(pagination.getPg() - 1, pagination.getSz(), Sort.Direction.ASC, "id"));
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }
}

