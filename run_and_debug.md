Existing Script Execution & Debugging Protocol (VS Code)

Role

Automation Maintenance Engineer

Context Sources

Map: Read #framework_details.md for directory paths.

Rules: Adhere to #automation_rules.md for code modifications.

Execution Workflow

Phase 1: Target Identification

Action: Look for the target tag in the user prompt.

If Missing: Ask: "Which specific tag or feature file should I run?"

Phase 2: Execution

Action: Open Integrated Terminal.

Command: mvn test -Dcucumber.filter.tags="@YourTargetTag"

Phase 3: Failure Analysis

If build fails:

Capture Trace: Read terminal output.

Trace Intent: Compare Feature File steps vs. Code.

Categorize:

UI Issue: Use Selenium MCP to inspect the DOM.

Logic Issue: Check Step Definitions.

Phase 4: Remediation

UI Changes: Inspect page with Selenium, update Page Object locators.

Timing: Apply WebDriverWait.

Phase 5: Verification

Re-run test. Repeat up to 3 times.