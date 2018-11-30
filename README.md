# sample-galen-tests
A set of experimental tests used to test [Sample Galen Framework](http://testapp.galenframework.com) basic functionalities:
- Verify successful login
- Verify a new note is created successfully

## Limitations and Know Issues
- Only Chrome is supported. Other browsers will be supported later
- Not thread-safe handling, don't execute tests concurrently

## Requirements
- [maven](https://maven.apache.org/)
- [Chrome](https://www.google.com/chrome/)

## How to run tests
- Checkout this project
- (Not recommended) Adjust `email` and `password` from  `src\test\resources\configuration.properties` accordingly based on the newest authenticated information from http://testapp.galenframework.com
- On either Command Line (Windows) or Terminal (macOS/ Linux), execute maven command to run tests: `mvn clean test`. It will execute all tests at the same time

## Acknowledgement
[webdrivermanager](https://github.com/bonigarcia/webdrivermanager) to help initalizinng the latest version of Selenium WebDriver
