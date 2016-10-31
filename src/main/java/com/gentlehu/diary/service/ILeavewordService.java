package com.gentlehu.diary.service;

import com.gentlehu.diary.entity.PageInfo;
import com.gentlehu.diary.pojo.Leaveword;

import java.util.List;


public interface ILeavewordService {

    void insert(Leaveword leaveword);

    void updateByPrimaryKey(Integer id,Leaveword leaveword);

    void deleteByKeyword(String keyword);

    void deleteByPrimaryKey(Integer id);

    Leaveword findById(Integer id);

    List<Leaveword> findByKey(String keyword);

    List<Leaveword> findByPublisher(String publisher);


    List<Leaveword> findAll(Integer status,PageInfo pageInfo);

    int getCount(Integer status);
}