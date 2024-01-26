package com.example.AIlearn.service;

import com.example.AIlearn.controller.StudentService;
import com.example.AIlearn.controller.TeacherService;
import com.example.AIlearn.controller.UserRole;
import com.example.AIlearn.model.Student;
import com.example.AIlearn.model.Teacher;
import com.example.AIlearn.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
  private final StudentService studentService;
  private final TeacherService teacherService;

  @Autowired
  public UserService(StudentService studentService, TeacherService teacherService) {
    this.studentService = studentService;
    this.teacherService = teacherService;
  }

  public Map<String, Object> loginUser(String email, String password) {
    User user = getUserByEmail(email);

    Map<String, Object> response = new HashMap<>();

    if (user != null && user.getPassword().equals(password)) {
      response.put("success", true);

      if (user.getRole() == UserRole.STUDENT) {
        response.put("userType", "student");
        response.put("details", studentService.getStudentByEmail(email));
      } else if (user.getRole() == UserRole.TEACHER) {
        response.put("userType", "teacher");
        response.put("details", teacherService.getTeacherByEmail(email));
      }
    } else {
      response.put("success", false);
      response.put("message", "Authentication failed. Invalid credentials.");
    }

    return response;
  }

  private User getUserByEmail(String email) {
    Student student = studentService.getStudentByEmail(email);
    if (student != null) {
      return student.getUser();
    }

    Teacher teacher = teacherService.getTeacherByEmail(email);
    if (teacher != null) {
      return teacher.getUser();
    }

    return null;
  }
}
