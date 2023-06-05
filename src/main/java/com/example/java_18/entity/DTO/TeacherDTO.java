package com.example.java_18.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class TeacherDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String subject;
    private List<StudentDTO> students;
}
