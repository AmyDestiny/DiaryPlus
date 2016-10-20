package com.gentlehu.diary.pojo;

import java.util.Date;

public class Leaveword {
    protected Integer id;

    protected String publisher;

    protected Date createtime;

    protected String content;

    protected int status;//状态：0：不显示  1：显示


    public Leaveword() {
        super();
    }



    public Leaveword(String publisher, String content) {
        super();
        this.publisher = publisher;
        this.content = content;
        this.createtime = new Date();
        this.status = 0;
    }



    public Leaveword(String publisher, String title,String content, Date createtime) {
        super();
        this.publisher = publisher;
        this.createtime = createtime;
        this.content = content;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }


    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Leaveword{" +
                "id=" + id +
                ", publisher='" + publisher + '\'' +
                ", createtime=" + createtime +
                ", content='" + content + '\'' +
                ", status=" + status +
                '}';
    }
}