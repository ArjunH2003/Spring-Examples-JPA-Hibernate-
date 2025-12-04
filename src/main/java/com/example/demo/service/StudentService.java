package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.bean.StudentBean;
import com.example.demo.dao.StudentDao;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    @Transactional
    public String addStudent(StudentBean sb) {
        return studentDao.addStudent(sb);
    }

   @Transactional
    public String updateStudent(StudentBean sb) {
        return studentDao.updateStudent(sb);
    }

    @Transactional
    public String deleteStudent(int id) {
        return studentDao.deleteStudent(id);
     
    }
    public StudentBean findStudentById(int id) {
        return studentDao.findStudentById(id);
    }

    public List<StudentBean> findAllStudents() {
        return studentDao.findAllStudents();
    }

}
