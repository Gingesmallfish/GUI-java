/*
 * Created by JFormDesigner on Wed Apr 10 21:45:24 CST 2024
 */

package com.cqeec.cjgl.view.grade;

import com.cqeec.cjgl.entity.Course;
import com.cqeec.cjgl.entity.Grade;
import com.cqeec.cjgl.entity.Student;
import com.cqeec.cjgl.model.CourseModel;
import com.cqeec.cjgl.model.GradeModel;
import com.cqeec.cjgl.model.StudentModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * @author 18475
 */
public class ScoreManagerForm extends JFrame {
    public ScoreManagerForm() {
        initComponents();
        // 我们获取到DataCourse里面的课程,然后添加到下拉框
        ArrayList<Course> list = CourseModel.getCourse();
        for (Course course : list) {
            Dopdown.addItem(course.getKcmc());
        }
    }

    /**
     * 删除
     *
     * @param e
     */
    private void Delete(ActionEvent e) {
        int index = table1.getSelectedRow();
        if (index >= 0) {
            // 从年纪列表中删除对应元素
            GradeModel.getGrades().remove(index);
        }
        // 删除过后，我们让他自动刷新
        this.Flushed(null);
    }

    /**
     * 刷新
     *
     * @param e
     */
    private void Flushed(ActionEvent e) {
        // 1 获取选择课程的名称
        String kcmc = Dopdown.getSelectedItem().toString();
        // 2 获取课程编号
        String kcbh = CourseModel.getByName(kcmc).getKcbh();
        // 3 从成绩列表中过滤出该们课程的成绩
        ArrayList<Grade> list = GradeModel.getListByKcBh(kcbh);
        // 4 显示成绩
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setRowCount(list.size());

        for (int i = 0; i < list.size(); i++) {
            model.setValueAt(list.get(i).getXh(), i, 0);
            model.setValueAt(list.get(i).getFs(), i, 2);
            String xh = list.get(i).getXh();
            String xm = StudentModel.getStudentByXh(xh).getXm();
            model.setValueAt(xm, i, 1);
        }

        // 按钮
        if (list.size() > 0) {
            btnPllr.setEnabled(false);
        } else {
            btnPllr.setEnabled(true);
        }
        btnSave.setEnabled(false);

    }

    /**
     * 当我们点击成绩管理系统的时候的我们的数据数据自动刷新
     *
     * @param e
     */
    private void Dopdown(ActionEvent e) {
        Flushed(null);
    }
    /**
     * 批量录入
     *
     * @param e
     */
    private void btnPllr(ActionEvent e) {
        // 获取model里面改表
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        ArrayList<Student> list = StudentModel.getStudents();
        model.setRowCount(list.size());
        for (int i = 0; i < list.size(); i++) {
            model.setValueAt(list.get(i).getXh(), i, 0);
            String xh = list.get(i).getXh();
            String xm = StudentModel.getStudentByXh(xh).getXm();
            model.setValueAt(xm, i, 1);
        }
        btnSave.setEnabled(true);
    }

    /**
     * 保存
     *
     * @param e
     */
    private void btnSave(ActionEvent e) {
        ArrayList<Grade> list = GradeModel.getGrades();
        for (int i = 0; i < table1.getRowCount(); i++) {
            String xh = table1.getValueAt(i, 0).toString();
            // TODO Cannot invoke "Object.toString()" because the return value of "javax.swing.JTable.getValueAt(int, int)" is null bug
            String fs = table1.getValueAt(i, 2).toString();
            Integer.parseInt(fs);
            String kcbh = CourseModel.getByName(Dopdown.getSelectedItem().toString()).getKcbh();
            Grade grade = new Grade(xh, kcbh, fs);
            list.add(grade);
        }

        btnSave.setEnabled(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        label1 = new JLabel();
        Dopdown = new JComboBox();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel2 = new JPanel();
        Flushed = new JButton();
        btnPllr = new JButton();
        btnSave = new JButton();
        Delete = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new FlowLayout());

            //---- label1 ----
            label1.setText("\u8bf7\u9009\u62e9\u8bfe\u7a0b\uff1a");
            panel1.add(label1);

            //---- Dopdown ----
            Dopdown.addActionListener(e -> Dopdown(e));
            panel1.add(Dopdown);
        }
        contentPane.add(panel1, BorderLayout.NORTH);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                },
                new String[] {
                    "\u5b66\u53f7", "\u59d3\u540d", "\u5b66\u5206"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    String.class, String.class, String.class
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            });
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1, BorderLayout.CENTER);

        //======== panel2 ========
        {
            panel2.setLayout(new FlowLayout());

            //---- Flushed ----
            Flushed.setText("\u5237\u65b0");
            Flushed.addActionListener(e -> Flushed(e));
            panel2.add(Flushed);

            //---- btnPllr ----
            btnPllr.setText("\u6279\u91cf\u5f55\u5165");
            btnPllr.addActionListener(e -> btnPllr(e));
            panel2.add(btnPllr);

            //---- btnSave ----
            btnSave.setText("\u4fdd\u5b58");
            btnSave.addActionListener(e -> btnSave(e));
            panel2.add(btnSave);

            //---- Delete ----
            Delete.setText("\u5220\u9664");
            Delete.addActionListener(e -> Delete(e));
            panel2.add(Delete);
        }
        contentPane.add(panel2, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JLabel label1;
    private JComboBox Dopdown;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel2;
    private JButton Flushed;
    private JButton btnPllr;
    private JButton btnSave;
    private JButton Delete;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
