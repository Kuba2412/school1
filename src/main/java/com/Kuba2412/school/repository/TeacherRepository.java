package com.Kuba2412.school.repository;

import com.Kuba2412.school.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class TeacherRepository {

    private final List<Teacher> teachers = new ArrayList<>();

    public List<Teacher> getAllTeachers() {
        return new ArrayList<>(teachers);
    }

    public Optional<Teacher> getTeacher(Long id) {
        return teachers.stream()
                .filter(teacher -> teacher.getId().equals(id))
                .findFirst();
    }

    public Teacher addTeacher(Teacher teacher) {
        teachers.add(teacher);
        return teacher;
    }

    public void deleteTeacher(Long id) {
        teachers.removeIf(teacher -> teacher.getId().equals(id));
    }

    public void editTeacher(Teacher updatedTeacher) {
        teachers.stream()
                .filter(teacher -> teacher.getId().equals(updatedTeacher.getId()))
                .findFirst()
                .ifPresent(teacher -> {
                    int index = teachers.indexOf(teacher);
                    teachers.set(index, updatedTeacher);
                });
    }

    public void changePhoneNumber(Long id, String newPhoneNumber) {
        teachers.stream()
                .filter(teacher -> teacher.getId().equals(id))
                .findFirst()
                .ifPresent(teacher -> teacher.setPhoneNumber(newPhoneNumber));
    }

}
