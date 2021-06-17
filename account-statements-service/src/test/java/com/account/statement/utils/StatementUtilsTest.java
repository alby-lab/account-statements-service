package com.account.statement.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatementUtilsTest {
	@Test
	public void isValidAmountandDate() {
		String input ="134.300";
		String input1 =" ";
		String input2 =null;
		assertTrue(StatementUtils.isValidAmount(input));
		assertFalse(StatementUtils.isValidAmount(input1));
		assertFalse(StatementUtils.isValidAmount(input2));
		
	}
	
	@Test
	public void isValidAccountId() {
		
		Long input =(long) 0;
		Long input1 =(long) 1;
		assertTrue(StatementUtils.isValidAccountId(input1));
		assertFalse(StatementUtils.isValidAccountId(input));
	}

}
