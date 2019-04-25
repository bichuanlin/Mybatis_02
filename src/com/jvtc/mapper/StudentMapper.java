package com.jvtc.mapper;



import java.util.List;

import com.jvtc.entity.Student;

public interface StudentMapper {
   public Student queryStudentById(String id);//����ѧ�Ų�ѯѧ����Ϣ
   public void addStudent(Student student);
   public int updateStudent(Student student);
   public List<Student> queryAllStudent();
   public int queryCountBySex(String sex);
   public int deleteStudentById(String id);
   public List<Student> selectAllStudentOrderByColumn(String columnName);
   //��������ģ����ѯѧ����Ϣ
   public List<Student> queryStudentByName(String name);
}
