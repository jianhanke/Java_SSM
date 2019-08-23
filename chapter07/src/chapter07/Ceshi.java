package chapter07;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


import com.itheima.po.*;

public class Ceshi {
	
	@Test
	public void test01() {
		
		SqlSession sqlSession=MyBatisUtils.getSession();
		Customer customer=new Customer();
		customer.setUsername("rose");
		customer.setJobs("student");
		customer.setPhone("ljl");
		int rows=sqlSession.insert("com.itheima.mapper.CustomerMapper.addCustomer",customer);
		System.out.println(rows);
		System.out.println("²åÈëÖ÷¼üÎª"+customer.getId());
		sqlSession.commit();
		sqlSession.close();
		
	}
	
	@Test
	public void test02() {
		SqlSession sqlSession=MyBatisUtils.getSession();
		List<User> list=sqlSession.selectList("com.itheima.mapper.UserMapper.xml.findAllUser");
		for(User user:list) {
			System.out.println(user);
		}
	}
	
}
