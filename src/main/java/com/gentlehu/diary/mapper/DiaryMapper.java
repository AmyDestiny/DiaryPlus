package com.gentlehu.diary.mapper;

import com.gentlehu.diary.pojo.Diary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiaryMapper {
    Diary findDiaryById(Integer id);
    void insertDiary(Diary diary);
    void deleteDiary(Integer id);
    List<Diary> findDiaryByKeyword(String keyword);
    List<Diary> findAllDiary();
}