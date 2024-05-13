package com.Kuba2412.school.controller;

import com.Kuba2412.school.model.Student;
import com.Kuba2412.school.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudent(@PathVariable int id) {
        return studentService.getStudent(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/edit")
    public void editStudent(@RequestBody Student student) {
        studentService.editStudent(student);
    }

    @PatchMapping("/{id}/changePhoneNumber")
    public void changePhoneNumber(@PathVariable int id, @RequestParam String newPhoneNumber) {
        studentService.changePhoneNumber(id, newPhoneNumber);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/search")
    public List<Student> getStudentsByLastName(@RequestParam String lastName) {
        return studentService.getStudentsByLastName(lastName);
    }
}
