# AMO.tech UI Automation Framework

A Java-based UI test automation project for [AMO.tech](https://amo.tech/), built with **Selenide**, **TestNG**, and **Maven**.

The project demonstrates the implementation of the Page Object Model (POM), UI navigation testing, and positive and negative vacancy search scenarios.

## Tech Stack

- **Java 21** — programming language
- **Selenide 7.19.0** — UI test automation framework built on Selenium WebDriver
- **TestNG 7.11.0** — test execution and lifecycle management
- **Maven** — dependency management and build automation
- **IntelliJ IDEA** — development environment

## Project Structure

```text
src
└── test
    └── java
        ├── pages
        │   ├── HomePage.java
        │   ├── Navbar.java
        │   └── CareerPage.java
        └── tests
            ├── HomePageTest.java
            ├── NavbarTest.java
            └── CareerSearchTest.java
```

## Implemented Tests

### Home Page
- Verify that the home page opens successfully.
- Verify navigation to the Life in AMO page.

### Navigation
- Verify navigation to About Us.
- Verify navigation to AMO Publishing.
- Verify navigation to Life in AMO.
- Verify navigation to Career.
- Verify switching the website language to Ukrainian.

### Career Vacancy Search
- **Positive scenario:** search for `General QA` and verify the `General QA Engineer, Amo Publishing` result.
- **Negative scenario:** search for a non-existing vacancy and verify that no results are returned.
- **Negative scenario:** enter random text and verify that no results are returned.

## Framework Design

The project follows the **Page Object Model (POM)** design pattern.

- **Page classes** encapsulate page elements and user interactions.
- **Test classes** contain test scenarios and assertions.
- **Selenide conditions** provide automatic waiting and verification of UI states.
- **CSS and XPath selectors** are used to locate web elements.
- **TestNG lifecycle annotations** manage browser configuration and page initialization before each test.

## Prerequisites

Make sure the following tools are installed:

- Java JDK 21
- Maven 3.9+ (or use the Maven Wrapper, if available)
- Google Chrome
- Git

## Running the Tests

Clone the repository:

```bash
git clone https://github.com/evolxtion/amo-test-selenide-testng.git
cd amo-test-selenide-testng
```

Run the test suite:

```bash
mvn clean test
```

To run a specific test class:

```bash
mvn -Dtest=NavbarTest test
```

For vacancy search tests:

```bash
mvn -Dtest=CareerSearchTest test
```

## Browser Configuration

Browser settings are configured through Selenide. The current test configuration uses Google Chrome in headed mode.

```java
Configuration.browser = "chrome";
Configuration.headless = false;
```

To run tests in headless mode, set `Configuration.headless = true`.

## Project Goals

This project was created as a practical demonstration of UI automation skills, including:

- Designing a maintainable test framework.
- Applying Page Object Model principles.
- Writing positive and negative UI test scenarios.
- Working with CSS and XPath locators.
- Validating navigation, page content, and search results.
- Using Java-based testing tools and Maven.

---