package com.itheima.test;



import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.itheima.po.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class MyBatisTest {
	
	@Test
	public void findCustomerById() throws Exception {
		String resource="mybatis-config.xml";
		InputStream inputstream=Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputstream);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		Customer customer=sqlSession.selectOne("com.itheima.mapper.CustomerMapper.findCustomerById",1);
		System.out.println(customer);
		sqlSession.close();
	}
	
	@Test
	public void findCustomerByNameTest() throws Exception {
		String resource="mybatis-config.xml";
		InputStream inputstream=Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputstream);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		List<Customer> list=sqlSession.selectList("com.itheima.mapper.CustomerMapper.findCustomerByName","j");
		for(Customer customer: list) {
			System.out.println(customer);
		}
		sqlSession.close();
	}
	@Test
	public void addCustomerTest()throws Exception{
		String resource="mybatis-config.xml";
		InputStream inputstream=Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputstream);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		Customer customer =new Customer();
		customer.setUsername("rose");
		customer.setJobs("student");
		customer.setPhone("6464646464");
		int ros=sqlSession.insert("com.itheima.mapper.CustomerMapper.addCustomer",customer);
		System.out.println(ros);
		sqlSession.commit();
	}
	@Test
	public void updateCustomerTest()throws Exception{
		String resource="mybatis-config.xml";
		InputStream inputstream=Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputstream);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		Customer customer =new Customer();
		customer.setId(1);
		customer.setUsername("rose");
		customer.setJobs("student");
		customer.setPhone("1111111");
		int rows=sqlSession.update("com.itheima.mapper.CustomerMapper.updateCustomer",customer);
		System.out.println(rows);
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void deleteCustomerTest()throws Exception{
		String resource="mybatis-config.xml";
		InputStream inputstream=Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputstream);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		Customer customer =new Customer();
		customer.setId(1);
		int rows=sqlSession.update("com.itheima.mapper.CustomerMapper.deleteCustomer",4);
		System.out.println(rows);
		sqlSession.commit();
		sqlSession.close();
	}
	
	
}
