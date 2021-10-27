package net.skhu.dto;

import lombok.Data;

@Data
public class Course {
	int id;
	int year;
	String semester;
	String gubun;
	String code;
	int bunban;
	String title;
	int unit;
	int professorId;
	String sigan;

	Professor professor;
}

