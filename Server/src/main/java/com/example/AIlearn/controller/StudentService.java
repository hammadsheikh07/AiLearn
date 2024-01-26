package com.example.AIlearn.controller;

import com.example.AIlearn.model.Student;
import com.example.AIlearn.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService
{

  private static final Map<Long, Student> studentsById = new HashMap<>();

  // For demonstration purposes, let's add some dummy students during initialization
  static
  {
    User studentUser1 = new User(1L, "john@example.com", "password", UserRole.STUDENT);
    User studentUser2 = new User(2L, "alice@example.com", "password", UserRole.STUDENT);

    Student student1 = new Student(1L, "John", 18, studentUser1, "A");
    Student student2 = new Student(2L, "Alice", 20, studentUser2, "B");
    studentsById.put(student1.getId(), student1);
    studentsById.put(student2.getId(), student2);
  }

  public Student getStudentById(Long id)
  {
    return studentsById.get(id);
  }

  public Student getStudentByEmail(String email)
  {
    for (Student student : studentsById.values())
    {
      if (student.getUser().getEmail().equals(email))
      {
        return student;
      }
    }
    return null;
  }
}
