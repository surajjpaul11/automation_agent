# Automation Agent Project Documentation

This project is an AI-powered automation testing framework built with Java, Maven, Cucumber, and Selenium WebDriver. The project uses a Page Object Model (POM) architecture with keyword-driven testing patterns.

## Documentation Files Overview

This project contains several markdown documentation files that guide the AI agent's behavior and provide protocols for different aspects of test automation. Below is an explanation of each file:

---

### `agent_instruction.md`
**Purpose:** Main execution protocol for the AI agent acting as an Autonomous SDET.

**Contents:**
- Defines the agent's role and execution workflow
- Outlines a 4-phase process:
  1. **Context & Bootstrap** - Framework initialization and analysis
  2. **Discovery** - Scenario analysis and element mapping using Selenium MCP
  3. **Implementation** - Code generation (Feature files, Page Objects, Step Definitions)
  4. **Verification** - Test execution and self-correction loop
- Provides decision logic for handling existing vs. new projects
- Establishes the self-correction mechanism (up to 3 retry attempts)

**When to use:** This is the primary instruction file that the AI agent should follow when executing any automation task.

---

### `automation_rules.md`
**Purpose:** Coding standards and workflow mandates for QA automation development.

**Contents:**
- Defines the tech stack (Java, Cucumber, Maven, Selenium)
- Establishes strict workflow sequence:
  - Phase 1: Analysis & Observation
  - Phase 2: Implementation (POM, Feature files, Step Definitions)
  - Phase 3: Execution & Iteration
- Coding standards:
  - No `Thread.sleep()` - use Explicit Waits
  - Page Object Model requirements
  - Naming conventions (camelCase for methods, PascalCase for classes)
  - Step definitions must delegate to POM/Helper classes (no raw Selenium)

**When to use:** Reference this file when writing or reviewing automation code to ensure compliance with project standards.

---

### `analyze_framework.md`
**Purpose:** Protocol for analyzing existing automation frameworks and generating a configuration map.

**Contents:**
- Instructions for auditing an existing project structure
- 4-phase analysis process:
  1. Tech Stack Identification (build tools, BDD frameworks, test runners)
  2. Structural Mapping (feature files, step definitions, page objects locations)
  3. Pattern Recognition (naming conventions, dependency injection patterns)
  4. Generate Output (`framework_details.md` file)
- Template for creating the `framework_details.md` output file

**When to use:** Execute this protocol when working with an existing project that doesn't have a `framework_details.md` file yet.

---

### `framework_bootstrap.md`
**Purpose:** Protocol for creating a new automation framework from scratch.

**Contents:**
- Defines the target tech stack (Java 17+, Maven, Cucumber 7+, JUnit 5, Selenium)
- Mandates exact directory structure following Page Object Model
- Specifies package organization:
  - `base` - BasePage, TestBase
  - `config` - ConfigurationManager
  - `keywords` - Custom UI Actions (Keyword-driven layer)
  - `pages` - Page Objects
  - `utils` - Loggers, FileReaders
  - `runners` - TestRunner
  - `steps` - Step Definitions
  - `hooks` - Cucumber Hooks

**When to use:** Follow this protocol when initializing a brand new automation project.

---

### `current_scenario.md`
**Purpose:** Configuration file defining the current test scenario to be automated.

**Contents:**
- Target URL for the application under test
- Scenario name
- Step-by-step description of the user flow to be automated

**When to use:** Update this file when starting a new automation scenario. The AI agent reads this file to understand what needs to be automated.

---

### `debugging_protocol.md`
**Purpose:** Systematic approach for debugging failing test scenarios.

**Contents:**
- Defines debugging loop workflow:
  1. **Reproduction** - Execute failing test and capture stack trace
  2. **Root Cause Analysis** - Categorize errors:
     - Type A: Selector Change (NoSuchElementException)
     - Type B: Timing/Stability (StaleElementReference)
     - Type C: Logic/Assertion Error
  3. **Remediation** - Apply targeted fixes based on error type
  4. **Verification** - Re-run and validate fix
- Requires adherence to `automation_rules.md` standards
- Outputs fixes to `fix_log.md`

**When to use:** Follow this protocol when tests fail and need debugging. Ensures systematic, non-destructive fixes.

---

### `run_and_debug.md`
**Purpose:** Protocol for executing existing tests and performing self-healing fixes.

**Contents:**
- 5-phase workflow:
  1. **Target Identification** - Identify test tag or feature file
  2. **Execution** - Run Maven test command
  3. **Failure Analysis** - Deep context analysis of failures
  4. **Remediation** - Apply fixes based on error categorization
  5. **Verification Loop** - Re-run until success (max 3 attempts)
- Uses Selenium MCP for UI inspection when selectors fail
- Maintains code standards during fixes

**When to use:** Use this protocol when running and debugging existing test scenarios. More detailed than `debugging_protocol.md` with specific MCP tool usage.

---

### `testing.md`
**Purpose:** Self-healing protocol for ensuring generated code compiles and tests pass.

**Contents:**
- 3-phase process:
  1. **Dependency Audit** - Check imports and pom.xml dependencies
  2. **Execution** - Run tests with Maven
  3. **Debug Loop** - Fix errors iteratively (max 3 retries)
- Handles common failure types:
  - StaleElement/NoSuchElement → Update XPath using Selenium MCP
  - AssertionError → Fix logic in Step Definitions
- Success criteria: "BUILD SUCCESS" with "Tests run: 1, Failures: 0"

**When to use:** Follow this protocol after generating new automation code to ensure it compiles and executes successfully.

---

## Workflow Integration

These documentation files work together in a specific sequence:

1. **Starting a New Project:** `framework_bootstrap.md` → `framework_details.md` (generated)
2. **Working with Existing Project:** `analyze_framework.md` → `framework_details.md` (generated)
3. **Executing a Scenario:** `agent_instruction.md` → `current_scenario.md` → `automation_rules.md`
4. **Debugging Failures:** `run_and_debug.md` or `debugging_protocol.md` → `testing.md`

## Key Principles

- **No Thread.sleep()** - Always use Explicit Waits (`WebDriverWait`)
- **Page Object Model** - Separate page logic from step definitions
- **Keyword-Driven** - Use helper/keyword classes for reusable actions
- **Self-Healing** - AI agent automatically fixes common issues (up to 3 attempts)
- **Standards Compliance** - All code must follow `automation_rules.md`

## Project Structure

```
automation_agent/
├── src/
│   ├── main/java/com/automation/qa/
│   │   ├── base/          # BasePage, TestBase
│   │   ├── config/         # ConfigurationManager
│   │   ├── keywords/       # BrowserActions, ElementActions
│   │   ├── pages/          # Page Objects (LoginPage, ProductsPage, etc.)
│   │   └── utils/          # Logger utilities
│   └── test/
│       ├── java/com/automation/qa/
│       │   ├── runners/    # TestRunner
│       │   ├── steps/      # Step Definitions
│       │   └── hooks/      # Cucumber Hooks
│       └── resources/
│           └── features/   # .feature files
├── pom.xml                 # Maven dependencies
└── [documentation files]   # All .md files
```

