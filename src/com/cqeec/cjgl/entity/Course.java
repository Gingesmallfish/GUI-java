package com.cqeec.cjgl.entity;

public class Course {
    private String kcbh;
    private String kcmc;
    private String xf;

    public Course() {
    }

    /**
     *  定义成绩管理的课程类
     * @param kcbh 课程编号
     * @param kcmc 课程名称
     * @param xf 学分
     */
    public Course(String kcbh, String kcmc, String xf) {
        this.kcbh = kcbh;
        this.kcmc = kcmc;
        this.xf = xf;
    }


    /**
     * 获取
     * @return kcbh
     */
    public String getKcbh() {
        return kcbh;
    }

    /**
     * 设置
     * @param kcbh
     */
    public void setKcbh(String kcbh) {
        this.kcbh = kcbh;
    }

    /**
     * 获取
     * @return kcmc
     */
    public String getKcmc() {
        return kcmc;
    }

    /**
     * 设置
     * @param kcmc
     */
    public void setKcmc(String kcmc) {
        this.kcmc = kcmc;
    }

    /**
     * 获取
     * @return xf
     */
    public String getXf() {
        return xf;
    }

    /**
     * 设置
     * @param xf
     */
    public void setXf(String xf) {
        this.xf = xf;
    }

    public String toString() {
        return "Course{kcbh = " + kcbh + ", kcmc = " + kcmc + ", xf = " + xf + "}";
    }
}
