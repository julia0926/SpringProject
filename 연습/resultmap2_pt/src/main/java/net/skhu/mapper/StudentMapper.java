package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import net.skhu.dto.Student;

@Mapper
public interface StudentMapper {

    @ResultMap("StudentWithDepartment")
    @Select("SELECT s.*, d.departmentName " +
            " FROM student s JOIN department d ON s.departmentId = d.id              " +
            " ORDER BY s.studentNumber                                             ")
    List<Student> findAll();

}

