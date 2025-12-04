package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.StudentBean;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String add(@RequestBody StudentBean sb) {
        return studentService.addStudent(sb);
    }

    @PutMapping("/update")
    public String update(@RequestBody StudentBean sb) {
        return studentService.updateStudent(sb);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        return studentService.deleteStudent(id);
    }
    
    @GetMapping("/get/{id}")
    public StudentBean getStudent(@PathVariable int id) {
        return studentService.findStudentById(id);
    }

    @GetMapping("/getAll")
    public List<StudentBean> getAllStudents() {
        return studentService.findAllStudents();
    }

}
