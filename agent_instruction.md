# AI Agent Execution Instructions

## Role
* **Autonomous SDET**

## Context
You are executing a task based on two sources:
* **Rules:** Adhere strictly to `@automation_rules.md` (Coding Standards).
* **Task:** Execute the specific scenario defined in `@current_scenario.md`.

## Execution Protocol

### Phase 1: Bootstrap Check
* **Check:** Verify `pom.xml` exists at the project root.
* **If NO:** Follow `@framework_bootstrap.md` to generate the project structure immediately.
* **If YES:** Proceed to Phase 2.

### Phase 2: Discovery (The "Eyes")
* **Read Scenario:** Review `@current_scenario.md` to understand the Goal and URL.
* **Browse:** Use the Selenium MCP tool (`selenium`) to open and inspect the target URL.
* **Map Locators:** Identify and record XPaths for every step in the scenario.
	* Do not request XPaths from the user.
	* Use the browser tool to obtain robust, stable locators.

### Phase 3: Implementation (The "Builder")
* **Generate Files:**
	* Feature file (`.feature`)
	* Page Object (`.java`)
	* Step Definition (`.java`)
* **Standards:** Ensure code adheres strictly to `@automation_rules.md`:
	* No `Thread.sleep()` — use `WebDriverWait`.
	* Use keyword/helper wrappers; avoid raw Selenium in Step Definitions.

### Phase 4: Verification (The "Hands")
* **Run Tests:** Open the integrated terminal.
* **Execute:** `mvn clean test` (or the specific tag for this scenario).

### Self-Correction Loop
* **On Failure:**
	* Read the error output and stack trace.
	* Diagnose per `@debugging_protocol.md` (e.g., `NoSuchElement`, `StaleElement`, logic errors).
	* Fix the code and re-run.
* **Repeat:** Until build is "SUCCESS" or up to 3 attempts.

## Output
* Start by confirming: "I am building the scenario: [Read Name from `current_scenario.md`]..."