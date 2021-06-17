package com.account.statement.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.account.statement.domain.Statement;
import com.account.statement.domain.StatementDto;
import com.account.statement.repository.StatementRowMapper;
import com.account.statement.request.StatementRequest;
@Service
public class AccountSatementServiceImpl implements AccountStatementService {
	private static final Logger logger = LoggerFactory.getLogger(AccountSatementServiceImpl.class);
    @Autowired
	JdbcTemplate jdbcTemplate;

	
/**
 * ____________________________________________________________________________________________
 * 
 * @author : Albert
 * @MethodDesc : To get the statement between two dates
 * @File : AccountSatementServiceImpl.java
 * @CreatedDate : JUN 16, 2021
 * @ModifiedDate :
 * @input :StatementRequest
 * @return : List
 *         ______________________________________________________________________________________________
 */   
@Override
public List<StatementDto> getStatementbetweenDate(StatementRequest statementRequest) {
	List<StatementDto> accountFilteredList =null;
	DateFormat format = new SimpleDateFormat("dd.MM.yyyy",Locale.ENGLISH);
	try {
		List<Statement> statementList=jdbcTemplate.query("SELECT ID,datefield,amount,account_id FROM statement where account_id="+"'"+statementRequest.getAccountId()+"'", new StatementRowMapper());
		LocalDate fromDate = format.parse(statementRequest.getFromDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate toDate = format.parse(statementRequest.getToDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		accountFilteredList=filter_statement_between_dates(fromDate,toDate,statementListconvertDtoList(statementList));	
	}catch(Exception e) {
		logger.error("AccountServiceImpl:getStatementbetweenDate:"+e.getMessage());	
	}
	return accountFilteredList;
	}

/**
 * ____________________________________________________________________________________________
 * 
 * @author : Albert
 * @MethodDesc : To get the statement between two amount
 * @File : AccountSatementServiceImpl.java
 * @CreatedDate : JUN 16, 2021
 * @ModifiedDate :
 * @input :StatementRequest
 * @return : List
 *         ______________________________________________________________________________________________
 */   
@Override
public List<StatementDto> getStatementbeetweenAmount(StatementRequest statementRequest){
	List<StatementDto> accountFilteredList=null;
	try {
	List<Statement> statementList=jdbcTemplate.query("SELECT ID,datefield,amount,account_id FROM statement where account_id="+"'"+statementRequest.getAccountId()+"'", new StatementRowMapper());
	accountFilteredList=statementListconvertDtoList(statementList).stream().filter(e->e.getAmount()>=Double.parseDouble(statementRequest.getFromAmount())&& e.getAmount()<=Double.parseDouble(statementRequest.getToAmount())).collect(Collectors.toList());
	}catch(Exception e) {
	logger.error("AccountServiceImpl:getStatementbeetweenAmount:"+e.getMessage());	
	}
	return accountFilteredList;
}
/**
 * ____________________________________________________________________________________________
 * 
 * @author : Albert
 * @MethodDesc : To get the statement between two amount
 * @File : AccountSatementServiceImpl.java
 * @CreatedDate : JUN 16, 2021
 * @ModifiedDate :
 * @input :StatementRequest
 * @return : List
 *         ______________________________________________________________________________________________
 */   
@Override
public List<StatementDto> getStatemenParamsNull() {
	
	List<StatementDto> accountFilteredList =null;
	try {
	 List<Statement> statementList=jdbcTemplate.query("SELECT ID,datefield,amount,account_id FROM statement", new StatementRowMapper());
	 List<StatementDto> dtoList= statementListconvertDtoList(statementList);
     dtoList.sort(Comparator.comparing(StatementDto::getDatefield));
     LocalDate maxDate = dtoList.stream().map(StatementDto::getDatefield).max(LocalDate::compareTo).get();
     logger.info("AccountServiceImpl:getStatemenParamsNull:"+maxDate);
     LocalDate enddate =findLastThreeMonth(maxDate);
     accountFilteredList = filter_statement_between_dates(enddate,maxDate,statementListconvertDtoList(statementList));	
	}catch(Exception e){
	logger.error("AccountServiceImpl:getStatemenParamsNull:"+e.getMessage());		
	}
	return accountFilteredList;
}

/**
 * ____________________________________________________________________________________________
 * 
 * @author : Albert
 * @MethodDesc : To get the statement between two amount and date
 * @File : AccountSatementServiceImpl.java
 * @CreatedDate : JUN 16, 2021
 * @ModifiedDate :
 * @input :StatementRequest
 * @return : List
 *         ______________________________________________________________________________________________
 */  
@Override
public List<StatementDto> getStatementdateandAmount(StatementRequest statementRequest){
	DateFormat format = new SimpleDateFormat("dd.MM.yyyy",Locale.ENGLISH);
	List<StatementDto> accountFilteredList=null;
	try {
	List<Statement> statementList=jdbcTemplate.query("SELECT ID,datefield,amount,account_id FROM statement where account_id="+"'"+statementRequest.getAccountId()+"'", new StatementRowMapper());
	LocalDate fromDate = format.parse(statementRequest.getFromDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	LocalDate toDate = format.parse(statementRequest.getToDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	accountFilteredList=filter_statement_between_dates(fromDate,toDate,statementListconvertDtoList(statementList)).stream().filter(e->e.getAmount()>=Double.parseDouble(statementRequest.getFromAmount())&& e.getAmount()<=Double.parseDouble(statementRequest.getToAmount())).collect(Collectors.toList());	
	}catch (Exception e) {
	logger.error("AccountServiceImpl:getStatementdateandAmount:"+e.getMessage());	
	}	
	return accountFilteredList;
}
/**
 * ____________________________________________________________________________________________
 * 
 * @author : Albert
 * @MethodDesc : generated staement convrted to dto list and string date  convert to Local date and string amount convert to double 
 * @File : AccountSatementServiceImpl.java
 * @CreatedDate : JUN 16, 2021
 * @ModifiedDate :
 * @input List
 * @return : List
 *         ______________________________________________________________________________________________
 */  
private List<StatementDto> statementListconvertDtoList(List<Statement> statements){
	DateFormat format = new SimpleDateFormat("dd.MM.yyyy",Locale.ENGLISH);
	List<StatementDto> dtoList=new ArrayList<>();
	try {
	   for (Statement statement : statements) {
		StatementDto dto=new StatementDto();
		dto.setID(statement.getID());
		dto.setAccount_id(statement.getAccount_id());
		dto.setAmount(Double.parseDouble(statement.getAmount()));
		dto.setDatefield(format.parse(statement.getDatefield()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		dtoList.add(dto);
	}
	}catch (ParseException e) {
	logger.error("AccountServiceImpl:statementListconvertDtoList:"+e.getMessage());	
	}
	return dtoList;
	
}
/**
 * ____________________________________________________________________________________________
 * 
 * @author : Albert
 * @MethodDesc : find last three month from the last inserted date 
 * @File : AccountSatementServiceImpl.java
 * @CreatedDate : JUN 16, 2021
 * @ModifiedDate :
 * @input :LocalDate
 * @return : LocalDate
 *         ______________________________________________________________________________________________
 */  
public LocalDate findLastThreeMonth(LocalDate maxDate) {
	 LocalDate currentDate = LocalDate.of(maxDate.getYear(),maxDate.getMonth(),maxDate.getDayOfMonth());//current date
	    logger.info("AccountServiceImpl:findLastThreeMonth:"+currentDate);  
	    int lastMonths = 3;//number of months
	    LocalDate prevDate = null;
	    LocalDate startDate = null;
	    LocalDate endDate = null;
	  try {
	  	    for(int i = 0; i < lastMonths; i++) {
	        if(prevDate == null) {
	        	startDate = currentDate.withDayOfMonth(1);//First day of current month
	        	endDate = currentDate.withDayOfMonth(currentDate.lengthOfMonth());//Last day of current month
	            prevDate = currentDate.minusMonths(1);//subtracting one month from current month 
	        } else {
	        	startDate = prevDate.withDayOfMonth(1);//First day of previous month
	        	endDate = prevDate.withDayOfMonth(prevDate.lengthOfMonth());//Last day of previous month
	            prevDate = prevDate.minusMonths(1);//subtracting one month from previous month
	        }
	     
	    }
	  }catch (Exception e) {
		  logger.error("AccountServiceImpl:findLastThreeMonth:"+e.getMessage());  
	}
	return endDate;
}
/**
 * ____________________________________________________________________________________________
 * 
 * @author : Albert
 * @MethodDesc : filter statement between dates 
 * @File : AccountSatementServiceImpl.java
 * @CreatedDate : JUN 16, 2021
 * @ModifiedDate :
 * @input :LocalDate,LocalDate,List
 * @return : List
 *         ______________________________________________________________________________________________
 */  
private List<StatementDto> filter_statement_between_dates(LocalDate fromDate, LocalDate toDate,
		List<StatementDto> accountFilteredList) {
	 List<StatementDto> filteredAccounts=null;
	try {
	Date startDate= Date.from(fromDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	Date endDate= Date.from(toDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	Predicate<StatementDto> checkDateBetween = (account) -> {
		Date accountDate = Date.from(account.getDatefield().atStartOfDay(ZoneId.systemDefault()).toInstant());
        return accountDate.getTime() >= startDate.getTime() &&
                accountDate.getTime() <= endDate.getTime();
    };
    filteredAccounts = accountFilteredList.stream()
            .filter(checkDateBetween)
            .collect(Collectors.toList());
	}catch (Exception e) {
	 logger.error("AccountServiceImpl:filter_statement_between_dates:"+e.getMessage());  
	}
	return filteredAccounts;	
}

}
