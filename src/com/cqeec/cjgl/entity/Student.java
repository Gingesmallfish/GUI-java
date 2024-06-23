package com.cqeec.cjgl.entity;

public class Student {
    private String xh;
    private String xm;
    private String xb;

    public Student () { }

    public Student(String xh, String xm, String xb) {
        this.xh = xh;
        this.xm = xm;
        this.xb = xb;
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
     *
     * @param xh
     */
    public void setXh(String xh) {
        this.xh = xh;
    }

    /**
     * 获取
     *
     * @return xm
     */
    public String getXm() {
        return xm;
    }

    /**
     * 设置
     *
     * @param xm
     */
    public void setXm(String xm) {
        this.xm = xm;
    }

    /**
     * 获取
     *
     * @return xb
     */
    public String getXb() {
        return xb;
    }

    /**
     * 设置
     *
     * @param xb
     */
    public void setXb(String xb) {
        this.xb = xb;
    }

}
