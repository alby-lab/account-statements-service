package com.account.statement.domain;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountTest {
    @Test
	public void testGettersandSetters() {
		
		Account account=new Account();
		account.setID(1);
		account.setAccount_type("savings");
		account.setAccount_number("123450987");
		
		assertNotNull(account);
		assertNotNull(account.getID());
		assertNotNull(account.getAccount_number());
		assertNotNull(account.getAccount_type());
		
	}
}
