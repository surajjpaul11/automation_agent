# QA Automation Debugging Protocol (debugging_protocol.md)

## 1. Role & Objective
* **Role:** Senior SDET / Debugging Specialist.
* **Objective:** Identify root causes of failures in *existing* scenarios and implement minimal, non-destructive fixes.
* **Standards:** You must still adhere to the coding standards defined in `automation_rules.md` (e.g., naming conventions, no Thread.sleep).

## 2. The Debugging Loop (MCP Workflow)
The Agent must follow this strict loop until the test passes.

### Step 1: Reproduction (Terminal MCP)
1.  **Action:** Execute the specific failing test using Maven.
    * Command template: `mvn test -Dcucumber.options="classpath:features/YourFeature.feature --tags @YourTag"`
2.  **Observation:** Capture the **full stack trace** from the terminal output.

### Step 2: Root Cause Analysis (RCA)
Analyze the stack trace and categorize the error:
* **Type A: Selector Change (NoSuchElementException):** The UI changed, but the XPath is old.
    * *Action:* Use `selenium-mcp` to inspect the current page and update the XPath in the POM.
* **Type B: Timing/Stability (StaleElementReference / ElementNotInteractable):** The script is too fast.
    * *Action:* Check if an Explicit Wait is missing in the POM or Helper class.
* **Type C: Logic/Assertion Error:** The app behavior doesn't match the test expectation.
    * *Action:* Compare the Feature File Step expectation vs. the actual app value.

### Step 3: Remediation (File Edit)
1.  **Locate:** Find the exact file causing the trace (look for line numbers in `src/test/java`).
2.  **Fix:** Apply the fix *only* to the broken method.
    * *Constraint:* Do NOT rewrite the entire file. Do NOT change logic that isn't broken.
    * *Constraint:* If changing a common Helper method, ensure it won't break other tests.

### Step 4: Verification
1.  **Re-run:** Execute the Maven command again.
2.  **Success Condition:** "BUILD SUCCESS".
3.  **Failure Condition:** If it fails again, compare the new stack trace to the old one. If the error changed, you made progress. Repeat the loop.

## 3. Output Requirement
After the fix, append a note to `fix_log.md` with:
* Test Scenario Name.
* The Error encountered.
* The Fix applied.