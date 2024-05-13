package com.Kuba2412.school.repository;

import com.Kuba2412.school.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

    private List<Student> students = new ArrayList<>();

    public List<Student> getAllStudents() {
        return students;
    }

    public Optional<Student> getStudent(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst();
    }

    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public void editStudent(Student updatedStudent) {
        int index = -1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == updatedStudent.getId()) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            students.set(index, updatedStudent);
        }
    }

    public void changePhoneNumber(int id, String newPhoneNumber) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setPhoneNumber(newPhoneNumber);
                break;
            }
        }
    }

    public List<Student> getStudentsByLastName(String lastName) {
        return students.stream()
                .filter(student ->
                        student.getLastName().startsWith(lastName))
                .collect(Collectors.toList());
    }

}


