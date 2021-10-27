package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;

import net.skhu.dto.Course;

@Mapper
public interface CourseMapper {

	@ResultMap("CourseWithProfessor")
    List<Course> findAll();

}

