package com.gentlehu.diary.mapper;

import com.gentlehu.diary.entity.PageInfo;
import com.gentlehu.diary.pojo.Leaveword;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LeavewordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Leaveword record);

    int insertSelective(Leaveword record);

    Leaveword selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Leaveword record);

    List<Leaveword> findByKey(String keyword);

    List<Leaveword> findAll(PageInfo pageInfo);

    List<Leaveword> findByPublisher(String publisher);

    void deleteByKeyword(String keyword);

    int getCount();
}