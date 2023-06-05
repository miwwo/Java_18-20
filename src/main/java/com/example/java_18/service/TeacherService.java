package com.example.java_18.service;

import com.example.java_18.entity.Teacher;
import com.example.java_18.repo.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public void create(Teacher teacher) {
        log.info("Teacher was created");
        teacherRepository.save(teacher);
    }

    public List<Teacher> readAll() {
        log.info("Get all teachers");
        return teacherRepository.findAll();
    }

    public Teacher read(Long id) {
        log.info("Get teacher by id: {}", id);
        return teacherRepository.findById(id).orElse(null);
    }

    public boolean update(Teacher teacher, Long id) {
        if (teacherRepository.existsById(id)) {
            teacher.setId(id);
            teacherRepository.save(teacher);
            log.info("Teacher {} was updated", id);
            return true;
        }
        return false;
    }

    public boolean delete(Long id) {
        if (teacherRepository.existsById(id)) {
            teacherRepository.deleteById(id);
            log.info("Teacher {} was deleted", id);
            return true;
        }
        log.info("Teacher {} wasn't deleted", id);
        return false;
    }

    public List<Teacher> getTeachersByFirstName(String firstName) {
        log.info("Get teacher by first name: {}", firstName);
        return teacherRepository.findByFirstName(firstName);
    }

    public List<Teacher> getTeachersByLastName(String lastName) {
        log.info("Get teacher by last name: {}", lastName);
        return teacherRepository.findByLastName(lastName);
    }

    public List<Teacher> getTeachersBySubject(String subject) {
        log.info("Get teacher by subject: {}", subject);
        return teacherRepository.findBySubject(subject);
    }
}
