package com.xmut.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {
	
	@Autowired
    private UserService userservice;
	
	@Test
	public void test()
	{
		userservice.updateUser("2", "2", "2");
	}

}
