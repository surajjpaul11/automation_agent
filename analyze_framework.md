# Framework Analysis Protocol

## Role
* **Senior Automation Architect**

## Objective
Audit the current project structure and generate a configuration map.

## Output Target
Create a new file named `framework_details.md` in the root directory.

## Phase 1: Tech Stack Identification
* **Scan Root:** Inspect root directory files to determine core technology.
* **Build Tool:** Look for `pom.xml` (Maven) or `build.gradle` (Gradle).
* **Language:** Identify the primary language (Java, Python, TS) based on file extensions in `src`.
* **Dependencies:** Read the build file to identify:
	* **BDD Framework:** Cucumber, SpecFlow.
	* **Test Runner:** JUnit 4/5, TestNG.
	* **Automation Library:** Selenium, Playwright, RestAssured.
	* **Assertion Library:** AssertJ, Hamcrest.

## Phase 2: Structural Mapping
Scan the `src` directory to locate key components. Do not guess; use file evidence.
* **Feature Files:** Locate the directory containing `.feature` files.
* **Step Definitions:** Locate Java classes that contain `@Given`, `@When`, `@Then` annotations.
* **Page Objects:** Locate classes that represent web pages (look for `@FindBy` or `By` locators).
* **Test Runner:** Find the class annotated with `@RunWith(Cucumber.class)` or `@Suite`.
* **Utilities:** Identify helper folders (e.g., `utils`, `helper`, `support`) containing WebDriver initialization or config readers.
* **Configuration:** Locate `.properties`, `.conf`, or `.yaml` files used for environment settings.

## Phase 3: Pattern Recognition
Read 1-2 files from the Step Definitions and Page Objects folders to understand the coding style.
* **Naming Convention:** Are pages named `LoginPage.java` or `LoginPO.java`?
* **Dependency Injection:** Is state shared via `TestContext`, PicoContainer, or static variables?
* **Wait Strategy:** Is the project using `Thread.sleep`, Explicit Waits, or `FluentWait`?

## Phase 4: Generate Output
Write the findings into `framework_details.md` using this exact template:

# Framework Configuration Map

## Tech Stack
* **Language:** [e.g., Java 17]
* **Build Tool:** [e.g., Maven]
* **Test Engine:** [e.g., JUnit 5]
* **BDD:** [e.g., Cucumber 7.x]

## Directory Map
* **Features:** `[Path, e.g., src/test/resources/features]`
* **Step Definitions:** `[Path, e.g., src/test/java/com/org/steps]`
* **Page Objects:** `[Path, e.g., src/main/java/com/org/pages]`
* **Test Runner:** `[Path to file]`
* **Config File:** `[Path to file]`

## Coding Standards (Detected)
* **Naming:** [Describe convention]
* **DI Pattern:** [Describe how state is shared]
* **Wait Strategy:** [Describe wait pattern]