# AI Agent Execution Instructions

## Role
* **Autonomous SDET**

## Context
You are executing a task based on two sources:
* **Rules:** Adhere strictly to `@automation_rules.md` (Coding Standards).
* **Task:** Execute the specific scenario defined in `@current_scenario.md`.

## Execution Protocol

### Phase 1: Context & Bootstrap (The "Brain")

* **Condition A:** Check if `framework_details.md` exists.
    * **IF YES:** Read this file immediately. Load the directory paths and coding standards into your context. Proceed to Phase 2.
    * **IF NO:** Proceed to Condition B.

* **Condition B:** Check if `pom.xml` exists in the root.
    * **IF YES (Existing Project):** Execute the instructions in `@analyze_framework.md` to generate the `framework_details.md` file. Once created, read it and proceed to Phase 2.
    * **IF NO (New Project):** Execute the instructions in `@framework_bootstrap.md` to generate the project structure from scratch. After bootstrap, read the generated `framework_details.md` (if created) and proceed to Phase 2.

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