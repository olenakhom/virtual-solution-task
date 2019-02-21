# Coding challenge

The task is to use the Base base class and to use the WebDriver object to search for "Active sync" using Selenium \
in Google. Then the first link should be clicked. Focus should be on scalability and coding style.


### Instruments were used
1. [Java](https://www.oracle.com/java/)
2. [Maven](https://maven.apache.org/)
3. [Selenium WebDriver](https://www.seleniumhq.org/projects/webdriver/)
4. [TestNg](https://testng.org)
5. [Allure](http://allure.qatools.ru/)

### Required installation
1. [Java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
2. [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download)
3. [Allure commandline for generation test report](https://docs.qameta.io/allure/#_installing_a_commandline)

### IntelliJ IDEA settings
1. Open File --> New --> Project from Version control --> Git
2. Clone from repository URL https://github.com/olenakhom/freeletics-technical-assignment.git
3. Open File --> Project Structure --> Project
4. Select java version 1.8 from Project SDK dropdown
5. Select 8-Lambdas, annotations from Project language level dropdown
6. Open File --> Project Structure --> Modules
7. Select 8-Lambdas, annotations Language level on Source tab


### Test Execution
Run tests from command line (maven installation is required)
```
mvn clean -U -DtestngFile=test-suite.xml -DpropFile=application.properties test
```
or
run tests from embedded maven command line from IntelliJ IDEA (Execute Maven Goal button)
```
clean -U -DtestngFile=test-suite.xml -DpropFile=application.properties test
```

### Allure test report generation
This is already enough to see the Allure report in one command:
```
allure serve /home/path/to/project/allure-results
```
If report generated successfully, report page should be opened automatically in browser:
![Allure Report](src/test/resources/allure_report.png?raw=true "Allure Report Example")
