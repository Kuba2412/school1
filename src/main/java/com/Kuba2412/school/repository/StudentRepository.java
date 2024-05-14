package com.Kuba2412.school.repository;

import com.Kuba2412.school.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Repository
public class StudentRepository {

    private final List<Student> students = new ArrayList<>();

    public List<Student> getAllStudents() {
        return students;
    }

    public Optional<Student> getStudent(Long id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    public void deleteStudent(Long id) {
        students.removeIf(student -> student.getId().equals(id));
    }

    public void editStudent(Student updatedStudent) {
        students.stream()
                .filter(student -> student.getId().equals(updatedStudent.getId()))
                .findFirst()
                .ifPresent(student -> {
                    int index = students.indexOf(student);
                    students.set(index, updatedStudent);
                });
    }

    public void changePhoneNumber(Long id, String newPhoneNumber) {
        students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .ifPresent(student -> student.setPhoneNumber(newPhoneNumber));
    }

}


