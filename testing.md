Automated Testing & Self-Healing Protocol

Objective: Ensure the generated code compiles, dependencies are installed, and the test scenario passes.

Phase 1: Dependency Audit (The "Plumber")

Scan Imports: Check the .java files you just created.

Check POM: specificially look for missing dependencies in pom.xml (e.g., webdrivermanager, selenium-java, cucumber-junit, assertj).

Install: If pom.xml was modified or dependencies are missing, open the Integrated Terminal and run:
mvn clean install -DskipTests

Verify Build: Ensure the "BUILD SUCCESS" message appears. If compilation fails, fix the syntax errors immediately.

Phase 2: Execution (The "Runner")

Run Command: Open the terminal and run the test for the specific scenario:
mvn test -Dcucumber.filter.tags="@YourTag"
(Note: Replace @YourTag with the tag defined in the Feature file).

Phase 3: The Debug Loop (The "Healer")
IF the test fails, you must enter this loop (Max 3 retries):

Read Error: Analyze the stderr / stack trace.

StaleElement / NoSuchElement? -> Use Selenium MCP to re-inspect the DOM and update the XPath.

AssertionError? -> Check the logic in Step Definitions.

Fix: Edit the code.

Retry: Run the mvn test command again.

Success Criteria:
Stop ONLY when you see "BUILD SUCCESS" and "Tests run: 1, Failures: 0".