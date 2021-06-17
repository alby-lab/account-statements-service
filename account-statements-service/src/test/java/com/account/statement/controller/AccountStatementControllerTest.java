package com.account.statement.controller;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.account.statement.domain.ValidationResponse;
import com.account.statement.domain.StatementDto;
import com.account.statement.request.StatementRequest;
import com.account.statement.utils.ValidationMessage;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountStatementControllerTest {

	@Autowired
	AccountStatementController accountStatementController;

	@Test
	public void testStatementbetweenDateSuccess() throws Exception {
      StatementRequest requestInput=new StatementRequest();
      requestInput.setToDate("14.10.2020");
      requestInput.setAccountId(1);
      requestInput.setFromDate("01.07.2020");
      ResponseEntity<Object>response=accountStatementController.getStatementbetweenDate(requestInput);
      List<StatementDto>list= (List<StatementDto>) response.getBody();
      assertEquals(2, list.size());
        
    }
	@Test
	public void testStatementbetweenDateInvalidtoDate() throws Exception {
      StatementRequest requestInput=new StatementRequest();
      requestInput.setToDate("ab");
      requestInput.setAccountId(1);
      requestInput.setFromDate("01.07.2020");
      accountStatementController.getStatementbetweenDate(requestInput);
      ResponseEntity<Object>response=accountStatementController.getStatementbetweenDate(requestInput);
      ValidationResponse responseStatus= (ValidationResponse) response.getBody();
      assertEquals(ValidationMessage.DATE_FORMAT_ERROR.getMsg(),responseStatus.getMessage());
      assertEquals(HttpStatus.BAD_REQUEST.value(),responseStatus.getMsgStausCode());
        
    }
	@Test
	public void testStatementbetweenDateInvalidfromDate() throws Exception {
      StatementRequest requestInput=new StatementRequest();
      requestInput.setToDate("14.10.2020");
      requestInput.setAccountId(1);
      requestInput.setFromDate("cdd");
      ResponseEntity<Object>response=accountStatementController.getStatementbetweenDate(requestInput);
      ValidationResponse responseStatus= (ValidationResponse) response.getBody();
      assertEquals(ValidationMessage.DATE_FORMAT_ERROR.getMsg(),responseStatus.getMessage());
      assertEquals(HttpStatus.BAD_REQUEST.value(),responseStatus.getMsgStausCode());
        
    }	
	@Test
	public void testStatementbetweenDateInvalidAccount() throws Exception {
      StatementRequest requestInput=new StatementRequest();
      requestInput.setToDate("14.10.2020");
      requestInput.setAccountId(0);
      requestInput.setFromDate("01.07.2020");
      ResponseEntity<Object>response=accountStatementController.getStatementbetweenDate(requestInput);
      ValidationResponse responseStatus= (ValidationResponse) response.getBody();
      assertEquals(ValidationMessage.ACCOUNT_ERROR.getMsg(),responseStatus.getMessage());
      assertEquals(HttpStatus.BAD_REQUEST.value(),responseStatus.getMsgStausCode());
        
    }	
	@Test
	public void testStatementbetweenAmountSuccess() throws Exception {
      StatementRequest requestInput=new StatementRequest();
      requestInput.setAccountId(1);
      requestInput.setFromAmount("191.608098447429");
      requestInput.setToAmount("196.801905945903");
      ResponseEntity<Object>response=accountStatementController.getStatementbeetweenAmount(requestInput);
      List<StatementDto>list= (List<StatementDto>) response.getBody();
      assertEquals(2, list.size());
        
    }
	
	@Test
	public void testStatementbetweenAmountInvalidtoAmount() throws Exception {
      StatementRequest requestInput=new StatementRequest();
      requestInput.setAccountId(1);
      requestInput.setFromAmount("abc");
      requestInput.setToAmount("196.801905945903");
      ResponseEntity<Object>response=accountStatementController.getStatementbeetweenAmount(requestInput);
      ValidationResponse responseStatus= (ValidationResponse) response.getBody();
      assertEquals(ValidationMessage.AMT_EROR.getMsg(),responseStatus.getMessage());
      assertEquals(HttpStatus.BAD_REQUEST.value(),responseStatus.getMsgStausCode());
        
    }
	@Test
	public void testStatementbetweenAmountInvalidfromAmount() throws Exception {
      StatementRequest requestInput=new StatementRequest();
      requestInput.setAccountId(1);
      requestInput.setFromAmount("191.608098447429");
      requestInput.setToAmount("abc");
      ResponseEntity<Object>response=accountStatementController.getStatementbeetweenAmount(requestInput);
      ValidationResponse responseStatus= (ValidationResponse) response.getBody();
      assertEquals(ValidationMessage.AMT_EROR.getMsg(),responseStatus.getMessage());
      assertEquals(HttpStatus.BAD_REQUEST.value(),responseStatus.getMsgStausCode());
        
    }	
	@Test
	public void testStatementbetweenAmountInvalidAccount() throws Exception {
      StatementRequest requestInput=new StatementRequest();
      requestInput.setAccountId(0);
      requestInput.setFromAmount("191.608098447429");
      requestInput.setToAmount("196.801905945903");
      ResponseEntity<Object>response=accountStatementController.getStatementbeetweenAmount(requestInput);
      ValidationResponse responseStatus= (ValidationResponse) response.getBody();
      assertEquals(ValidationMessage.ACCOUNT_ERROR.getMsg(),responseStatus.getMessage());
      assertEquals(HttpStatus.BAD_REQUEST.value(),responseStatus.getMsgStausCode());
        
    }
	@Test
	public void testStatementbetweenDateandAmountSuccess() throws Exception {
      StatementRequest requestInput=new StatementRequest();
      requestInput.setToDate("14.10.2020");
      requestInput.setAccountId(1);
      requestInput.setFromAmount("191.608098447429");
      requestInput.setToAmount("196.801905945903");
      requestInput.setFromDate("01.07.2020");
      ResponseEntity<Object>response=accountStatementController.getStatementdateandAmount(requestInput);
      List<StatementDto>list= (List<StatementDto>) response.getBody();
      assertEquals(1, list.size());
        
    }
	@Test
	public void testStatementbetweenDateandAmountInvalidtoDate() throws Exception {
      StatementRequest requestInput=new StatementRequest();
      requestInput.setToDate("ab");
      requestInput.setAccountId(1);
      requestInput.setFromAmount("191.608098447429");
      requestInput.setToAmount("196.801905945903");
      requestInput.setFromDate("01.07.2020");
      accountStatementController.getStatementbetweenDate(requestInput);
      ResponseEntity<Object>response=accountStatementController.getStatementdateandAmount(requestInput);
      ValidationResponse responseStatus= (ValidationResponse) response.getBody();
      assertEquals(ValidationMessage.DATE_FORMAT_ERROR.getMsg(),responseStatus.getMessage());
      assertEquals(HttpStatus.BAD_REQUEST.value(),responseStatus.getMsgStausCode());
        
    }
	@Test
	public void testStatementbetweenDateandAmountInvalidfromDate() throws Exception {
      StatementRequest requestInput=new StatementRequest();
      requestInput.setToDate("14.10.2020");
      requestInput.setAccountId(1);
      requestInput.setFromDate("cdd");
      requestInput.setFromAmount("191.608098447429");
      requestInput.setToAmount("196.801905945903");
      ResponseEntity<Object>response=accountStatementController.getStatementdateandAmount(requestInput);
      ValidationResponse responseStatus= (ValidationResponse) response.getBody();
      assertEquals(ValidationMessage.DATE_FORMAT_ERROR.getMsg(),responseStatus.getMessage());
      assertEquals(HttpStatus.BAD_REQUEST.value(),responseStatus.getMsgStausCode());
        
    }	
	@Test
	public void testStatementbetweenDateandAmountInvalidAccount() throws Exception {
      StatementRequest requestInput=new StatementRequest();
      requestInput.setToDate("14.10.2020");
      requestInput.setAccountId(0);
      requestInput.setFromDate("01.07.2020");
      requestInput.setFromAmount("191.608098447429");
      requestInput.setToAmount("196.801905945903");
      ResponseEntity<Object>response=accountStatementController.getStatementdateandAmount(requestInput);
      ValidationResponse responseStatus= (ValidationResponse) response.getBody();
      assertEquals(ValidationMessage.ACCOUNT_ERROR.getMsg(),responseStatus.getMessage());
      assertEquals(HttpStatus.BAD_REQUEST.value(),responseStatus.getMsgStausCode());
        
    }	
	@Test
	public void testStatementbetweenDateandAmountInvalidtoAmount() throws Exception {
      StatementRequest requestInput=new StatementRequest();
      requestInput.setAccountId(1);
      requestInput.setFromAmount("abc");
      requestInput.setToAmount("196.801905945903");
      requestInput.setToDate("14.10.2020");
      requestInput.setFromDate("01.07.2020");
      ResponseEntity<Object>response=accountStatementController.getStatementdateandAmount(requestInput);
      ValidationResponse responseStatus= (ValidationResponse) response.getBody();
      assertEquals(ValidationMessage.AMT_EROR.getMsg(),responseStatus.getMessage());
      assertEquals(HttpStatus.BAD_REQUEST.value(),responseStatus.getMsgStausCode());
        
    }
	@Test
	public void testStatementbetweenDateandAmountInvalidfromAmount() throws Exception {
      StatementRequest requestInput=new StatementRequest();
      requestInput.setAccountId(1);
      requestInput.setFromAmount("191.608098447429");
      requestInput.setToAmount("abc");
      requestInput.setToDate("14.10.2020");
      requestInput.setFromDate("01.07.2020");
      ResponseEntity<Object>response=accountStatementController.getStatementdateandAmount(requestInput);
      ValidationResponse responseStatus= (ValidationResponse) response.getBody();
      assertEquals(ValidationMessage.AMT_EROR.getMsg(),responseStatus.getMessage());
      assertEquals(HttpStatus.BAD_REQUEST.value(),responseStatus.getMsgStausCode());
        
    }
	@Test
	public void testStatemenParamsNull() throws Exception {
      StatementRequest requestInput=new StatementRequest();
      ResponseEntity<Object>response=accountStatementController.getStatemenParamsNull(requestInput);
      List<StatementDto>list= (List<StatementDto>) response.getBody();
      assertEquals(2, list.size());
        
    }		
	
}
