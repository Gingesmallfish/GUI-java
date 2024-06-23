/*
 * Created by JFormDesigner on Thu Mar 28 16:32:08 CST 2024
 */

package com.cqeec.cjgl.view.student;

import com.cqeec.cjgl.entity.Student;
import com.cqeec.cjgl.model.StudentModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Administrator
 */
public class AddStudentForm extends JDialog {
    Student student;

    public AddStudentForm(Window owner) {
        super(owner);
        initComponents();
    }

    public AddStudentForm(Window owner, Student student) {
        super(owner);
        initComponents();
        this.student = student;

        // 将学生信息填入写到输入框中
        textxh.setText(student.getXh());
        textxm.setText(student.getXm());
        textxb.setSelectedItem(student.getXb());
    }

    /**
     * 保存学生
     *
     * @param e
     */
    private void btnAdd(ActionEvent e) {
        // 创建新的学生对象
        if (this.student == null) {  // 新增保存
            // 代码优化
            Student student = new Student(
                    textxh.getText(),
                    textxm.getText(),
                    textxb.getSelectedItem().toString()
            ); // 创建新学生对象

            StudentModel.save(student);

            // StudentModel.getStudents().add(student); // 将学生添加列表中
        } else {
            this.student.setXh(textxh.getText());
            this.student.setXm(textxm.getText());
            this.student.setXb(textxb.getSelectedItem().toString());

            StudentModel.save(student);

        }
        dispose();  // 关闭
    }

    /**
     * 如果不添加数据，我们就取消窗口
     *
     * @param e
     */
    private void cancel(ActionEvent e) {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        textxh = new JTextField();
        label2 = new JLabel();
        textxm = new JTextField();
        label3 = new JLabel();
        textxb = new JComboBox<>();
        buttonBar = new JPanel();
        btnAdd = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setModal(true);
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new GridBagLayout());
                ((GridBagLayout)contentPanel.getLayout()).columnWidths = new int[] {0, 0, 0, 0, 164, 33, 0, 0};
                ((GridBagLayout)contentPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0};
                ((GridBagLayout)contentPanel.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
                ((GridBagLayout)contentPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //---- label1 ----
                label1.setText("\u5b66\u53f7");
                contentPanel.add(label1, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                contentPanel.add(textxh, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label2 ----
                label2.setText("\u59d3\u540d");
                contentPanel.add(label2, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                contentPanel.add(textxm, new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label3 ----
                label3.setText("\u6027\u522b");
                contentPanel.add(label3, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- textxb ----
                textxb.setModel(new DefaultComboBoxModel<>(new String[] {
                    "\u7537",
                    "\u5973"
                }));
                contentPanel.add(textxb, new GridBagConstraints(4, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- btnAdd ----
                btnAdd.setText("\u4fdd\u5b58");
                btnAdd.addActionListener(e -> btnAdd(e));
                buttonBar.add(btnAdd, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("\u53d6\u6d88");
                cancelButton.addActionListener(e -> cancel(e));
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JTextField textxh;
    private JLabel label2;
    private JTextField textxm;
    private JLabel label3;
    private JComboBox<String> textxb;
    private JPanel buttonBar;
    private JButton btnAdd;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
