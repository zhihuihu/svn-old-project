package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hxkj.wechat.Application;
import com.hxkj.wechat.dao.IUserDao;
import com.hxkj.wechat.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class DataSourceTest {

	@Autowired
	private IUserDao iUserDao;
	
	@Test
	public void testDataSource() throws Exception{
		System.out.println(iUserDao);
		User user = new User();
		user.setName("hzh");
		user.setNumber("2");
		iUserDao.insert(user);
	}
}
