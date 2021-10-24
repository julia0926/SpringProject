package net.skhu.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Register {
	int id;
    int studentId;
    String StudentNumber;
    String studentName;
    int courseId;
    String courseName;
    int unit;
    int grade;
    Date createDate;


}
