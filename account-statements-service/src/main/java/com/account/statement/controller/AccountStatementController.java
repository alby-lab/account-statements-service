package com.account.statement.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.statement.domain.ValidationResponse;
import com.account.statement.request.StatementRequest;
import com.account.statement.service.AccountStatementService;
import com.account.statement.utils.StatementUtils;
import com.account.statement.utils.ValidationMessage;

@RestController
@RequestMapping("/account")
@Component
public class AccountStatementController {

	@Autowired
	AccountStatementService accountService;

	/**
	 * ____________________________________________________________________________________________
	 * 
	 * @author : Albert
	 * @MethodDesc : to get statement between Date 
	 * @File : AccountStatementController.java
	 * @CreatedDate : JUN 16, 2021
	 * @ModifiedDate :
	 * @input :StatementRequest
	 * @return : List
	 *         ______________________________________________________________________________________________
	 */
	@PostMapping("statementbetweendate")
	public  ResponseEntity<Object> getStatementbetweenDate(@RequestBody StatementRequest statementRequest) {
		ValidationResponse responseStatus=new ValidationResponse();
         if(!StatementUtils.isValidAccountId(statementRequest.getAccountId())) {
         	responseStatus.setMessage(ValidationMessage.ACCOUNT_ERROR.getMsg());
         	responseStatus.setMsgStausCode(HttpStatus.BAD_REQUEST.value());
         	return new ResponseEntity<>(responseStatus,HttpStatus.OK);		
         }else if(!StatementUtils.isValidAmount(statementRequest.getFromDate())||!StatementUtils.isValidAmount(statementRequest.getToDate())){
         	responseStatus.setMessage(ValidationMessage.DATE_FORMAT_ERROR.getMsg());
         	responseStatus.setMsgStausCode(HttpStatus.BAD_REQUEST.value());
         	return new ResponseEntity<>(responseStatus,HttpStatus.OK);		
         }else {
         	return new ResponseEntity<>(accountService.getStatementbetweenDate(statementRequest),HttpStatus.OK);	 	
         }
	}
	/**
	 * ____________________________________________________________________________________________
	 * 
	 * @author : Albert
	 * @MethodDesc : to get statement between amount 
	 * @File : AccountStatementController.java
	 * @CreatedDate : JUN 16, 2021
	 * @ModifiedDate :
	 * @input :StatementRequest
	 * @return : List
	 *         ______________________________________________________________________________________________
	 */
	@PostMapping("statementbetweenamount")
	public ResponseEntity<Object> getStatementbeetweenAmount(@RequestBody StatementRequest statementRequest) {
		    ValidationResponse responseStatus=new ValidationResponse();
            if(!StatementUtils.isValidAccountId(statementRequest.getAccountId())) {
            	responseStatus.setMessage(ValidationMessage.ACCOUNT_ERROR.getMsg());
            	responseStatus.setMsgStausCode(HttpStatus.BAD_REQUEST.value());
            	return new ResponseEntity<>(responseStatus,HttpStatus.OK);		
            }else if(!StatementUtils.isValidAmount(statementRequest.getFromAmount())||!StatementUtils.isValidAmount(statementRequest.getToAmount())){
            	responseStatus.setMessage(ValidationMessage.AMT_EROR.getMsg());
            	responseStatus.setMsgStausCode(HttpStatus.BAD_REQUEST.value());
            	return new ResponseEntity<>(responseStatus,HttpStatus.OK);		
            }else {
            	return new ResponseEntity<>(accountService.getStatementbeetweenAmount(statementRequest),HttpStatus.OK);	 	
            }
		
	}
	/**
	 * ____________________________________________________________________________________________
	 * 
	 * @author : Albert
	 * @MethodDesc : to get statement between amount and date
	 * @File : AccountStatementController.java
	 * @CreatedDate : JUN 16, 2021
	 * @ModifiedDate :
	 * @input :StatementRequest
	 * @return : List
	 *         ______________________________________________________________________________________________
	 */
	@PostMapping("statementbetweendateandamount")
	public ResponseEntity<Object> getStatementdateandAmount(@RequestBody StatementRequest statementRequest) {
		ValidationResponse responseStatus=new ValidationResponse();
        if(!StatementUtils.isValidAccountId(statementRequest.getAccountId())) {
        	responseStatus.setMessage(ValidationMessage.ACCOUNT_ERROR.getMsg());
        	responseStatus.setMsgStausCode(HttpStatus.BAD_REQUEST.value());
        	return new ResponseEntity<>(responseStatus,HttpStatus.OK);		
        }else if(!StatementUtils.isValidAmount(statementRequest.getFromAmount())||!StatementUtils.isValidAmount(statementRequest.getToAmount())){
        	responseStatus.setMessage(ValidationMessage.AMT_EROR.getMsg());
        	responseStatus.setMsgStausCode(HttpStatus.BAD_REQUEST.value());
        	return new ResponseEntity<>(responseStatus,HttpStatus.OK);		
        }else if(!StatementUtils.isValidAmount(statementRequest.getFromDate())||!StatementUtils.isValidAmount(statementRequest.getToDate())) {
        	responseStatus.setMessage(ValidationMessage.DATE_FORMAT_ERROR.getMsg());
        	responseStatus.setMsgStausCode(HttpStatus.BAD_REQUEST.value());
        	return new ResponseEntity<>(responseStatus,HttpStatus.OK);			
        }
        else{
        	return new ResponseEntity<>(accountService.getStatementdateandAmount(statementRequest),HttpStatus.OK);	 	
        }
	}
	/**
	 * ____________________________________________________________________________________________
	 * 
	 * @author : Albert
	 * @MethodDesc : generate request if request parameters are null
	 * @File : AccountStatementController.java
	 * @CreatedDate : JUN 16, 2021
	 * @ModifiedDate :
	 * @input :StatementRequest
	 * @return : List
	 *         ______________________________________________________________________________________________
	 */
	@PostMapping("statementbynoparams")
	public  ResponseEntity<Object> getStatemenParamsNull(@RequestBody StatementRequest statementRequest) {
		return new ResponseEntity<>(accountService.getStatemenParamsNull(),HttpStatus.OK);	 
	
	}
}
