package com.gentlehu.diary.service.impl;

import com.gentlehu.diary.entity.PageInfo;
import com.gentlehu.diary.mapper.LeavewordMapper;
import com.gentlehu.diary.pojo.Leaveword;
import com.gentlehu.diary.service.ILeavewordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("leavewordService")
public class LeavewordServiceImpl implements ILeavewordService {

    @Autowired
    private LeavewordMapper leavewordMapper;

    @Override
    public Leaveword findById(Integer id) {
        return leavewordMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据pageInfo来将查询到的所有内容分页
     * 如果pageNum < 1 将查询到的是首页
     * 如果pageNum > 页面总数，自动显示尾页。
     */
    @Override
    public List<Leaveword> findAll(PageInfo pageInfo) {
        int pageNum = pageInfo.getPageNum();
        int count = leavewordMapper.getCount();
        if(pageNum < 1){
            pageInfo.setPageNum(1);
        }else if(pageNum > (((count - 1) / pageInfo.getPageSize()) + 1)){
            pageInfo.setPageNum(((count - 1) / pageInfo.getPageSize()) + 1);
        }
        return leavewordMapper.findAll(pageInfo);
    }

    @Override
    public void update(Integer id, Leaveword leaveword) {
        leaveword.setId(id);
        leavewordMapper.updateByPrimaryKey(leaveword);
    }

    @Override
    public List<Leaveword> findByKey(String keyword) {
        return leavewordMapper.findByKey(keyword);
    }

    @Override
    public void deleteByPrimaryKey(Integer id) {
        leavewordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Leaveword> findByPublisher(String publisher) {
        return leavewordMapper.findByPublisher(publisher);
    }

    @Override
    public void insert(Leaveword leaveword) {
        leavewordMapper.insertSelective(leaveword);
    }

    @Override
    public void deleteByKeyword(String keyword) {
        leavewordMapper.deleteByKeyword(keyword);
    }

    @Override
    public int getCount() {
        return leavewordMapper.getCount();
    }

}