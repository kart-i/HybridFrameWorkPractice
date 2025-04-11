
Feature: Login Feature

Background: 

   Given the browser environment is "chrome" and the page is "https://www.saucedemo.com"
 
  
Scenario Outline: Positive Scenario 1 - user should be redirected to products page on entering valid credentials
   
   When the user enters <username> and <password> and click login 
   Then verify if the user is redirected to products page
   Examples: 
   |username     |password    |    
   |standard_user|secret_sauce| 
   
      
   
Scenario Outline: Negative Scenario 1 - Throw error on clicking login with invalid username

   When the user enters <username> and <password> and click login 
   Then verify if the error is displayed
    
    
Examples: 
  |username| password |     
  |karthi|secret_sauce| 
      
Scenario Outline: Negative Scenario 2 - Throw error on clicking login with invalid password

   When the user enters <username> and <password> and click login 
   Then verify if the error is displayed
    
    
Examples: 
  |username     |password |     
  |standard_user|invalid| 

Scenario Outline: Negative Scenario 3 - Throw error on clicking login with invalid username and invalid password

   When the user enters <username> and <password> and click login 
   Then verify if the error is displayed
    
    
Examples: 
  |username  | password |     
  |invalid|invalid| 


Scenario Outline: Negative Scenario 4 - Throw error on clicking login with empty username

   When the user enters <username> and <password> and click login 
   Then verify if the error is displayed
    
    
Examples: 
  |username  | password |     
  |""|secret_sauce| 


Scenario Outline: Negative Scenario 5 - Throw error on clicking login with empty password

   When the user enters <username> and <password> and click login 
   Then verify if the error is displayed
    
    
Examples: 
  |username  | password |     
  |standard_user|""| 

Scenario Outline: Negative Scenario 6 - Throw error on clicking login with empty username and password

  When the user enters <username> and <password> and click login 
  Then verify if the error is displayed
    
    
Examples: 
  |username|password|     
  |""|""| 




    
