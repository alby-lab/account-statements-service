package com.account.statement.service;

import java.util.List;

import com.account.statement.domain.Account;
import com.account.statement.domain.Statement;
import com.account.statement.domain.StatementDto;
import com.account.statement.request.StatementRequest;

public interface AccountStatementService {
	List<StatementDto> getStatementbetweenDate(StatementRequest statementRequest);
	List<StatementDto> getStatementbeetweenAmount(StatementRequest statementRequest);
	List<StatementDto> getStatementdateandAmount(StatementRequest statementRequest);
	List<StatementDto> getStatemenParamsNull();

}
