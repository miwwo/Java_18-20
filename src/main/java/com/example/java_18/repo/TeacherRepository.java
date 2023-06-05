package com.example.java_18.repo;


import com.example.java_18.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    List<Teacher> findByFirstName(String firstName);

    List<Teacher> findByLastName(String lastName);

    List<Teacher> findBySubject(String subject);

}
