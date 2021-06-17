package com.account.statement.domain;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StatementDtoTest {

	@Test
	public void testGettersandsetters() {
		 LocalDate date = LocalDate.now(); 
		 Double amount=19.67890;
		StatementDto dto=new StatementDto();
		dto.setID(1);
		dto.setDatefield(date);
		dto.setAmount(amount);
		dto.setAccount_id(1);
	
		assertNotNull(dto);
		assertNotNull(dto.getAmount());
		assertNotNull(dto.getDatefield());
		assertNotNull(dto.getID());
		assertNotNull(dto.getAccount_id());
		
	}
}
