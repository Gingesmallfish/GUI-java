/*
 * Created by JFormDesigner on Mon Mar 25 14:23:20 CST 2024
 */

package com.cqeec.cjgl.view.Login;

import com.cqeec.cjgl.view.course.CourseKc;
import com.cqeec.cjgl.view.grade.ScoreManagerForm;
import com.cqeec.cjgl.view.student.StudenManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Administrator
 */
public class MainForm extends JFrame {
    public MainForm() {
        initComponents();
    }


    /**
     * 取消窗口
     *
     * @param e
     */
    private void miExit(ActionEvent e) {
        this.dispose();
    }

    /**
     * 学生管理
     *
     * @param e
     */
    private void StudenActiaon(ActionEvent e) {
       StudenManager studenManager = new StudenManager();
       studenManager.setVisible(true);
    }

    /**
     * 课程管理
     *
     * @param e
     */

    private void coUrse(ActionEvent e) {
        CourseKc kcgl = new CourseKc();
        kcgl.setVisible(true);
    }

    /**
     * 成绩管理
     *
     * @param e
     */
    private void Grades(ActionEvent e) {
        ScoreManagerForm scoreManagerForm = new ScoreManagerForm();
        scoreManagerForm.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        miExit = new JMenuItem();
        menu2 = new JMenu();
        Studen = new JMenuItem();
        coUrse = new JMenuItem();
        Grades = new JMenuItem();
        menu3 = new JMenu();
        menuItem5 = new JMenuItem();
        dialogPane = new JPanel();
        contentPanel = new JPanel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u6587\u4ef6");

                //---- miExit ----
                miExit.setText("\u9000\u51fa");
                miExit.addActionListener(e -> miExit(e));
                menu1.add(miExit);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("\u7cfb\u7edf\u7ba1\u7406");

                //---- Studen ----
                Studen.setText("\u5b66\u751f\u7ba1\u7406");
                Studen.addActionListener(e -> StudenActiaon(e));
                menu2.add(Studen);

                //---- coUrse ----
                coUrse.setText("\u8bfe\u7a0b\u7ba1\u7406");
                coUrse.addActionListener(e -> coUrse(e));
                menu2.add(coUrse);

                //---- Grades ----
                Grades.setText("\u6210\u7ee9\u7ba1\u7406");
                Grades.addActionListener(e -> Grades(e));
                menu2.add(Grades);
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("\u6210\u7ee9\u5206\u6790");

                //---- menuItem5 ----
                menuItem5.setText("\u6210\u7ee9\u6392\u540d");
                menu3.add(menuItem5);
            }
            menuBar1.add(menu3);
        }
        setJMenuBar(menuBar1);

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new BorderLayout());
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        setSize(606, 500);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem miExit;
    private JMenu menu2;
    private JMenuItem Studen;
    private JMenuItem coUrse;
    private JMenuItem Grades;
    private JMenu menu3;
    private JMenuItem menuItem5;
    private JPanel dialogPane;
    private JPanel contentPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
