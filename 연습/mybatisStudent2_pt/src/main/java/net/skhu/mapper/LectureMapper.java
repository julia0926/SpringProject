package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.skhu.dto.Lecture;

@Mapper
public interface LectureMapper {

    @Select("SELECT * FROM lecture WHERE id = #{id}")
    Lecture findOne(int id);


    @Select("SELECT l.*, p.name professorName     " +
            "FROM lecture l LEFT JOIN professor p " +
            " ON l.professorId = p.id          ")
    List<Lecture> findAll();

    @Insert("INSERT Lecture (title, professorId, year, semaster, room)     " +
            "VALUES (#{title}, #{professorId}, #{year}, #{semaster}, #{room}) ")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void insert(Lecture lecture);

    @Update("UPDATE Lecture SET                  " +
            "  title = #{title}, " +
            "  professorId = #{professorId},                   " +
            "  year = #{year},   " +
            "  semaster = #{semaster},                    " +
            "  room = #{room}                    " +
            "WHERE id = #{id}                    ")
    void update(Lecture lecture);

    @Delete("DELETE FROM lecture WHERE id = #{id}")
    void delete(int id);
}

