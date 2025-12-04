package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.StudetBean;
import com.example.demo.service.StudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService serv;

    @PostMapping("/add")
    public ResponseEntity<StudetBean> meth1(@RequestBody StudetBean sb) {

       return serv.addStudent(sb);
        
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<StudetBean> meth2(@PathVariable int id) {

        return serv.getStudent(id);
    }

    @GetMapping("/getAll")
    public List<StudetBean> meth3() {
        return serv.getAllStudents();
    }

    @PutMapping("/update")
    public int meth4(@RequestBody StudetBean sb) {
        return serv.updateStudents(sb);

    }

    @DeleteMapping("/delete/{id}")
    public int meth5(@PathVariable int id){
        return serv.deleteStudent(id);
    }

    
    
    
    

    
}
