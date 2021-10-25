package net.skhu.dto;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Course {
	int id;
    String courseName;
    int departmentId;
    int professorId;
    int unit;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date startDate;
    String departmentName;
    String professorName;

}
