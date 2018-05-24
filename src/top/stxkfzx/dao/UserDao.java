package top.stxkfzx.dao;


import top.stxkfzx.domain.User;
import top.stxkfzx.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {

	public int add(User user) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtils.getMysqlConnection();
			
			String sql = "INSERT INTO USER(uname, usex, utelephone, uemail, udate, uauthority, upassword)"
					+ " values(?, ?, ?, ?, ?, ?, ?);";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, user.getUname());
			ps.setObject(2, user.getUsex());
			ps.setObject(3, user.getUtelephone());
			ps.setObject(4, user.getUemail());
			ps.setObject(5, user.getUdate());
			ps.setObject(6, user.getUauthority());
			ps.setObject(7, user.getUpassword());
			
			return ps.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, ps);
		}
		
		return 0;
	}
}
