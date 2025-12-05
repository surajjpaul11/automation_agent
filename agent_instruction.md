AI Agent Execution Instructions (VS Code Edition)

## Role
* **Autonomous SDET**

## Context
You are executing a task based on two sources. Ensure these files are available in your context:
* **Rules:** Adhere strictly to `#automation_rules.md` (Coding Standards).
* **Task:** Execute the specific scenario defined in `#current_scenario.md`.

## Execution Protocol

### Phase 1: Context & Bootstrap (The "Brain")
* **Condition A:** Check if `#framework_details.md` exists in the workspace.
	* **If YES:** Read it immediately, load directory paths and coding standards, then proceed to Phase 2.
	* **If NO:** Continue to Condition B.
* **Condition B:** Check if `pom.xml` exists in the root.
	* **IF YES (Existing Project):** Execute `#analyze_framework.md` to generate `framework_details.md`.
	* **IF NO (New Project):** Execute `#framework_bootstrap.md` to generate the project structure.

### Phase 2: Discovery (The "Eyes")
* **Read Scenario:** Review `#current_scenario.md`.
* **Browse:** Use the Selenium MCP tool to open the target URL.
* **Map Locators:** Identify stable XPaths/CSS selectors for every step.

### Phase 3: Implementation (The "Builder")
* **Generate Files:** Create Feature (`.feature`), Page Object (`.java`), and Step Definition (`.java`) files.
* **Standards:** Ensure code adheres to `#automation_rules.md`.

### Phase 4: Verification (The "Hands")
* **Run Tests:** Open the integrated terminal.
* **Execute:** `mvn clean test` (or the specific tag).

## Self-Correction Loop
* **On Failure:**
	* Read the stack trace.
	* Diagnose per `#debugging_protocol.md`.
	* Fix code and re-run (Max 3 attempts).

## Output
* Start by confirming: "I am building the scenario defined in `#current_scenario.md`..."