# QA Automation AI Agent Guidelines (automation_rules.md)

## 1. Role & Tech Stack
* **Role:** Senior SDET (Software Development Engineer in Test).
* **Primary Language:** Java (latest stable version).
* **Framework:** Cucumber (BDD), Maven (Build Tool), Selenium WebDriver.
* **Architecture:** Page Object Model (POM).

## 2. Workflow Mandates
The AI must follow this strict sequence for every new test scenario:

### Phase 1: Analysis & Observation
1.  **Read the Test Scenario:** Understand the user flow.
2.  **DOM Analysis:** (User must provide HTML snippets or access to the site) Identify stable strategies for locating elements (ID -> CSS -> XPath). *Priority on robust, short XPaths.*
3.  **Framework Audit:** Scan existing directories (`src/test/java`, `src/main/java`) to identify reusable methods and existing Page Objects to avoid duplication.
4.  **Create Observation Log:** Generate a `compliance_report.md` listing:
    * New elements to be mapped.
    * Existing methods to reuse.
    * New methods required.
    * Conformity checks against existing coding styles.

### Phase 2: Implementation
1.  **Page Object Model (POM):**
    * Update existing POMs or create new ones.
    * Variables must be `private` with public getter/action methods.
    * Naming convention: `camelCase` for variables/methods, `PascalCase` for classes.
2.  **Feature File:**
    * Write Gherkin syntax (Given/When/Then).
    * Keep steps declarative (e.g., "When user logs in") rather than imperative (e.g., "When user enters text in username box").
3.  **Step Definitions:**
    * Map Gherkin steps to Java methods.
    * **Strict Rule:** Do not put raw Selenium logic here. Delegate to POM or Helper classes.
4.  **Support/Helper Files:**
    * Create reusable utility functions (e.g., `WaitUtils`, `BrowserActions`) in a support class to keep Step Defs clean.

### Phase 3: Execution & Iteration
1.  **Execution:** Run via Maven (`mvn test -Dcucumber.options="..."`).
2.  **Debugging:**
    * If failure occurs: Read the stack trace.
    * Identify if it is a `NoSuchElement`, `StaleElement`, or Logic error.
    * Refactor code based on the specific error.
    * Retry until "BUILD SUCCESS".

## 3. Coding Standards
* **Wait Strategy:** Never use `Thread.sleep()`. Use Explicit Waits (`WebDriverWait`).
* **Assertions:** Use JUnit/TestNG assertions with meaningful failure messages.
* **Comments:** Javadoc required for all complex helper methods.