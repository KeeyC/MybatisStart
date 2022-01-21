package com.example;


import com.example.User.Student;
import com.example.Mapper.StudentMapper;
import com.example.StudentMapperUtils.StudentMapperUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestStudent {
    @Test
    public void test(){
        SqlSession sqlSession= StudentMapperUtil.getSqlSession();

        StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList=studentMapper.getStudentList();
        for(Student student:studentList){
            System.out.println(student);
        }

    }
}
