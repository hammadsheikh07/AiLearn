package com.example.AIlearn.model;

import com.example.AIlearn.controller.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User
{
  private Long id;
  private String email;
  private String password;
  private UserRole role;
}
