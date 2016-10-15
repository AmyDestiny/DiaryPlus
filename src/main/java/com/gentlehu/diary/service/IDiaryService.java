package com.gentlehu.diary.service;

import com.gentlehu.diary.pojo.Diary;

import java.util.List;

public interface IDiaryService {
    Diary findDiaryById(Integer id);
    void insertDiary(Diary diary);
    void deleteDiary(Integer id);
    List<Diary> findDiaryByKeyword(String keyword);
    List<Diary> findAllDiary();
}