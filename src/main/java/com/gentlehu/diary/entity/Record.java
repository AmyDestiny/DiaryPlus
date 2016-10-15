package com.gentlehu.diary.entity;

import java.util.ArrayList;
import java.util.List;


/**
 * 实体类用于在网页中显示每条记录
 * @author HCC
 *
 */
public class Record {
    private int year;
    private List<Details> list;


    public Record(int year) {
        super();
        this.year = year;

    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public List<Details> getList() {
        if(this.list == null){
            this.list = new ArrayList<Details>();
        }
        return this.list;
    }

}