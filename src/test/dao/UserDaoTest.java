package test.dao;


import org.junit.Test;
import top.stxkfzx.dao.UserDao;
import top.stxkfzx.domain.User;

import java.util.Date;

public class UserDaoTest {

    @Test
    void testAdd() {
        User user = new User();
        user.setUauthority("admin");
        user.setUdate(new Date());
        user.setUemail("592618473@qq.com");
        user.setUname("fff");
        user.setUpassword("fff");
        user.setUsex("f");
        user.setUtelephone("11111111");


        UserDao dao = new UserDao();
        dao.add(user);
    }

}
