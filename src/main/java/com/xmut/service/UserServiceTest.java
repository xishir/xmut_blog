package com.xmut.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {
	
	@Autowired
    private ArticleService articleservice;
	
	@Test
	public void test()
	{
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("title", "标题");
		map.put("author", "作者");
		map.put("sort", "hg,jash,sajh,sk");
		map.put("time", "2018-01-18 13:07:00");
		map.put("content", "测试");
		articleservice.createArticle(map);
	}

}
