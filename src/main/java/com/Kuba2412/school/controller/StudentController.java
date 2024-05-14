package com.Kuba2412.school.controller;

import com.Kuba2412.school.model.Student;
import com.Kuba2412.school.service.StudentService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {


    private final StudentService studentService;

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public Student editStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        updatedStudent.setId(id);
        return studentService.editStudent(updatedStudent);
    }

    @PatchMapping("/{id}/phoneNumber")
    public void changePhoneNumber(@PathVariable Long id, @RequestBody String newPhoneNumber) {
        studentService.changePhoneNumber(id, newPhoneNumber);
    }

    @GetMapping
    public List<Student> getStudents(@RequestParam(required = false) String lastName) {
        if (lastName != null && !lastName.isEmpty()) {
            return studentService.getAllStudents().stream()
                    .filter(student -> student.getLastName().equalsIgnoreCase(lastName))
                    .toList();
        } else {
            return studentService.getAllStudents();
        }
    }
}
