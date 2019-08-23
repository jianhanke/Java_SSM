import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.itheima.po.Customer;

public class MyBatisTest {
	
	
	@Test
	public void test01() {
		SqlSession sqlSession=MyBatisUtils.getSession();
		
		Customer customer=new Customer();
		customer.setUsername("j");
		
		
		List<Customer> list=sqlSession.selectList("com.itheima.mapper.CustomerMapper.findCustomerByNameAndJobs",customer);

		for(Customer customer2 : list) {
			System.out.println(customer2);
		}
		sqlSession.close();
	}
	@Test
	public void test02() {
		SqlSession sqlSession=MyBatisUtils.getSession();
		
		Customer customer=new Customer();
		customer.setUsername("jack");
		customer.setJobs("teacher");
		List<Customer> list=sqlSession.selectList("com.itheima.mapper.CustomerMapper.findCustomerByNameOrJobs",customer);
		for(Customer customer2 : list) {
			System.out.println(customer2);
		}
		sqlSession.close();
	}
	@Test
	public void test03() {
		SqlSession sqlSession=MyBatisUtils.getSession();
		Customer customer=new Customer();
		customer.setId(3);
		customer.setPhone("21321312");
		int rows=sqlSession.update("com.itheima.mapper.CustomerMapper.updateCustomer",customer);
		System.out.println(rows);
		
	}
	@Test
	public void test04() {
		SqlSession sqlSession=MyBatisUtils.getSession();
		List<Integer> ids=new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		List<Customer> list=sqlSession.selectList("com.itheima.mapper.CustomerMapper.findCustomerByIds",ids);
		for(Customer customer2 : list) {
			System.out.println(customer2);
		}
		
	}
	@Test
	public void test05() {
		SqlSession sqlSession=MyBatisUtils.getSession();
		Customer customer=new Customer();
		customer.setUsername("j");
		List<Customer> list=sqlSession.selectList("com.itheima.mapper.CustomerMapper.findCustomerByName",customer);
		for(Customer customer2 : list) {
			System.out.println(customer2);
		}
		
	}
	
	
}
