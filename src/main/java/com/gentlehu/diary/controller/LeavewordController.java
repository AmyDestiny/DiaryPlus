package com.gentlehu.diary.controller;

import com.gentlehu.diary.service.ILeavewordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/leaveword")
public class LeavewordController {

    @Autowired
    private ILeavewordService leavewordService;

    /**
     * 查询出所有的记录
     * @param pn pageNumber 页码
     * @param ps pageSize 每页条数
     */
    public Map<String,Object> findAll(int pn,int ps){

    }

}
