# account-statements-service

Pre-requisite:
   Java 1.8
   Spring boot
   Maven 
Git clone url- https://github.com/alby-lab/account-statements-service.git
After clone the project change data base location in application.properties (spring.datasource.url=jdbc:ucanaccess://C:/Users/Alby/Desktop/Nagarro/JavaTest/accountsdb.accdb;openExclusive=false;ignorecase=true;)

Swagger UI is used to test , base url of swagger is below 

http://localhost:8084/v1/api/account-statement-service/swagger-ui.html#/account-statement-controller 

login credential 
      user name -admin          password - admin
      user name -user           password - user  

4 REST Api are created 
               generate satement between two date 
			        input - accout_id,fromdate,todate (other fields keep as null)
					out put- JSON list  
               generate satement between two amount
			        input - accout_id,froAmount,toAmount(other fields keep as null)
					out put- JSON list  
               generate satement between date and amount 
			        input - accout_id,froAmount,toAmount,romdate,todate
					out put- JSON list
               generate statement from last updated date to three months back statement.
	             All fields keep as null
				 out put- JSON list
				 
Validation 
    Datefield and amount should allow number and dot operation 
    invalid date 
	    out put - message and httpstatus code bad request (400)
    invalid amount 
       out put - message and httpstatus code bad request(400)
    invalid Account id 
      	out put - message and httpstatus code bad request(400)
	
How to test 
   start the application 
   open the swagger url via browser 
   click account-statement-controller in the UI 
   All API urls will be listed in the UI 
   Click each URL 
   click try it out button fron right corner of the UI 
   give your inputs on the fields 
   click execute button 
		
Note: Access control features could not be implemented due to time constraints. I also had to do office work. 
