package com.account.statement.domain;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidationResponseTest {
@Test
public void testGettersandSetters() {
	ValidationResponse response=new ValidationResponse();
	response.setMessage("Invalid Data");
	response.setMsgStausCode(400);
	
	assertNotNull(response);
	assertNotNull(response.getMessage());
	assertNotNull(response.getMsgStausCode());
	}
	
}
