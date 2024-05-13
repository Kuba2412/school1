package com.Kuba2412.school.repository;

import com.Kuba2412.school.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class TeacherRepository {

    private List<Teacher> teachers = new ArrayList<>();

    public List<Teacher> getAllTeachers() {
        return teachers;
    }

    public Optional<Teacher> getTeacher(int id) {
        return teachers.stream()
                .filter(teacher -> teacher.getId() == id)
                .findFirst();
    }

    public Teacher addTeacher(Teacher teacher) {
        teachers.add(teacher);
        return teacher;
    }

    public void deleteTeacher(int id) {
        teachers.removeIf(teacher -> teacher.getId() == id);
    }

    public void editTeacher(Teacher updatedTeacher) {
        int index = -1;
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == updatedTeacher.getId()) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            teachers.set(index, updatedTeacher);
        }
    }

    public void changePhoneNumber(int id, String newPhoneNumber) {
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                teacher.setPhoneNumber(newPhoneNumber);
                break;
            }
        }
    }

    public List<Teacher> getTeachersByGender(String gender) {
        return teachers.stream()
                .filter(teacher -> teacher.getGender().equalsIgnoreCase(gender))
                .collect(Collectors.toList());
    }
}
