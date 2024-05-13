package com.Kuba2412.school.controller;

import com.Kuba2412.school.model.Teacher;
import com.Kuba2412.school.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/add")
    public void addTeacher(@RequestBody Teacher teacher) {
        teacherService.addTeacher(teacher);
    }

    @GetMapping("/{id}")
    public Optional<Teacher> getTeacher(@PathVariable int id) {
        return teacherService.getTeacher(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTeacher(@PathVariable int id) {
        teacherService.deleteTeacher(id);
    }

    @PutMapping("/edit")
    public void editTeacher(@RequestBody Teacher teacher) {
        teacherService.editTeacher(teacher);
    }

    @PatchMapping("/{id}/changePhoneNumber")
    public void changePhoneNumber(@PathVariable int id, @RequestParam String newPhoneNumber) {
        teacherService.changePhoneNumber(id, newPhoneNumber);
    }

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/byGender")
    public List<Teacher> getTeachersByGender(@RequestParam String gender) {
        return teacherService.getTeachersByGender(gender);
    }
}
