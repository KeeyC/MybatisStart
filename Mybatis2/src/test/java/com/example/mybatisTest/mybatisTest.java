package com.example.mybatisTest;

import com.example.mapper.StudentMapper;
import com.example.mapperUtils.mapperUtils;
import com.example.User.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class mybatisTest {
    private StudentMapper studentMapper;

    @Test
    public void testSelect(){
        SqlSession sqlSession= mapperUtils.getSqlSession();
        studentMapper=sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList=studentMapper.getStudentList();
        for (Student students:studentList
             ) {System.out.println(students);

        }
    }

    @Test
    public void testSelectById(){
        SqlSession sqlSession= mapperUtils.getSqlSession();
        studentMapper=sqlSession.getMapper(StudentMapper.class);
        Long id=new Long((long) 2022);
        Student student=studentMapper.selectStudentListById(id);
        System.out.println(student);

    }
    @Test
    public void testSelectStudentByMap(){
        SqlSession sqlSession=mapperUtils.getSqlSession();
        studentMapper=sqlSession.getMapper(StudentMapper.class);
        HashMap<String, Object> map=new HashMap<String, Object>();
        map.put("username","xiaohua");
        map.put("id",2032);
        List<Student> studentList=studentMapper.selectStudentByMap(map);
        for (Student students:studentList
        ) {System.out.println(students);
        }
    }
    @Test
    public void testInsertByMap(){
        SqlSession sqlSession=mapperUtils.getSqlSession();
        studentMapper=sqlSession.getMapper(StudentMapper.class);
        HashMap<String, Object> map= new HashMap<String, Object>();
        map.put("name","Jack");
        map.put("id","2020");
        map.put("address","London");
        map.put("age","1");
        studentMapper.insertStudent(map);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testUpdate(){
        SqlSession sqlSession=mapperUtils.getSqlSession();
        studentMapper=sqlSession.getMapper(StudentMapper.class);
        Long id=new Long((long) 2022);
        Student student=  studentMapper.selectStudentListById(id);
        student.setAddress("Manchest");
        student.setName("Tom");
        studentMapper.updateStudent(student);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDelete(){
        Long id=new Long((long) 2020);
        SqlSession sqlSession=mapperUtils.getSqlSession();
        studentMapper=sqlSession.getMapper(StudentMapper.class);
        studentMapper.deleteStudentById(id);
        sqlSession.commit();
        sqlSession.close();
    }



}
