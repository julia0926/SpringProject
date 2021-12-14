package net.skhu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Course;
import net.skhu.model.Pagination;

public interface CourseRepository  extends JpaRepository<Course, Integer> {

    public default List<Course> findAll(Pagination pagination) {
        Page<Course> page = this.findAll(PageRequest.of(pagination.getPg() - 1, pagination.getSz(),
                                           Sort.Direction.ASC, "id"));
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }

    Page<Course> findByProfessorId(int professorId, Pageable pageable);

    public default List<Course> findByprofessorId(Pagination pagination) {
        if (pagination.getDi() == 0) return findAll(pagination);
        Page<Course> page = this.findByProfessorId(pagination.getDi(),
                PageRequest.of(pagination.getPg() - 1, pagination.getSz(), Sort.Direction.ASC, "id"));
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }
}

