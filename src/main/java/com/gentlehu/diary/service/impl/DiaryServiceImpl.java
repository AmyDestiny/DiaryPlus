package com.gentlehu.diary.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gentlehu.diary.mapper.DiaryMapper;
import com.gentlehu.diary.pojo.Diary;
import com.gentlehu.diary.service.IDiaryService;

@Service("diaryService")
public class DiaryServiceImpl implements IDiaryService{

    @Autowired
    private DiaryMapper diaryMapper;

    @Override
    public Diary findDiaryById(Integer id) {
        return diaryMapper.findDiaryById(id);
    }

    @Override
    public void insertDiary(Diary diary) {
        diaryMapper.insertDiary(diary);
    }

    @Override
    public void deleteDiary(Integer id) {
        diaryMapper.deleteDiary(id);
    }

    @Override
    public List<Diary> findDiaryByKeyword(String keyword) {
        return diaryMapper.findDiaryByKeyword(keyword);
    }

    @Override
    public List<Diary> findAllDiary() {
        return diaryMapper.findAllDiary();
    }

}