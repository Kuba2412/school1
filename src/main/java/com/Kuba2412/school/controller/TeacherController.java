package com.Kuba2412.school.controller;

import com.Kuba2412.school.model.Teacher;
import com.Kuba2412.school.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/teachers")
public class TeacherController {


    private final TeacherService teacherService;

    @PostMapping
    public void addTeacher(@RequestBody Teacher teacher) {
        teacherService.addTeacher(teacher);
    }

    @GetMapping("/{id}")
    public Optional<Teacher> getTeacher(@PathVariable Long id) {
        return teacherService.getTeacher(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }

    @PutMapping("{id}")
    public void editTeacher(@RequestBody Teacher teacher) {
        teacherService.editTeacher(teacher);
    }

    @PatchMapping("/{id}/phoneNumber")
    public void changePhoneNumber(@PathVariable Long id, @RequestParam String newPhoneNumber) {
        teacherService.changePhoneNumber(id, newPhoneNumber);
    }

    @GetMapping
    public List<Teacher> getTeachers(@RequestParam(required = false) String gender) {
        List<Teacher> allTeachers = teacherService.getAllTeachers();
        if (gender != null && !gender.isEmpty()) {
            return allTeachers.stream()
                    .filter(teacher -> teacher.getGender().equalsIgnoreCase(gender))
                    .toList();
        } else {
            return allTeachers;
        }
    }
}
