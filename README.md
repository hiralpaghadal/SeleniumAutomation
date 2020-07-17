# SeleniumAutomation
Step 1:  Creating a new Java Project SeleniumAutomation. 

Step 2:  Installing the TestNG software in the Eclipse. 

Step 3:  Adding the External Selenium Jar files in the Configure Build Path.

Step 4:  Adding the JUnit 4 library by clicking on Build Path ->Configure Build Path-> Add library.  

Step 5: Adding the TestNG library by clicking on Build Path ->Configure Build Path-> Add library.   

Step 6: Creating a package com.application 


Step 7: Creating a java class AutomateTheWebApplication
Step 8: Download the chromedriver.exe file for the respective OS and copy that .exe file into local drive. 
The path of the chromedriver (D:\\cdd\\chromedriver.exe) will be used in our program.

Step 9:  Setting a system property "webdriver.chrome.driver" to the path of ChromeDriver.exe file and instantiate a ChromeDriver class. 

Step 10: Using @BeforeMethod , the @BeforeMethod annotated method will be invoked before the execution of each test method where the test method is nothing but a test case.
@BeforeMethod contains the code for launching the website. 
There are three Test methods in the class 

1)	registrationTest()
2)	loginTest()
3)	searchingandAddingToCartTest()
All the test cases are responsible for automating the functionalities. 

 @AfterMethod annotated method will be invoked after the execution of each test method. 
 Here there are three test methods means that @AfterMethod annotated method will be executed three times. 
 @Aftermethod contains the code for quitting the browser. 
 
Step 11: For Running the Project right click on the project and Run as TestNG

Step 12: Refresh Project And the test-output folder will be created. 

Step 13: Checking the Chrome HTML Document(.html) Report generated under the test-output folder.

  
Conclusion : 
> Registration form, login, search bar, and add-to-cart automation using Selenium WebDriver and TestNG
> Handle invalid logins and showed appropriate error messages in the console
> Fetched the test reports over HTML
