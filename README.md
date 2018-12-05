# sample-galen-tests
A set of experimental tests used to test [Sample Galen Framework](http://testapp.galenframework.com) basic functionalities:
- Verify successful login
- Verify a new note is created successfully

## Limitations and Know Issues
- Only popular browsers such as Chrome and Firefox is supported. Other browsers (Internet Explorer, Safari, etc...) will be supported later
- Not thread-safe handling, don't execute tests concurrently

## Requirements & Installation
- [maven](https://maven.apache.org/install.html)
- [Chrome](https://www.google.com/chrome/)
- [Firefox](https://www.mozilla.org/en-US/firefox/new/)

## How to run tests
- Checkout this project
- (Not recommended) Adjust `email` and `password` from  `src\test\resources\configuration.properties` accordingly based on the newest authenticated information from http://testapp.galenframework.com
- Open [TestNG.xml](https://github.com/zazrashima/sample-galen-tests/blob/master/TestNG.xml) and change [browser](https://github.com/zazrashima/sample-galen-tests/blob/c9c7b9bc1a8230f684338998f89b6e99d6001d73/TestNG.xml#L3) to Firefox if you would like to execute tests on Firefox, otherwise default executor will be Chrome
- On either Command Line (Windows) or Terminal (macOS/ Linux), execute maven command to run tests: `mvn clean test`. It will execute all tests at the same time

## Acknowledgement
[webdrivermanager](https://github.com/bonigarcia/webdrivermanager) to help initializing the latest version of Selenium WebDriver
