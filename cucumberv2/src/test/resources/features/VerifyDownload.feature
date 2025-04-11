
Feature: Verify download

Background: 

Given the browser environment is "chrome" and the page is "https://practice.expandtesting.com/download"

Scenario: verify download option
When the user click the url
Then verify if the file is present 
