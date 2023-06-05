package com.example.java_18.controller;

import com.example.java_18.service.StudentService;
import com.example.java_18.service.TeacherService;
import com.example.java_18.entity.Student;
import com.example.java_18.entity.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final TeacherService teacherService;

    @PostMapping(value = "/students", consumes = {"application/json"})
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        System.out.println("log: " + student);
        studentService.create(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/students")
    public ResponseEntity<List<Student>> getStudent(){
        List<Student> students = studentService.readAll();
        if (students != null && !students.isEmpty()){
            return new ResponseEntity<>(students, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable(name = "id") Long id){
        Student student = studentService.read(id);
        if (student != null){
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/students/{id}", consumes = {"application/json"})
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody Student student){
        boolean isUpdated = studentService.update(student, id);
        if (isUpdated){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping(value = "/students/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        boolean isDeleted = studentService.delete(id);
        if (isDeleted){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }


    @GetMapping(value = "/students/{id}/teacher")
    public ResponseEntity<Teacher> getTeacherByStudentID(@PathVariable Long id){
        Student student = studentService.read(id);
        return new ResponseEntity<>(teacherService.read(student.getTeacherID()),HttpStatus.OK);
    }

    @GetMapping(value = "/student/first_name/{first_name}")
    public ResponseEntity<List<Student>> getStudentsByFirstName(@PathVariable String first_name){
        return new ResponseEntity<>(studentService.getStudentsByFirstName(first_name),
                HttpStatus.OK);
    }

    @GetMapping(value = "/student/last_name/{last_name}")
    public ResponseEntity<List<Student>> getStudentsBySecondName(@PathVariable String last_name){
        return new ResponseEntity<>(studentService.getStudentsByLastName(last_name),
                HttpStatus.OK);
    }

    @GetMapping(value = "/student/teacher_id/{teacher_id}")
    public ResponseEntity<List<Student>> getStudentsByTeacherId(@PathVariable Long teacher_id){
        return new ResponseEntity<>(studentService.getStudentsByTeacherId(teacher_id),
                HttpStatus.OK);
    }
}
