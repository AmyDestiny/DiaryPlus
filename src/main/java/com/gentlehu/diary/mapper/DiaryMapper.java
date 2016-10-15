package com.gentlehu.diary.mapper;

import java.util.List;

import com.gentlehu.diary.pojo.Diary;

public interface DiaryMapper {
    Diary findDiaryById(Integer id);
    void insertDiary(Diary diary);
    void deleteDiary(Integer id);
    List<Diary> findDiaryByKeyword(String keyword);
    List<Diary> findAllDiary();
}