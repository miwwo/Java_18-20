package com.example.java_18.entity;

import com.example.java_18.entity.DTO.StudentDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    // ЗАДАНИЕ 16
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", insertable = false, updatable = false)
    @JsonIgnore
    private Teacher teacher;

    @Column(name = "teacher_id")
    private Long teacherID;

    @Override
    public String toString() {
        return "Student {" +
                "firstName ='" + firstName + '\'' +
                ", lastName ='" + lastName + '\'' +
                ", teacher =" + teacher +
                ", teacherID=" + teacherID +
                '}';
    }

    public StudentDTO makeDTO() {
        return new StudentDTO(id, firstName, lastName, teacherID);
    }
}
