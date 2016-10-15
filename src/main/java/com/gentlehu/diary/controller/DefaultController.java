package com.gentlehu.diary.controller;

import com.gentlehu.diary.entity.Details;
import com.gentlehu.diary.entity.Record;
import com.gentlehu.diary.pojo.Diary;
import com.gentlehu.diary.service.IDiaryService;
import com.gentlehu.diary.utils.DateUtils;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/diary/openapi")
public class DefaultController {

    @Autowired
    private IDiaryService diaryService;

    @RequestMapping(value = "/list",method = {RequestMethod.GET},produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Map<String, Object> list(){
        List<Record> records = getRecords();
        Map<String, Object> map = Maps.newHashMap();
        map.put("code", 200);
        map.put("msg", "请求成功");
        map.put("records", records);
        return map;
    }
    @SuppressWarnings("deprecation")
    private List<Record> getRecords(){
        List<Diary> list = diaryService.findAllDiary();
        List<Record> records = new ArrayList<Record>();
        int size = list.size();
        Record record = null;
        for(int i=0;i<size;){
            Diary d = list.get(i);
            int year = d.getDate().getYear();
            record = getSpecifyYear(records,year);
            if(record == null){
                records.add(new Record(year));
            }
            d = list.get(i);
            getSpecifyYear(records,year).getList().add(
                    new Details(DateUtils.getMD(d.getDate()),d.getIntro(),d.getIsHighLight(),convertChar(d.getMore()),d.getImgpath(),d.getVersion()));

            int next = i+1;
            while(next < size && list.get(next).getDate().getYear() == year){
                record = getSpecifyYear(records,year);
                if(record == null){
                    records.add(new Record(year));
                }
                d = list.get(next);

                getSpecifyYear(records,year).getList().add(
                        new Details(DateUtils.getMD(d.getDate()),d.getIntro(),d.getIsHighLight(),convertChar(d.getMore()),d.getImgpath(),d.getVersion()));
                next++;
            }
            i = next;
        }
        return records;
    }

    /**
     * 在List中获取指定年份的Record
     * @param records
     * @param year
     * @return
     */
    private Record getSpecifyYear(List<Record> records ,Integer year){
        for(Record r:records){
            if(r.getYear() == year){
                return r;
            }
        }
        return null;
    }

    private String convertChar(String text){
        return text.replaceAll("\n", "<br>");
    }
}