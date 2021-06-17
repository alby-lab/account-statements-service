package com.account.statement.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.account.statement.domain.Statement;

public class StatementRowMapper implements RowMapper<Statement> {

	@Override
	public Statement mapRow(ResultSet rs, int rowNum) throws SQLException {
		Statement statement=new Statement();
		statement.setID(rs.getLong("ID"));
		statement.setDatefield(rs.getString("datefield"));
		statement.setAmount(rs.getString("amount"));
		statement.setAccount_id(rs.getLong("account_id"));
		
		return statement;
	}

}
