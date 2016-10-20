package com.gentlehu.diary.mapper;

import com.gentlehu.diary.entity.PageInfo;
import com.gentlehu.diary.pojo.Leaveword;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LeavewordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Leaveword record);

    Leaveword selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Leaveword record);

    List<Leaveword> findByKey(String keyword);

    //如果ststus == null 就查询出所有
    List<Leaveword> findAll(@Param("status") Integer status,@Param("pageInfo") PageInfo pageInfo);

    List<Leaveword> findByPublisher(String publisher);

    List<Leaveword> findByStatus(int status);

    void deleteByKeyword(String keyword);

    int getCount();


}