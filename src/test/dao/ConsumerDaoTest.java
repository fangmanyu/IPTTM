package test.dao;

import org.junit.Before;
import org.junit.Test;
import top.stxkfzx.dao.ConsumerDao;
import top.stxkfzx.domain.Consumer;

import java.util.Date;

public class ConsumerDaoTest {

	private ConsumerDao dao;

	@Before
	public void setUp() throws Exception {
		dao = new ConsumerDao();
	}

	@Test
	public void testAdd() {
		Consumer consumer = new Consumer();
		consumer.setCcompany("双体系");
		consumer.setCdate(new Date());
		consumer.setCjob("学生");
		consumer.setCmail("592618473@qq.com");
		consumer.setCmail2("stxkfzx@sina.com");
		consumer.setCmethod("公司付款");
		consumer.setCname("fasd");
		consumer.setCpassword("fff");
		consumer.setCpost("aaa");
		consumer.setCprovince("山西");
		consumer.setCsex("f");
		consumer.setCstate("未注册");
		consumer.setCtelephone("110");


		dao.add(consumer);
	}

	@Test
	public void testFind() {
		ConsumerDao dao = new ConsumerDao();
		Consumer bean = dao.find("fmy", "fff");
		System.out.println(bean);
	}

	@Test
	public void testFindByCid() {
		int count = dao.findByCid("   ");
		System.out.println(count);
	}
}
