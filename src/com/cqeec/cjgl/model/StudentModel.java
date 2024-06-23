package com.cqeec.cjgl.model;

import com.cqeec.cjgl.entity.Student;

import java.util.ArrayList;

public class StudentModel {
    /**
     * 根据学号获取学生对象
     *
     * @param xh 学号
     * @return Student 学生对象
     */
    public static Student getStudentByXh(String xh) {
        for (Student student : StudentModel.getStudents()) {
            if (student.getXh().equals(xh)) {
                return student;
            }
        }
        return null;
    }

    /**
     * 获取学生列表
     *
     * @return students
     */
    public static ArrayList<Student> getStudents() {
        return DataStudent.students;
    }


    /**
     * 删除指定学号的学生
     *
     * @param xh 学号
     */
    public static void delete(String xh) {
        Student student = getStudentByXh(xh);
        if (student != null) {
            DataStudent.students.remove(student);
        }
    }

    /**
     * 判断参数指定的学生是否存在
     *
     * @param student 学生
     * @return 返回下标  -1
     */
    public static int exist(Student student) {
        for (int i = 0; i < DataStudent.students.size(); i++) {
            if (DataStudent.students.get(i).getXh().equals(student.getXh())) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 保存学生对象
     *
     * @param student 要保存的对象
     */
    public static void save(Student student) {
        int index = exist(student);
        if (index == -1) {
            DataStudent.students.add(student);
        } else {
            DataStudent.students.set(index, student);
        }
    }
}
