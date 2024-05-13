package com.Kuba2412.school.service;

import com.Kuba2412.school.model.Teacher;
import com.Kuba2412.school.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.getAllTeachers();
    }

    public Optional<Teacher> getTeacher(int id) {
        return teacherRepository.getTeacher(id);
    }

    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.addTeacher(teacher);
    }

    public void deleteTeacher(int id) {
        teacherRepository.deleteTeacher(id);
    }

    public void editTeacher(Teacher teacher) {
        teacherRepository.editTeacher(teacher);
    }

    public void changePhoneNumber(int id, String newPhoneNumber) {
        teacherRepository.changePhoneNumber(id, newPhoneNumber);
    }

    public List<Teacher> getTeachersByGender(String gender) {
        return teacherRepository.getTeachersByGender(gender);
    }
}
