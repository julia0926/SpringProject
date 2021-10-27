package net.skhu.dto;

import java.util.List;

import lombok.Data;

@Data
public class Department {
  int id;
  String departmentName;
  List<Student> students;
}

