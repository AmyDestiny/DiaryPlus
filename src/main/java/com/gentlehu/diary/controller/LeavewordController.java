package com.gentlehu.diary.controller;

import com.gentlehu.diary.entity.JsonResult;
import com.gentlehu.diary.entity.PageInfo;
import com.gentlehu.diary.pojo.Leaveword;
import com.gentlehu.diary.service.ILeavewordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/leaveword")
public class LeavewordController {

    @Autowired
    private ILeavewordService leavewordService;

    @RequestMapping(value = {"/"})
    public ModelAndView index(){
        return new ModelAndView("leaveword");
    }

    @RequestMapping(value = "/list",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public JsonResult list(int pn){
        PageInfo pageInfo = new PageInfo(pn, 5);
        pageInfo.setOrderby("id");
        List<Leaveword> list = leavewordService.findAll(1,pageInfo);
        int count = leavewordService.getCount(1);
        JsonResult json = JsonResult.create(200, "查询成功");
        json.addData("list",list);
        json.addData("count",count);
        return json;
    }

    /**
     * 查询出所有的记录（手机端调用）
     * @param pn pageNumber 页码
     * @param ps pageSize 每页条数
     */
    @RequestMapping(value = "/findAll",method = {RequestMethod.POST},produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public JsonResult findAll(Integer status,int pn,int ps){
        PageInfo pageInfo = new PageInfo(pn, ps);
        pageInfo.setOrderby("id");
        List<Leaveword> list = leavewordService.findAll(status,pageInfo);
        int count = leavewordService.getCount(1);
        JsonResult json = JsonResult.create(200, "查询成功");
        json.addData("list",list);
        json.addData("count",count);
        return json;
    }

    @RequestMapping(value = "/publish",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public JsonResult publish(String nickname,String content){
        Leaveword leaveword = new Leaveword(nickname, content);
        leavewordService.insert(leaveword);
        return JsonResult.create(200,"发表成功");
    }


    @RequestMapping(value = "/delete",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public JsonResult delete(Integer id){
        if(null != id){
            leavewordService.deleteByPrimaryKey(id);
            return JsonResult.create(200,"删除成功");
        }
        return JsonResult.create(300,"缺少必要参数id");
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public JsonResult update(Integer id,int status){
        Leaveword leaveword = new Leaveword();
        leaveword.setStatus(status);
        leavewordService.updateByPrimaryKey(id,leaveword);
        return JsonResult.create(200,"更改成功");
    }


}
