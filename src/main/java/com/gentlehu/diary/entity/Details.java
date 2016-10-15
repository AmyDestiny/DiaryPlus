package com.gentlehu.diary.entity;

public class Details {
    private String date;
    private String intro;
    private int isHighLight;
    private String more;
    private String imgpath;
    private String version;
    public Details(String date, String intro, int isHighLight, String more,String imgpath,String version) {
        super();
        this.date = date;
        this.intro = intro;
        this.isHighLight = isHighLight;
        this.more = more;
        this.imgpath = imgpath;
        this.version = version;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getIntro() {
        return intro;
    }
    public void setIntro(String intro) {
        this.intro = intro;
    }
    public int getIsHighLight() {
        return isHighLight;
    }
    public void setIsHighLight(int isHighLight) {
        this.isHighLight = isHighLight;
    }
    public String getMore() {
        return more;
    }
    public void setMore(String more) {
        this.more = more;
    }
    public String getImgpath() {
        return imgpath;
    }
    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }


}