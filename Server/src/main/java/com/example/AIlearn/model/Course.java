package com.example.AIlearn.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Course
{
  private Long id;
  private Teacher instructor;
  private List<Student> students;
  private String courseName;
}
