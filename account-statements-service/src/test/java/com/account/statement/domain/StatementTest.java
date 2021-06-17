package com.account.statement.domain;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StatementTest {
	@Test
	public void testGettersandSetters() {
		
		Statement statement=new Statement();
		statement.setID(1);
		statement.setAmount("191.608098447429");
		statement.setDatefield("14.10.2020");
		statement.setAccount_id(1);
		
		assertNotNull(statement);
		assertNotNull(statement.getID());
		assertNotNull(statement.getAmount());
		assertNotNull(statement.getDatefield());
		assertNotNull(statement.getAccount_id());
		
	}

}
