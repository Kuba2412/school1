package com.Kuba2412.school.service;

import com.Kuba2412.school.model.Student;
import com.Kuba2412.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public Optional<Student> getStudent(Long id) {
        return studentRepository.getStudent(id);
    }

    public Student addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteStudent(id);
    }

    public Student editStudent(Student student) {
        studentRepository.editStudent(student);
        return student;
    }

    public void changePhoneNumber(Long id, String newPhoneNumber) {
        studentRepository.changePhoneNumber(id, newPhoneNumber);
    }

}
