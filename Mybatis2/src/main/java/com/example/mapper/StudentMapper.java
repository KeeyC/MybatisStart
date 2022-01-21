package com.example.mapper;

import com.example.User.Student;

import java.util.HashMap;
import java.util.List;

public interface StudentMapper {
    List<Student> getStudentList();
    Student selectStudentListById(Long id);
    List<Student> selectStudentByMap(HashMap<String, Object> map);
    void insertStudent(HashMap<String,Object> map);
    void updateStudent(Student student);
    void deleteStudentById(Long id);
}
