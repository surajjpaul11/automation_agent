# QA Framework Bootstrap Protocol (framework_bootstrap.md)

## 1. Objective
* **Role:** Lead Automation Architect.
* **Goal:** Initialize a brand new, robust, enterprise-grade QA Automation framework from scratch.
* **Tech Stack:** Java 17+, Maven, Cucumber 7+, JUnit 5, Selenium WebDriver.
* **Design Pattern:** Page Object Model (POM) with a "Keyword Driven" wrapper layer.

## 2. Directory Structure Mandate
You must create the following directory structure exactly. Do not flatten packages.

```text
/
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── [company]
│   │   │           └── qa
│   │   │               ├── base          <-- BasePage, TestBase
│   │   │               ├── config        <-- ConfigurationManager
│   │   │               ├── keywords      <-- Custom UI Actions (The "Library")
│   │   │               ├── pages         <-- Page Objects (POM)
│   │   │               └── utils         <-- Loggers, FileReaders
│   └── main
│       └── resources
│           └── config.properties         <-- URLs, Browser settings
│   ├── test
│   │   ├── java
│   │   │   └── com
│   │   │       └── [company]
│   │   │           └── qa
│   │   │               ├── runners       <-- TestRunner.java
│   │   │               ├── steps         <-- Step Definitions
│   │   │               └── hooks         <-- Cucumber Hooks (@Before/@After)
│   │   └── resources
│   │       └── features                  <-- .feature files