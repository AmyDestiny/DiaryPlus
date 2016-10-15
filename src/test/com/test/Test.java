package test;

import java.util.List;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gentlehu.diary.pojo.Diary;
import com.gentlehu.diary.service.IDiaryService;

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
	public void test1(){
		Diary diary = diaryService.findDiaryById(2);
		System.out.println("test1:"+diary);
	}
	@org.junit.Test
	public void test2(){
		List<Diary> list = diaryService.findDiaryByKeyword("内容");
		System.out.println("test2:"+list.get(0));
	}
}
