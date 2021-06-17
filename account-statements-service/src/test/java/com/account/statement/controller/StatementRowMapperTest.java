package com.account.statement.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatementRowMapperTest {
	
	@Test
	public void StatementRowmapperTes() throws SQLException {
		ResultSet rs=Mockito.mock(ResultSet.class);
		long id=1;
		Mockito.when(rs.getLong(ArgumentMatchers.anyInt())).thenReturn(id);
		Mockito.when(rs.getString(ArgumentMatchers.eq("datefield"))).thenReturn("","");
		Mockito.when(rs.getString(ArgumentMatchers.eq("amount"))).thenReturn("","");
		
		
	}

}
