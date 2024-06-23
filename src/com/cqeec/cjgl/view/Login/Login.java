package com.cqeec.cjgl.view.Login;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
/*
 * Created by JFormDesigner on Mon Mar 18 14:40:55 CST 2024
 */


/**
 * @author 18475
 */
public class Login extends JFrame {
    public Login() {
        initComponents();
    }

    /**
     * 登录按钮处理事件
     *
     * @param e
     */
    private void fcok(ActionEvent e) {
        // 获取输入用户名
        String strUserName = username.getText();
        // 获取输入密码
        String strPassword = new String(password.getPassword());
        /*
        * 如果用户民为admin并且密码为1234.输出登录成功，如果民为admin并且密码为1234输出失败
        * 这里我们使用[.equals方法]：他是用于比较两个对象是否相等的方法，如果过两个变量相等就登录成功，如果不相等就登录失败
        * */
        if (strUserName.equals("admin") && strPassword.equals("123")) {
            MainForm mainForm = new MainForm();
            mainForm.setVisible(true);
            this.dispose(); // 释放窗口
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
    }
    /**
     * 按钮退出
     *
     * @param e
     */
    private void Quit(ActionEvent e) {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        username = new JTextField();
        label2 = new JLabel();
        password = new JPasswordField();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setTitle("\u767b\u5f55");
        setIconImage(((ImageIcon)UIManager.getIcon("html.missingImage")).getImage());
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(null);

                //---- label1 ----
                label1.setText("\u7528\u6237\u540d:");
                contentPanel.add(label1);
                label1.setBounds(85, 40, 45, 20);

                //---- username ----
                username.setText("admin");
                username.setColumns(10);
                username.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 16));
                username.setForeground(new Color(0x3366ff));
                contentPanel.add(username);
                username.setBounds(155, 35, 170, username.getPreferredSize().height);

                //---- label2 ----
                label2.setText("\u5bc6\u7801");
                contentPanel.add(label2);
                label2.setBounds(90, 95, 40, 17);

                //---- password ----
                password.setFont(new Font("Arial Black", Font.PLAIN, 10));
                password.setText("123");
                contentPanel.add(password);
                password.setBounds(155, 88, 170, password.getPreferredSize().height);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < contentPanel.getComponentCount(); i++) {
                        Rectangle bounds = contentPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = contentPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    contentPanel.setMinimumSize(preferredSize);
                    contentPanel.setPreferredSize(preferredSize);
                }
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- okButton ----
                okButton.setText("\u767b\u5f55");
                okButton.addActionListener(e -> fcok(e));
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("\u9000\u51fa");
                cancelButton.addActionListener(e -> Quit(e));
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        setSize(587, 337);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JTextField username;
    private JLabel label2;
    private JPasswordField password;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
