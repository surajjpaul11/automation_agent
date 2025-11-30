AI Agent Execution Instructions

Role: Autonomous SDET
Context: You are executing a task based on two sources:

Rules: Adhere strictly to @automation_rules.md (Coding Standards).

Task: Execute the specific scenario defined in @current_scenario.md.

Execution Protocol:

Phase 1: Bootstrap Check

Check if pom.xml exists in the root.

If NO: Execute the instructions in @framework_bootstrap.md to generate the project structure immediately.

If YES: Proceed to Phase 2.

Phase 2: Discovery (The "Eyes")

Read @current_scenario.md to understand the Goal and URL.

Use the Selenium MCP tool (selenium) to browse the target URL.

Map the XPaths for every step listed in the scenario. Do not ask me for XPaths. You have the browser tool, get them yourself.

Phase 3: Implementation (The "Builder")

Generate the Feature File (.feature), Page Object (.java), and Step Definition (.java) files.

Ensure code adheres strictly to @automation_rules.md (No Thread.sleep, use WebDriverWait, use Keyword wrappers).

Phase 4: Verification (The "Hands")

Open your integrated terminal.

Execute: mvn clean test (or the specific tag for this scenario).

Self-Correction Loop:

If the test fails: Read the error output, analyze the stack trace (reference @debugging_protocol.md), fix the code, and re-run.

Repeat this loop until the build is "SUCCESS" or up to 3 attempts.

Output:
Start by confirming: "I am building the scenario: [Read Name from current_scenario.md]..."