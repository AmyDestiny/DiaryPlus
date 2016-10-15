package com.gentlehu.diary.controller;

import com.gentlehu.diary.pojo.Diary;
import com.gentlehu.diary.service.IDiaryService;
import com.gentlehu.diary.utils.FileUtils;
import com.google.common.collect.Maps;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
@RequestMapping("/admin")
public class DiaryController {

    private static Logger logger = Logger.getLogger(DiaryController.class);

    @Autowired
    private IDiaryService diaryService;

    private static final int SUCCESS = 200;

    @Value("${file.images.uploadPath}")
    private  String imageUploadPath;

    @Value("${file.image.refPath}")
    private String imageRefPath;

    @RequestMapping(value="/insert",method={RequestMethod.POST},produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Map<String, Object> insertDiary(Diary diary,HttpServletRequest request){

        Map<String, Object> map = Maps.newHashMap();
        if(diary.getDate()== null){
            diary.setDate(new Date());
            logger.warn("insertDiary#date == null");
        }
        if(diary.getIntro() == null){
            diary.setIntro("未命名");
            logger.warn("intro == null");
        }

        MultipartHttpServletRequest mtsr = (MultipartHttpServletRequest) request;

        String fileName = FileUtils.saveFile(mtsr.getFile("file"), imageUploadPath);
        if(fileName != null){
            diary.setImgpath(imageRefPath  + fileName);
        }
        diaryService.insertDiary(diary);
        map.put("code", SUCCESS);
        map.put("msg", "添加成功");
        return map;
    }
    @RequestMapping(value = "/delete",method={RequestMethod.POST},produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Map<String, Object> deleteDiary(Integer id){
        Map<String, Object> map =  Maps.newHashMap();
        if(id == null){
            logger.error("deleteDiary# id == null");
            map.put("code", 201);
            map.put("msg", "id == null");
        }else{
            diaryService.deleteDiary(id);
            map.put("code", SUCCESS);
            map.put("msg", "删除成功");
        }
        return map;
    }


    @RequestMapping(value = "/findById",method={RequestMethod.POST},produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Map<String, Object> findDiaryById(@RequestParam Integer id){
        Map<String, Object> map = Maps.newHashMap();
        if(id == null){
            logger.error("findDiaryById# id == null");
            map.put("code", 202);
            map.put("msg", "id == null");
        }else{
            Diary diary = diaryService.findDiaryById(id);
            map.put("code", SUCCESS);
            map.put("msg", "查找成功");
            map.put("diary", diary);
        }
        return map;
    }

    @RequestMapping(value = "/findByKey",method={RequestMethod.POST},produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Map<String, Object> findDiaryByKeyword(String keyword){
        Map<String, Object> map = Maps.newHashMap();
        List<Diary> list;
        if(keyword == null || keyword.trim().length() == 0){
            list = diaryService.findAllDiary();
        }else{
            list = diaryService.findDiaryByKeyword(keyword.trim());
        }
        map.put("code", SUCCESS);
        map.put("msg", "查找成功");
        map.put("list", list);
        return map;
    }

    @RequestMapping(value = "/findAll",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Map<String, Object> findAllDiary(){
        Map<String, Object> map = Maps.newHashMap();
        List<Diary> list = diaryService.findAllDiary();
        map.put("code", SUCCESS);
        map.put("msg", "查找成功");
        map.put("list", list);
        return map;
    }

    /**
     * 自定义时间类型转换器
     * @param binder
     */
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
    }

}