package com.account.statement.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class StatementDto {
	
	private long ID;
	private LocalDate datefield;
	private Double amount;
	private long account_id;
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	
	public LocalDate getDatefield() {
		return datefield;
	}
	public void setDatefield(LocalDate datefield) {
		this.datefield = datefield;
	}
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public long getAccount_id() {
		return account_id;
	}
	public void setAccount_id(long account_id) {
		this.account_id = account_id;
	}

}
