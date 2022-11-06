# SeleniumWebAutomation

This framework is developed by using Page object model with testNG framework written in java.

CODE STRUCTURE:

1- all test cases are defined in src/test/java/Tests class.

2- all pages object are defined in src/main/java/pages package.

3- all listeners (i.e before suite, before methods) are defined in the src/main/java/listeners class.

4- webdriver configurations, thread safety and driver getter are defined in the src/main/java/driver package.

5- all reuseable functions for the Webelements are defined in src/main/java/commons/Functions class.

6- all reuseable Assertions for the Webelements are defined in src/main/java/commons/CommonAssertions class.

7- all types of reuseable waits for the Webelements are defined in src/main/java/commons/Waits class.

8- all report configuration and setup are defined in src/main/java/reports package.

9- common utilities like taking screenshots and reading values from the property file are defined in src/main/java/utils package.

10- project properties like URL, are defined in the Project.properties file under src/main/resources.


RUN TEST CASE:

In order to run the test cases the class name and test method will be provided in the testng.xml file. 
The test will be run through testng.xml file.

After the test has been run a report will be generated which contains information about the passed and failed test cases. In case the test has failed 
a snapshot of that web page will be taken and attached with report along with failure logs. The report could be found under /Web/Selenium/reports.

