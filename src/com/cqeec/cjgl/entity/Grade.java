package com.cqeec.cjgl.entity;

public class Grade {
    private String xh;
    private String kcbh;
    private String fs;

    public Grade() {
    }

    /**
     *  定义构造函数
     * @param xh 学号
     * @param kcbh 课程编号
     * @param fs 分数
     */
    public Grade(String xh, String kcbh, String fs) {
        this.xh = xh;
        this.kcbh = kcbh;
        this.fs = fs;
    }


    /**
     * 获取
     * @return xh
     */
    public String getXh() {
        return xh;
    }

    /**
     * 设置
     * @param xh
     */
    public void setXh(String xh) {
        this.xh = xh;
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
     * @return fs
     */
    public String getFs() {
        return fs;
    }

    /**
     * 设置
     * @param fs
     */
    public void setFs(String fs) {
        this.fs = fs;
    }
}
