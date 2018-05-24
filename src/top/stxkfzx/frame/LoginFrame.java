package top.stxkfzx.frame;

import top.stxkfzx.dao.ConsumerDao;
import top.stxkfzx.domain.Consumer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 登录界面
 */
public class LoginFrame implements ActionListener {

    private JButton submit;
    private JButton clear;
    private JButton reload;
    private JButton register;
    private JDialog tip;
    private JButton exit;
    private JFrame loginFrame;
    private JTextField username;
    private JPasswordField password;

    public void createFrame() {
        loginFrame = new JFrame("login");
        loginFrame.setSize(300, 200);
        loginFrame.setLocation(200, 300);
        loginFrame.setDefaultCloseOperation(loginFrame.EXIT_ON_CLOSE);

        Container container = loginFrame.getContentPane();
        container.setLayout(new FlowLayout());

        container.add(new JLabel("用户姓名"));
        username = new JTextField(10);
        container.add(username);
        container.add(new JLabel("用户口令"));
        password = new JPasswordField(10);
        container.add(password);

//        设置登录监听
        submit = new JButton("登录");
        submit.addActionListener(this);
        container.add(submit);

        clear = new JButton("清除");
        clear.addActionListener(this);
        container.add(clear);

        tip = new JDialog();
        tip.setSize(440, 100);
        tip.setLocation(loginFrame.getX() + 100, loginFrame.getY() + 100);
        tip.setLayout(new FlowLayout());
        tip.add(new Label("reload or exit?"));

        reload = new JButton("重新输入");
        reload.addActionListener(this);
        tip.add(reload);

        exit = new JButton("退出");
        exit.addActionListener(this);
        tip.add(exit);

        container.add(new JLabel("如果你还没有开始注册，请注册"));
        register = new JButton("注册");
        register.addActionListener(this);
        container.add(register);

        loginFrame.setVisible(true);
    }

    public static void main(String[] args) {
        LoginFrame lf = new LoginFrame();
        lf.createFrame();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

//        触发登录监听
        if (e.getSource().equals(submit)) {
            ConsumerDao consumerDao = new ConsumerDao();
            Consumer consumer = consumerDao.find(username.getText(), new String(password.getPassword()));
            System.out.println("username = " + username.getText());
            System.out.println("password = " + new String(password.getPassword()));

            if (consumer == null) {
                JOptionPane.showMessageDialog(loginFrame, "您输入的账号或密码错误，请重新输入！",
                        "系统提示", JOptionPane.ERROR_MESSAGE);
                return;
            }

            new AppFrame().createFrame();
            loginFrame.setVisible(false);

            return;
        }

//        触发清除监听
        if (e.getSource().equals(clear)) {
            tip.setVisible(true);
            return;
        }

//        触发退出监听
        if (e.getSource().equals(exit)) {
            System.exit(0);
        }

        // 触发重新输入监听
        if (e.getSource().equals(reload)) {
            username.setText("");
            password.setText("");

//            关闭提示框(此时的提示框是弹出的)
            tip.setVisible(false);
        }

//        触发注册监听
        if (e.getSource().equals(register)) {
            new RegisterFrame().createFrame();

            loginFrame.setVisible(false);
        }
    }
}
