/*
 * Created by JFormDesigner on Mon Apr 08 14:39:12 CST 2024
 */

package com.cqeec.cjgl.view.course;

import com.cqeec.cjgl.entity.Course;
import com.cqeec.cjgl.model.CourseModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * @author 18475
 */
public class CourseKc extends JFrame {
    public CourseKc() {
        initComponents();
        Flushedkc(null);
    }

    /**
     * 刷新数据
     *
     * @param e
     */
    private void Flushedkc(ActionEvent e) {
        /**
         *  获取数据以及获取数据模型
         */
        DefaultTableModel model = (DefaultTableModel) table1.getModel();

        // 创建课程对象
        ArrayList<Course> courses = CourseModel.getCourse();

        model.setRowCount(courses.size());
        for (int i = 0; i < courses.size(); i++) {
            // 给第一行第二号设置值
            model.setValueAt(courses.get(i).getKcbh(), i, 0);
            model.setValueAt(courses.get(i).getKcmc(), i, 1);
            model.setValueAt(courses.get(i).getXf(), i, 2);
        }
    }

    /**
     * 新增保存
     *
     * @param e
     */
    private void AddCoursekc(ActionEvent e) {
        AddCourse addCourse = new AddCourse(null);
        addCourse.setVisible(true);
        Flushedkc(null);
    }

    /**
     * 修改数据
     *
     * @param e
     */
    private void Updata(ActionEvent e) {
        // 获取选中行
        int index = table1.getSelectedRow();
        // 判断是否选中
        if (index < 0) {
            return;
        }
        // 从学生中列表取出要修改的学生对象
        Course course = CourseModel.getCourse().get(index);
        // 新建修改窗口 （新增窗口），并将学生对象传递给修改创库
        AddCourse addCourse = new AddCourse(null, course);
        addCourse.setVisible(true);
        Flushedkc(null);
    }

    /**
     * 删除数据
     *
     * @param e
     */
    private void Delete(ActionEvent e) {
        // 获取选中的小标
        int index = table1.getSelectedRow();
        // 代码改动
        if (index < 0) return;
        // 获取选中行的课程名称
        String name = table1.getValueAt(index, 1).toString();
        // 删除指定小标的行
        CourseModel.delete(name);
        // 从学生列表中删除对应元素
        // CourseModel.getCourse().remove(index);
        // 删除过后数据刷新
        Flushedkc(null);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel1 = new JPanel();
        Flushedkc = new JButton();
        AddCoursekc = new JButton();
        updata = new JButton();
        Delete = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                },
                new String[] {
                    "\u8bfe\u7a0b\u7f16\u53f7", "\u8bfe\u7a0b\u540d\u79f0", "\u5b66\u5206"
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

        //======== panel1 ========
        {
            panel1.setLayout(new FlowLayout());

            //---- Flushedkc ----
            Flushedkc.setText("\u5237\u65b0");
            Flushedkc.addActionListener(e -> Flushedkc(e));
            panel1.add(Flushedkc);

            //---- AddCoursekc ----
            AddCoursekc.setText("\u65b0\u589e");
            AddCoursekc.addActionListener(e -> AddCoursekc(e));
            panel1.add(AddCoursekc);

            //---- updata ----
            updata.setText("\u4fee\u6539");
            updata.addActionListener(e -> Updata(e));
            panel1.add(updata);

            //---- Delete ----
            Delete.setText("\u5220\u9664");
            Delete.addActionListener(e -> Delete(e));
            panel1.add(Delete);
        }
        contentPane.add(panel1, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel1;
    private JButton Flushedkc;
    private JButton AddCoursekc;
    private JButton updata;
    private JButton Delete;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
