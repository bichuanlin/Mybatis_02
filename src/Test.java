import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jvtc.entity.Student;
import com.jvtc.mapper.StudentMapper;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//addStudent();
		//updateStudent();
		//queryAllStudent();
		//queryStudentById();
		//queryCountBySex();
		//deleteStudent();
		//selectAllStudentOrderByColumn();
		queryStudentByName();
	}
	/**
	 * 根据姓名模糊查询学生信息
	 */
	public static void queryStudentByName() {
		Reader reader;
		try {
			reader=Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
			SqlSession session=sessionFactory.openSession();
			StudentMapper studentMapper=session.getMapper(StudentMapper.class);
			List<Student> students=studentMapper.queryStudentByName("张");
			for(int i=0;i<students.size();i++) {
				System.out.println(students.get(i).toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 查询学生信息，按指定的列进行排序
	 */
	public static void selectAllStudentOrderByColumn() {
		Reader reader;
		try {
			reader=Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
			SqlSession session=sessionFactory.openSession();
			StudentMapper studentMapper=session.getMapper(StudentMapper.class);
			List<Student> students=studentMapper.selectAllStudentOrderByColumn("age");
			for(int i=0;i<students.size();i++) {
				System.out.println(students.get(i).toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 根据学号删除学生信息
	 */
	public static void deleteStudent() {
		Reader reader;
		try {
			reader=Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
			SqlSession session=sessionFactory.openSession();
			StudentMapper studentMapper=session.getMapper(StudentMapper.class);
			int count=studentMapper.deleteStudentById("20187777");
			session.commit();			
			System.out.println(count+"个学生被删除！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 按性别统计学生的人数
	 * @throws IOException 
	 */
	public static void queryCountBySex()  {
		Reader reader;
		try {
			reader=Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
			SqlSession session=sessionFactory.openSession();
			StudentMapper studentMapper=session.getMapper(StudentMapper.class);
			int count=studentMapper.queryCountBySex("男");//sql注入风险
			System.out.println("男生人数为:"+count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	/**
	 * 根据学号查询学生信息
	 */
	public static  void  queryStudentById() {
		Reader reader;
		try {
			reader=Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
			SqlSession session=sessionFactory.openSession();
			//根据反射，来给创建对象赋值给接口StudentMapper
			StudentMapper studentMapper=session.getMapper(StudentMapper.class);
			Student student=studentMapper.queryStudentById("20181236");
			System.out.println(student);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 添加学生
	 */
	 public static void addStudent() {
		 Reader reader;
		 try {
			reader=Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
			SqlSession session=sessionFactory.openSession();
			StudentMapper studentMapper=session.getMapper(StudentMapper.class);
			Student student=new Student("20161236","芳芳",18,"女");
			studentMapper.addStudent(student);
			session.commit();
			System.out.println("成功添加！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	 /**
	  * 修改学生信息
	  */
	 public static void updateStudent() {
		 Reader  reader;
		 try {
			reader=Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
			SqlSession session=sessionFactory.openSession();
			//接口
			StudentMapper studentMapper=session.getMapper(StudentMapper.class);
			Student student=new Student("20161236","芳芳",18,"女");
			int count=studentMapper.updateStudent(student);
			session.commit();
			System.out.println(count+"个学生修改成功！");
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	 /**
	  * 查询所有学生信息
	  */
	 public static void queryAllStudent() {
		 Reader reader;
		 try {
			reader=Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
			SqlSession session=sessionFactory.openSession();
			StudentMapper studentMapper=session.getMapper(StudentMapper.class);
			List<Student> students=studentMapper.queryAllStudent();
			for(int i=0;i<students.size();i++) {
				System.out.println(students.get(i));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

}
