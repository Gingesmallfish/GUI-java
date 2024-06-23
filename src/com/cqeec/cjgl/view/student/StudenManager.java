/*
 * Created by JFormDesigner on Mon Mar 25 15:04:39 CST 2024
 */

package com.cqeec.cjgl.view.student;

import com.cqeec.cjgl.entity.Student;
import com.cqeec.cjgl.model.StudentModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * @author Administrator
 */
public class StudenManager extends JFrame {

    public StudenManager() {
        initComponents();
        flushed(null);
    }

    /**
     * 刷新数据
     *
     * @param e
     */
    public void flushed(ActionEvent e) {
        /*
         *  获取数据
         *  获取表格数据模型
         * */
        DefaultTableModel model = (DefaultTableModel) table1.getModel();

        // 改动
        ArrayList<Student> students = StudentModel.getStudents();

        model.setRowCount(students.size());
        for (int i = 0; i < students.size(); i++) {
            // 给第一行第二列设置值
            model.setValueAt(students.get(i).getXh(), i, 0);
            model.setValueAt(students.get(i).getXm(), i, 1);
            model.setValueAt(students.get(i).getXb(), i, 2);
        }
    }

    /**
     * 删除
     *
     * @param e
     */
    private void delete(ActionEvent e) {
        // 获取选中的下标
        int index = table1.getSelectedRow();
        // 代码改动
        if (index < 0) return;
        // 获取选中行的学号
        String xh = table1.getValueAt(index, 0).toString();
        // 删除指定下标的行
        StudentModel.delete(xh);
        // 从学生列表中删除对应元素
        //StudentModel.getStudents().remove(index);
        // 刷新数据
        this.flushed(null);
    }

    /**
     * 显示新增窗口
     *
     * @param e
     */
    private void RevaeL(ActionEvent e) {
        AddStudentForm addStudentForm = new AddStudentForm(null);
        addStudentForm.setVisible(true);
        flushed(null);
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
        Student student = StudentModel.getStudents().get(index);
        // 新建修改窗口 （新增窗口），并将学生对象传递给修改创库
        AddStudentForm addStudentForm1 = new AddStudentForm(null, student);
        addStudentForm1.setVisible(true);
        this.flushed(null);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        flushed = new JButton();
        button2 = new JButton();
        Update = new JButton();
        delete = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

            //---- flushed ----
            flushed.setText("\u5237\u65b0");
            flushed.addActionListener(e -> flushed(e));
            panel1.add(flushed);

            //---- button2 ----
            button2.setText("\u65b0\u589e");
            button2.addActionListener(e -> RevaeL(e));
            panel1.add(button2);

            //---- Update ----
            Update.setText("\u4fee\u6539");
            Update.addActionListener(e -> Updata(e));
            panel1.add(Update);

            //---- delete ----
            delete.setText("\u5220\u9664");
            delete.addActionListener(e -> delete(e));
            panel1.add(delete);
        }
        contentPane.add(panel1, BorderLayout.SOUTH);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null},
                    {null, null, null},
                },
                new String[] {
                    "\u5b66\u53f7", "\u59d3\u540d", "\u6027\u522b"
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
            {
                TableColumnModel cm = table1.getColumnModel();
                cm.getColumn(2).setCellEditor(new DefaultCellEditor(
                    new JComboBox(new DefaultComboBoxModel(new String[] {
                        "\u7537",
                        "\u5973"
                    }))));
            }
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JButton flushed;
    private JButton button2;
    private JButton Update;
    private JButton delete;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
