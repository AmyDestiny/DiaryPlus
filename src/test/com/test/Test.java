package com.test;

import com.gentlehu.diary.entity.PageInfo;
import com.gentlehu.diary.mapper.LeavewordMapper;
import com.gentlehu.diary.pojo.Diary;
import com.gentlehu.diary.pojo.Leaveword;
import com.gentlehu.diary.service.IDiaryService;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
	
	private ApplicationContext ac;
	private IDiaryService diaryService;

	@Before
	public void setup(){
		ac = new ClassPathXmlApplicationContext(new String[]{
				"classpath:spring-service.xml",
				"classpath:spring-dao.xml",
				"classpath:spring-transaction.xml"});
		
		diaryService = (IDiaryService) ac.getBean("diaryService");
	}

	@org.junit.Test
	public void test4(){
		LeavewordMapper leavewordMapper = (LeavewordMapper) ac.getBean("leavewordMapper");
		for (int i =0 ;i<20;i++){
			leavewordMapper.insert(new Leaveword("user"+i,"content......"+i));
		}
	}

	@org.junit.Test
	public void test3(){
		LeavewordMapper leavewordMapper = (LeavewordMapper) ac.getBean("leavewordMapper");
		PageInfo pageInfo = new PageInfo(2, 3);
		pageInfo.setOrderby("id");
		List<Leaveword> all = leavewordMapper.findAll(null, pageInfo);
		System.out.println(all);
	}
	
	@org.junit.Test
	public void test1(){
		Diary diary = diaryService.findDiaryById(2);
		System.out.println("test1:"+diary);
	}
	@org.junit.Test
	public void test2(){
		List<Diary> list = diaryService.findDiaryByKeyword("aaa");
		System.out.println("test2:"+list.get(0));
	}
}
