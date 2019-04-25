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
	 * ��������ģ����ѯѧ����Ϣ
	 */
	public static void queryStudentByName() {
		Reader reader;
		try {
			reader=Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
			SqlSession session=sessionFactory.openSession();
			StudentMapper studentMapper=session.getMapper(StudentMapper.class);
			List<Student> students=studentMapper.queryStudentByName("��");
			for(int i=0;i<students.size();i++) {
				System.out.println(students.get(i).toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * ��ѯѧ����Ϣ����ָ�����н�������
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
	 * ����ѧ��ɾ��ѧ����Ϣ
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
			System.out.println(count+"��ѧ����ɾ����");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ���Ա�ͳ��ѧ��������
	 * @throws IOException 
	 */
	public static void queryCountBySex()  {
		Reader reader;
		try {
			reader=Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
			SqlSession session=sessionFactory.openSession();
			StudentMapper studentMapper=session.getMapper(StudentMapper.class);
			int count=studentMapper.queryCountBySex("��");//sqlע�����
			System.out.println("��������Ϊ:"+count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	/**
	 * ����ѧ�Ų�ѯѧ����Ϣ
	 */
	public static  void  queryStudentById() {
		Reader reader;
		try {
			reader=Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
			SqlSession session=sessionFactory.openSession();
			//���ݷ��䣬������������ֵ���ӿ�StudentMapper
			StudentMapper studentMapper=session.getMapper(StudentMapper.class);
			Student student=studentMapper.queryStudentById("20181236");
			System.out.println(student);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ���ѧ��
	 */
	 public static void addStudent() {
		 Reader reader;
		 try {
			reader=Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
			SqlSession session=sessionFactory.openSession();
			StudentMapper studentMapper=session.getMapper(StudentMapper.class);
			Student student=new Student("20161236","����",18,"Ů");
			studentMapper.addStudent(student);
			session.commit();
			System.out.println("�ɹ���ӣ�");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	 /**
	  * �޸�ѧ����Ϣ
	  */
	 public static void updateStudent() {
		 Reader  reader;
		 try {
			reader=Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
			SqlSession session=sessionFactory.openSession();
			//�ӿ�
			StudentMapper studentMapper=session.getMapper(StudentMapper.class);
			Student student=new Student("20161236","����",18,"Ů");
			int count=studentMapper.updateStudent(student);
			session.commit();
			System.out.println(count+"��ѧ���޸ĳɹ���");
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	 /**
	  * ��ѯ����ѧ����Ϣ
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
