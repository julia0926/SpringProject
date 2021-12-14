package net.skhu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Engineer;
import net.skhu.model.Pagination;

public interface EngineerRepository  extends JpaRepository<Engineer, Integer> {

    public default List<Engineer> findAll(Pagination pagination) {
        Page<Engineer> page = this.findAll(PageRequest.of(pagination.getPg() - 1, pagination.getSz(),
                                           Sort.Direction.ASC, "id"));
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }

    Page<Engineer> findByRoleId(int departmentId, Pageable pageable);

    public default List<Engineer> findByRoleId(Pagination pagination) {
        if (pagination.getDi() == 0) return findAll(pagination);
        Page<Engineer> page = this.findByRoleId(pagination.getDi(),
                PageRequest.of(pagination.getPg() - 1, pagination.getSz(), Sort.Direction.ASC, "id"));
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }
}

