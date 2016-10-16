package com.gentlehu.diary.service;

import com.gentlehu.diary.entity.PageInfo;
import com.gentlehu.diary.pojo.Leaveword;

import java.util.List;


public interface ILeavewordService {

    void insert(Leaveword leaveword);

    void deleteByKeyword(String keyword);

    Leaveword findById(Integer id);

    List<Leaveword> findAll(PageInfo pageInfo);

    void update(Integer id,Leaveword leaveword);

    List<Leaveword> findByKey(String keyword);

    void deleteByPrimaryKey(Integer id);

    List<Leaveword> findByPublisher(String publisher);

    int getCount();
}