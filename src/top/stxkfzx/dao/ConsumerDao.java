package top.stxkfzx.dao;


import top.stxkfzx.domain.Consumer;
import top.stxkfzx.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsumerDao {


    public int add(Consumer consumer) {

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getMysqlConnection();

            String sql = "INSERT INTO consumer(cpassword, cname, csex, cmethod, cjob, "
                    + "ccompany, cprovince, ctelephone, cmail, cmail2,cpost, cdate, cstate, cid) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?, ?);";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, consumer.getCpassword());
            ps.setObject(2, consumer.getCname());
            ps.setObject(3, consumer.getCsex());
            ps.setObject(4, consumer.getCmethod());
            ps.setObject(5, consumer.getCjob());
            ps.setObject(6, consumer.getCcompany());
            ps.setObject(7, consumer.getCprovince());
            ps.setObject(8, consumer.getCtelephone());
            ps.setObject(9, consumer.getCmail());
            ps.setObject(10, consumer.getCmail2());
            ps.setObject(11, consumer.getCpost());
            ps.setObject(12, consumer.getCdate());
            ps.setObject(13, consumer.getCstate());
            ps.setObject(14, consumer.getCid());

            return ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn, ps);
        }

        return 0;
    }

    public Consumer find(String name, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getMysqlConnection();
            String sql = "SELECT cid, cpassword, cname, csex, cmethod, cjob, ccompany, "
                    + "cprovince, ctelephone, cmail, cmail2," +
                    "cpost, cdate, cstate FROM consumer where cid = ? and cpassword = ?;";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, name);
            ps.setObject(2, password);
            rs = ps.executeQuery();

            Consumer consumer = null;
            while (rs.next()) {
                consumer = new Consumer();
                consumer.setCcompany(rs.getString("ccompany"));
                consumer.setCdate(rs.getDate("cdate"));
                consumer.setCid(rs.getString("cid"));
                consumer.setCjob(rs.getString("cjob"));
                consumer.setCmail(rs.getString("cmail"));
                consumer.setCmail2(rs.getString("cmail2"));
                consumer.setCmethod(rs.getString("cmethod"));
                consumer.setCname(rs.getString("cname"));
                consumer.setCpassword(rs.getString("cpassword"));
                consumer.setCpost(rs.getString("cpost"));
                consumer.setCprovince(rs.getString("cprovince"));
                consumer.setCsex(rs.getString("csex"));
                consumer.setCstate(rs.getString("cstate"));
                consumer.setCtelephone(rs.getString("ctelephone"));
            }

            return consumer;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(rs, ps, conn);
        }

        return null;
    }

    public int findByCid(String cid) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getMysqlConnection();
            String sql = "SELECT count(*) count FROM consumer where cid = ?;";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, cid);
            rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(ps, conn);
        }

        return 0;
    }
}