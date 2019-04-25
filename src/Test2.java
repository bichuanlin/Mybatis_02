import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jvtc.entity.Grade;
import com.jvtc.mapper.GradeMapper;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//addGrade();
		addGradeMap();
    
	}
	public static void addGrade() {
		Reader reader;
		try {
			reader=Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
			SqlSession session=sessionFactory.openSession();
			GradeMapper gradeMapper=session.getMapper(GradeMapper.class);
			Grade grade=new Grade();
			grade.setName("�ƶ�����1801");
			grade.setNum(40);
			gradeMapper.addGrade(grade);
			session.commit();
			System.out.println(grade.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * ͨ��map������Ӱ༶
	 */
	public static void addGradeMap() {
		Reader reader;
		try {
			reader=Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
			SqlSession session=sessionFactory.openSession();
			GradeMapper gradeMapper=session.getMapper(GradeMapper.class);
			Map<String, Object> map=new HashMap<>();
			map.put("name", "��׿1701");//��ֵ��
			map.put("num", 50);
			map.put("id", 0);//����ʡ��
			gradeMapper.addGradeMap(map);
			session.commit();
			System.out.println(map.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
