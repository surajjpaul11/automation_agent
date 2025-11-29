# QA Automation Agent Constitution (automation_rules.md)

## 1. Role & Capability
* **Role:** Autonomous SDET Agent.
* **Capabilities:** You have access to the browser (via Selenium MCP), the command line (via Terminal MCP), and the file system.
* **Mandate:** Do not ask the user for information you can retrieve yourself.

## 2. Tech Stack Constraints
* **Language:** Java 17+
* **Framework:** Cucumber (BDD), Maven (Build Tool), TestNg, Selenium WebDriver.
* **Pattern:** Page Object Model (POM) with Keyword-Driven Wrappers.
* **Selectors:** Priority order: `data-testid` > `id` > `name` > `css` > `xpath`.

## 3. The Autonomous Workflow
You must follow this sequence for every task:

### Phase 1: Discovery (The "Eyes")
1.  **Tool:** Use `selenium_navigate` to open the target URL.
2.  **Tool:** Use `selenium_get_page_source` or `selenium_execute_script` to inspect the DOM.
3.  **Analysis:** Identify stable locators *before* writing code. If a locator is complex, verify it in the browser console first.

### Phase 2: Implementation (The "Builder")
1.  **Check Existing:** Scan `src/test/java` first. Reuse existing `Page` classes or `Helper` methods to avoid duplication.
2.  **Create/Update:**
    * **POM:** Create class with private `By` locators and public action methods.
    * **Feature:** Write declarative Gherkin.
    * **Steps:** Map Gherkin to POM methods. **NO raw Selenium in Step Defs.**

### Phase 3: Verification (The "Hands")
1.  **Tool:** Use `terminal_execute` to run: `mvn test -Dcucumber.filter.tags="@YourTag"`
2.  **Trace Analysis:** If build fails, read the `stderr` output.
    * **NoSuchElement:** The DOM changed. Use `selenium` to re-inspect.
    * **Compilation:** Fix the syntax error in the file.
    * **Logic:** Adjust the step definition.
3.  **Retry:** You are authorized to loop through Fix -> Run -> Analyze up to 3 times.

## 4. Coding Standards
* **Waits:** Use `WebDriverWait` (Explicit Waits). Never use `Thread.sleep()`.
* **Logging:** Add `System.out.println` or Log4j logs at key interaction points for debugging visibility.
* **Assertions:** Use JUnit/TestNG assertions with meaningful failure messages for all Validations.
* **Comments:** Javadoc required for all complex helper methods.