package com.example.java_18.service;


import com.example.java_18.entity.Student;
import com.example.java_18.repo.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void create(Student student) {
        log.info("Student was created");
        studentRepository.save(student);
    }

    public List<Student> readAll() {
        log.info("Get all students");
        return studentRepository.findAll();
    }

    public Student read(Long id) {
        log.info("Student was found by ID");
        return studentRepository.findById(id).orElse(null);
    }

    public boolean update(Student student, Long id) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            studentRepository.save(student);
            log.info("Student was updated");
            return true;
        }
        return false;
    }

    public boolean delete(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            log.info("Student number {} was deleted", id);
            return true;
        }
        return false;
    }

    public List<Student> getStudentsByFirstName(String firstName) {
        log.info("Get student by first name: {}", firstName);
        return studentRepository.findByFirstName(firstName);
    }

    public List<Student> getStudentsByLastName(String lastName) {
        log.info("Get student by last name: {}", lastName);
        return studentRepository.findByLastName(lastName);
    }

    public List<Student> getStudentsByTeacherId(Long teacherId) {
        log.info("Get student by teacher's id: {}", teacherId);
        return studentRepository.findByTeacherId(teacherId);
    }


}

