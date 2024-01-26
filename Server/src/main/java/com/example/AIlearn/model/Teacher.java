package com.example.AIlearn.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher
{
  private Long id;
  private String name;
  private User user;
  private String qualification;
}
