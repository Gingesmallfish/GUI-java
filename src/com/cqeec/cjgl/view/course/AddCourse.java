/*
 * Created by JFormDesigner on Mon Apr 08 15:19:23 CST 2024
 */

package com.cqeec.cjgl.view.course;

import com.cqeec.cjgl.entity.Course;
import com.cqeec.cjgl.model.CourseModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author 18475
 */
public class AddCourse extends JDialog {
    Course course;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textkc;
    private JLabel label2;
    private JLabel label3;
    private JTextField textbh;
    private JTextField textxf;
    private JButton Save;
    private JButton Cancel;
    public AddCourse(Window owner) {
        super(owner);
        initComponents();
    }
    public AddCourse(Window owner, Course course) {
        super(owner);
        initComponents();
        this.course = course;

        // 将学生信息填入写的输入框中
        this.textbh.setText(course.getKcbh());
        this.textkc.setText(course.getKcmc());
        this.textxf.setText(course.getXf());
    }

    /**
     * 保存数据
     *
     * @param e
     */
    private void Save(ActionEvent e) {
        if (course == null) {
            Course course = new Course(
                    textbh.getText(),
                    textbh.getText(),
                    textxf.getText()
            ); // 创建学生对象


            // 代码改动
            CourseModel.save(course);
            // CourseModel.getCourse().add(course1);  // 将学生添加列表中
        } else {
            this.course.setKcbh(textbh.getText());
            this.course.setKcmc(textkc.getText());
            this.course.setXf(textxf.getText());

            CourseModel.save(course);
        }
        this.dispose();

    }

    /**
     * 取消
     *
     * @param e
     */
    private void Cancel(ActionEvent e) {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textkc = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        textbh = new JTextField();
        textxf = new JTextField();
        Save = new JButton();
        Cancel = new JButton();

        //======== this ========
        setModal(true);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u8bfe\u7a0b\u7f16\u53f7");
        contentPane.add(label1);
        label1.setBounds(60, 85, 65, 32);
        contentPane.add(textkc);
        textkc.setBounds(155, 35, 125, 36);

        //---- label2 ----
        label2.setText("\u8bfe\u7a0b\u540d\u79f0");
        contentPane.add(label2);
        label2.setBounds(60, 37, 65, 32);

        //---- label3 ----
        label3.setText("\u5b66\u5206");
        contentPane.add(label3);
        label3.setBounds(60, 140, 65, 32);
        contentPane.add(textbh);
        textbh.setBounds(155, 85, 125, 36);
        contentPane.add(textxf);
        textxf.setBounds(155, 138, 125, 36);

        //---- Save ----
        Save.setText("\u4fdd\u5b58");
        Save.addActionListener(e -> Save(e));
        contentPane.add(Save);
        Save.setBounds(new Rectangle(new Point(55, 215), Save.getPreferredSize()));

        //---- Cancel ----
        Cancel.setText("\u53d6\u6d88");
        Cancel.addActionListener(e -> Cancel(e));
        contentPane.add(Cancel);
        Cancel.setBounds(new Rectangle(new Point(190, 215), Cancel.getPreferredSize()));

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        setSize(385, 320);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
