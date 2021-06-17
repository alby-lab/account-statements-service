package com.account.statement.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.account.statement.domain.Account;

public class AccountRowMapper implements RowMapper<Account>{

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account =new Account();
		account.setID(rs.getLong("ID"));
		account.setAccount_type(rs.getString("account_type"));
		account.setAccount_number(rs.getString("account_number"));
		return account;
	}

}
