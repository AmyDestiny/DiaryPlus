package com.gentlehu.diary.pojo;

import java.util.Date;

public class Leaveword {
    protected Integer id;

    protected String publisher;

    protected String title;

    protected Date createtime;

    protected String content;



    public Leaveword() {
        super();
    }



    public Leaveword(String publisher, String title, String content) {
        super();
        this.publisher = publisher;
        this.title = title;
        this.content = content;
    }



    public Leaveword(String publisher, String title,String content, Date createtime) {
        super();
        this.publisher = publisher;
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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



    @Override
    public String toString() {
        return "Leaveword [id=" + id + ", publisher=" + publisher + ", title="
                + title + ", createtime=" + createtime + ", content=" + content
                + "]";
    }


}