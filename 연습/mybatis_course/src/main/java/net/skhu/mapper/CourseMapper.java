package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import net.skhu.dto.Course;

@Mapper
public interface CourseMapper {
	
	@Select("SELECT * FROM Course WHERE id = #{id}")
	Course findOne(int id);
	
    @Select("SELECT c.*, d.departmentName, p.professorName FROM Course c	 \n"
    		+ "LEFT JOIN department d ON c.departmentId = d.id \n	"
    		+ "LEFT JOIN professor p ON c.professorId = p.id;")
    List<Course> findAll();

    @Insert("INSERT Course (courseName, departmentId, unit, professorId, startDate) 	"
    		+ "VALUES (#{courseName}, #{departmentId}, #{unit}, #{professorId}, #{startDate})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void insert(Course course);
	
    @Update("UPDATE Course SET                  " +
            "  courseName = #{courseName}, " +
            "  unit = #{unit},   " +
            "  departmentId = #{departmentId},                   " +
            "  professorId = #{professorId},                    " +
            "  startDate = #{startDate}              " +
            "WHERE id = #{id}                    ")
    void update(Course course);

    @Delete("DELETE FROM Course WHERE id = #{id}")
    void delete(int id);

}

