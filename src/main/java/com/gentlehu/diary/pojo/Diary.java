package com.gentlehu.diary.pojo;

import java.util.Date;

public class Diary {
    private Integer id;
    private Date date;
    private String intro;
    private String version;
    private String more;
    private String imgpath;
    private Integer isHighLight;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getIntro() {
        return intro;
    }
    public void setIntro(String intro) {
        this.intro = intro;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
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
    public Integer getIsHighLight() {
        return isHighLight;
    }
    public void setIsHighLight(Integer isHighLight) {
        this.isHighLight = isHighLight;
    }
    @Override
    public String toString() {
        return "Diary [id=" + id + ", date=" + date + ", intro=" + intro
                + ", version=" + version + ", more=" + more + ", imgpath="
                + imgpath + ", isHighLight=" + isHighLight + "]";
    }

}