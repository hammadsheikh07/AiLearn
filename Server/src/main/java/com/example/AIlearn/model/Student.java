package com.example.AIlearn.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student
{
  private Long id;
  private String name;
  private int age;
  private User user;
  private String grade;
}
