package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Department;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.mapper.StudentMapper;

@Controller
public class StudentController {

    @Autowired StudentMapper studentMapper;
    @Autowired DepartmentMapper departmentMapper;

    @RequestMapping("department/list")
    public String list(Model model) {
        List<Department> departments = departmentMapper.findAll();
        for (Department department : departments)
        	department.setStudents(studentMapper.findByDepartmentId(department.getId()));
        model.addAttribute("departments", departments);
        return "department/list";
    }

}

