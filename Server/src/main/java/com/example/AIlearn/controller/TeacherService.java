package com.example.AIlearn.controller;

import com.example.AIlearn.model.Teacher;
import com.example.AIlearn.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TeacherService
{
  private static final Map<Long, Teacher> teachersById = new HashMap<>();

  // For demonstration purposes, let's add some dummy teachers during initialization
  static
  {
    User teacherUser1 = new User(3L, "jane@example.com", "password", UserRole.TEACHER);
    User teacherUser2 = new User(4L, "bob@example.com", "password", UserRole.TEACHER);

    Teacher teacher1 = new Teacher(1L, "Jane", teacherUser1, "PhD");
    Teacher teacher2 = new Teacher(2L, "Bob", teacherUser2, "MSc");

    teachersById.put(teacherUser1.getId(), teacher1);
    teachersById.put(teacherUser2.getId(), teacher2);
  }

  public Teacher getTeacherById(Long id)
  {
    return teachersById.get(id);
  }

  public Teacher getTeacherByEmail(String email)
  {
    for (Teacher teacher : teachersById.values())
    {
      if (teacher.getUser().getEmail().equals(email))
      {
        return teacher;
      }
    }
    return null;
  }
}
