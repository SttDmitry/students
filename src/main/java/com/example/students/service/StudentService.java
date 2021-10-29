package com.example.students.service;

import com.example.students.entity.Student;
import com.example.students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void saveStudent(Student student){
        studentRepository.saveAndFlush(student);
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public Student findStudentById (Long id) {
        return studentRepository.findById(id).orElse(new Student());
    }

    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }
}
