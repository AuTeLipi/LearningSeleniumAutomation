# 🚀 Selenium 4.35 Web Automation Learning Repository

[![Selenium](https://img.shields.io/badge/Selenium-4.35-green.svg)](https://selenium.dev/)
[![Java](https://img.shields.io/badge/Java-11+-orange.svg)](https://openjdk.java.net/)
[![TestNG](https://img.shields.io/badge/TestNG-Latest-blue.svg)](https://testng.org/)
[![Maven](https://img.shields.io/badge/Maven-3.6+-red.svg)](https://maven.apache.org/)



## 📚 About This Repository

This repository contains comprehensive learning materials and practical implementations of **Selenium 4.35 Web Automation** concepts. It serves as a complete guide for mastering web automation testing using modern Selenium practices, design patterns, and best practices.



## 🎯 Learning Objectives

By the end of this learning journey, you will master:
- Modern Selenium 4.35 WebDriver architecture and capabilities
- Advanced locator strategies (XPath, CSS Selectors, Relative Locators)
- Page Object Model and Page Factory design patterns
- Cross-browser and parallel testing
- Cloud testing with BrowserStack and AWS
- Data-driven testing with Apache POI
- Selenium Grid setup and configuration
- Jenkins CI/CD integration


## 🏗️ Repository Structure

```
selenium-4.35-learning/
├── src/
│   ├── main/java/
│   │   ├── pages/              # Page Object Model classes
│   │   ├── utils/              # Utility classes (ExcelReader, PropertyReader)
│   │   └── base/               # Base test classes and configurations
│   └── test/java/
│       ├── tests/              # Test classes organized by functionality
│       ├── assignments/        # Practice assignments and solutions
│       └── advanced/           # Advanced concepts implementation
├── src/test/resources/
│   ├── testdata/              # Excel files and test data
│   ├── config/                # Configuration files
│   └── drivers/               # Browser drivers (if needed)
├── reports/                   # Allure and other test reports
└── README.md
```


## 🛠️ Tech Stack 
### Core Technologies:
- **Java 11+** - Programming language
- **Selenium WebDriver 4.35** - Web automation framework
- **TestNG** - Testing framework
- **Maven** - Build and dependency management
- **Allure** - Test reporting

### Additional Libraries:
- **Apache POI** - Excel file handling for data-driven testing
- **Log4j2** - Logging framework
- **WebDriverManager** - Automatic driver management


## 📖 Learning Modules

### Module 1: Selenium Fundamentals
- WebDriver Architecture & Browser Driver Setup
- WebDriver Interface vs Implementation
- Navigation Commands (get, navigate, back, forward)

### Module 2: Element Interaction & Locators
- **Locator Strategies**: ID, Name, Class, CSS Selectors, XPath
- **Element Operations**: findElement/findElements, getText, getAttribute
- **Advanced Locators**: XPath Functions, Axes, CSS Advanced Patterns

### Module 3: Selenium Waits & Synchronization
- Implicit, Explicit, and Fluent Waits
- Expected Conditions implementation

### Module 4: Advanced Web Elements
- Dropdown, Alert, Checkbox, Radio Button Handling
- Web Tables (Static and Dynamic)
- File Upload scenarios

### Module 5: Browser Interactions
- Actions Class (Mouse/Keyboard events)
- Window and iFrame Handling
- JavaScript Executor

### Module 6: Modern Web Technologies
- SVG Elements and Shadow DOM
- Relative Locators (Selenium 4.x)
- Dynamic Elements handling

### Module 7: Framework Design Patterns
- Page Object Model and Page Factory
- Data-Driven Testing with Apache POI
- Property Reader and Logging

### Module 8: Grid & Cloud Testing
- Selenium Grid 4 (Standalone, Hub-Node, Distributed)
- Docker Integration and Cloud Testing

### Module 9: CI/CD & DevOps
- Jenkins Integration and AWS Setup
- Parallel and Cross-browser Testing


## 🌐 Browser Support Matrix

| Browser | Supported OS | Maintained by | Driver Required |
|---------|--------------|---------------|-----------------|
| Chrome/Chromium | Windows/macOS/Linux | Google | ChromeDriver |
| Firefox | Windows/macOS/Linux | Mozilla | GeckoDriver |
| Edge | Windows/macOS/Linux | Microsoft | EdgeDriver |
| Safari | macOS High Sierra+ | Apple | SafariDriver |


## 📊 Test Execution

### Local Execution:
```bash
# Run all tests
mvn test

# Run with specific browser
mvn test -Dbrowser=chrome

# Parallel execution
mvn test -Dparallel=true -DthreadCount=2
```

### Selenium Grid:
```bash
# Standalone mode
java -jar selenium-server-4.15.0.jar standalone

# Hub and Node
java -jar selenium-server-4.15.0.jar hub
java -jar selenium-server-4.15.0.jar node --detect-drivers
```

## 📈 Reporting

### Allure Reports
```bash
# Generate and serve reports
mvn allure:report
mvn allure:serve
```

**Report Features**: Test execution summary, Pass/Fail statistics, Screenshots on failures, Detailed step logs, Execution timelines


## 🎓 Best Practices Implemented

### Code Quality:
- **Clean Code Principles** - Readable and maintainable code
- **SOLID Principles** - Object-oriented design
- **Thread Safety** - Parallel execution support

### Testing Practices:
- **Independent Tests** - No test dependencies
- **Data-Driven Approach** - Externalized test data
- **Proper Wait Strategies** - Avoiding Thread.sleep()
- **Exception Handling** - Robust error management

## ⚠️ Known Limitations

### When NOT to Use Selenium?
- **Performance/Load Testing** - Resource intensive
- **Native Mobile Apps** - Use Appium instead
- **CAPTCHA/2FA** - Human interaction required
- **Audio/Video Streaming** - Not designed for media testing
- **API Testing** - Use REST Assured instead


## 🔗 Useful Resources

### Documentation:
- [Selenium Official Documentation](https://selenium.dev/documentation/)
- [W3C WebDriver Specification](https://www.w3.org/TR/webdriver/)
- [TestNG Documentation](https://testng.org/doc/)

### Tools & Extensions:
- [SelectorsHub](https://selectorshub.com/) - Advanced locator generation
- [ChroPath](https://chrome.google.com/webstore/detail/chropath/ljngjbnaijcbncmcnjfhigebomdlkcjo) - XPath helper

### Practice Sites:
- [The Internet Herokuapp](https://the-internet.herokuapp.com/) - Selenium practice scenarios
- [AwesomeQA WebTable](https://awesomeqa.com/webtable.html) - Table handling practice
- [VWO Demo](https://app.vwo.com/) - Real application testing

## 📝 Progress Tracking

### Completed Modules
- [ ] Module 1: Selenium Fundamentals
- [ ] Module 2: Element Interaction & Locators
- [ ] Module 3: Selenium Waits & Synchronization
- [ ] Module 4: Advanced Web Elements
- [ ] Module 5: Browser Interactions
- [ ] Module 6: Modern Web Technologies
- [ ] Module 7: Framework Design Patterns
- [ ] Module 8: Grid & Cloud Testing
- [ ] Module 9: CI/CD & DevOps


### ✨ Author: Lipi Dubbaka

- [LinkedIn](https://www.linkedin.com/in/lipidubbaka)

---

### 🤖 Selenium + AI = Testing Superpowers Unlocked! ⚡
> *"Intelligence is the ability to adapt to change."* - Stephen Hawking

