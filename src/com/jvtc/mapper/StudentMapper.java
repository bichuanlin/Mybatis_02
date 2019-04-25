package com.jvtc.mapper;



import java.util.List;

import com.jvtc.entity.Student;

public interface StudentMapper {
   public Student queryStudentById(String id);//根据学号查询学生信息
   public void addStudent(Student student);
   public int updateStudent(Student student);
   public List<Student> queryAllStudent();
   public int queryCountBySex(String sex);
   public int deleteStudentById(String id);
   public List<Student> selectAllStudentOrderByColumn(String columnName);
   //根据姓名模糊查询学生信息
   public List<Student> queryStudentByName(String name);
}
