package com.account.statement.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.account.statement.request.StatementRequest;

public class StatementUtils {
	
	public static boolean isValidAmount(String str) {
		 if (str == null ||str.isEmpty()) {
	            return false;
	        }else {
	        String regex = "[0-9.]+";
	        Pattern p = Pattern.compile(regex);
	        Matcher m = p.matcher(str);
	        return  m.matches();
	        }
	
	}
	public static boolean isValidAccountId(long accountId) {
		 if (accountId == 0) {
	            return false;
	        }
		return true;
	
	}
}
