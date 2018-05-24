package top.stxkfzx.frame;

import top.stxkfzx.dao.ConsumerDao;
import top.stxkfzx.domain.Consumer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;


public class RegisterFrame {
    private final ConsumerDao dao = new ConsumerDao();

    private JTextField username;
    private JPasswordField password;
    private JPasswordField repassword;
    private JTextField name;
    private JTextField telephone;
    private JComboBox<String> province;
    private JComboBox<String> status;
    private JTextField email;
    private JFrame registerFrame;
    private ButtonGroup method;
    private ButtonGroup sex;
    private String errorMessage;


    public void createFrame() {

        registerFrame = new JFrame("现在注册");
        registerFrame.setSize(950, 700);
        registerFrame.setLocation(200, 140);
        registerFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container = registerFrame.getContentPane();
        container.setLayout(new GridLayout(1, 3));

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(12, 1, 0, 10));
        p1.add(new JLabel("注册步骤"));
        p1.add(new JLabel("一、阅读并同意协议"));
        p1.add(new JLabel("二、填写表单"));
        p1.add(new JLabel("三、完成注册"));
        container.add(p1);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(12, 1, 0, 10));

        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(12, 1, 0, 10));

        container.add(p2);
        container.add(p3);

        p2.add(new JLabel("用户名"));
        username = new JTextField(10);
        p3.add(username);

        p2.add(new JLabel("性别"));
        sex = new ButtonGroup();
        JRadioButton man = new JRadioButton("男", true);
        sex.add(man);
        JRadioButton woman = new JRadioButton("女", false);
        sex.add(woman);
        JPanel sexJPanel = new JPanel();
        sexJPanel.setLayout(new GridLayout(1, 2));
        sexJPanel.add(man);
        sexJPanel.add(woman);
        p3.add(sexJPanel);

        p2.add(new JLabel("密码"));
        password = new JPasswordField(10);
        p3.add(password);

        p2.add(new JLabel("确认密码"));
        repassword = new JPasswordField(10);
        p3.add(repassword);


        p2.add(new JLabel("姓名:"));
        name = new JTextField(10);
        p3.add(name);

        p2.add(new JLabel("联系电话:"));
        telephone = new JTextField(10);
        p3.add(telephone);

        p2.add(new JLabel("省份:"));
        province = new JComboBox<>(new String[]{"北京", "上海", "河南"});
        p3.add(province);

        p2.add(new JLabel("付款方式"));
        method = new ButtonGroup();
        JRadioButton bank = new JRadioButton("银行转账");
        method.add(bank);
        JRadioButton cash = new JRadioButton("现金支付");
        method.add(cash);
        JRadioButton post = new JRadioButton("邮政汇款");
        method.add(post);
        JRadioButton other = new JRadioButton("其他");
        method.add(other);
        JPanel methodJPanel = new JPanel();
        methodJPanel.setLayout(new GridLayout(1, 4));
        methodJPanel.add(bank);
        methodJPanel.add(cash);
        methodJPanel.add(post);
        methodJPanel.add(other);
        p3.add(methodJPanel);


        p2.add(new JLabel("开通状态:"));
        status = new JComboBox<>(new String[]{"开通", "未开通"});
        p3.add(status);
        status.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
            }
        });

        p2.add(new JLabel("E-mail地址:"));
        email = new JTextField(10);
        p3.add(email);

        JButton next = new JButton("下一步");
        next.addActionListener(new NextActionListener());
        p2.add(next);

        JButton reload = new JButton("重新填写");
        reload.addActionListener(new ReloadActionListener());
        p3.add(reload);

        registerFrame.setVisible(true);
    }

    private class NextActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (!check()) {
                JOptionPane.showMessageDialog(registerFrame, errorMessage,
                        "系统提示", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int count = dao.findByCid(username.getText());
            if (count != 0) {
                JOptionPane.showMessageDialog(registerFrame, "该账号已被注册",
                        "系统提示", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Consumer consumer = new Consumer();

            consumer.setCid(username.getText());
            consumer.setCpassword(new String(password.getPassword()));
            consumer.setCdate(new Date());
            consumer.setCmail(email.getText());
            consumer.setCname(name.getText());
            consumer.setCmethod(JRadioButtonSelect(method));
            consumer.setCprovince(province.getSelectedItem().toString());
            consumer.setCsex(JRadioButtonSelect(sex));
            consumer.setCtelephone(telephone.getText());
            consumer.setCstate(status.getSelectedItem().toString());

            System.out.println(consumer);
            try {
                dao.add(consumer);
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(registerFrame, "注册错误,请重新注册",
                        "系统提示", JOptionPane.ERROR_MESSAGE);
                throw new RuntimeException(e1);
            }
        }


    }

    private class ReloadActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            setJFieldEmpty(username, password, repassword, telephone, name, email);

        }

    }
    public static void main(String[] args) {
        new RegisterFrame().createFrame();
    }

    /**
     * 返回JradioButton所选择的radio的值
     * @param buttonGroup ButtonGroup
     * @return 所选择的radio的值
     */
    private String JRadioButtonSelect(ButtonGroup buttonGroup) {
        Enumeration<AbstractButton> methodEnum = buttonGroup.getElements();
        while (methodEnum.hasMoreElements()) {
            JRadioButton button = (JRadioButton) methodEnum.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }

    private boolean check() {
        if (!Arrays.equals(password.getPassword(), repassword.getPassword())) {
            errorMessage = "两次密码不相同，请重新输入！";

            return false;
        }

        if ("".equals(username.getText().trim())) {
            errorMessage = "用户名不能为空";
            return false;
        }

        if ("".equals(new String(password.getPassword()).trim())) {
            errorMessage = "密码不能为空！";
            return false;
        }


        return true;
    }

    private void setJFieldEmpty(JTextField... jTextFields) {
        for (JTextField temp : jTextFields) {

            temp.setText("");
        }

    }

}
