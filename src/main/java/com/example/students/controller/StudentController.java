package com.example.students.controller;

import com.example.students.entity.Student;
import com.example.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/showAllStudents")
    public String showAllStudents(Model uiModel) {
        uiModel.addAttribute("studentsList", studentService.findAllStudents());
        return "students";
    }

    @RequestMapping(path = "/showStudentById", method = RequestMethod.GET)
    @ResponseBody
    public Student showStudentById(Model uiModel, @RequestParam Long id) {
        Student student = studentService.findStudentById(id);
        return student;
    }

    @RequestMapping("/showForm")
    public String showSimpleForm(Model uiModel) {
        Student student = new Student();
        uiModel.addAttribute("student", student);
        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student) {
        System.out.println(student);
        studentService.saveStudent(student);
        return "student-form-result";
    }
}
