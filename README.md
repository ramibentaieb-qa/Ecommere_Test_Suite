[![Selenium Java CI with Maven](https://github.com/ramibentaieb-qa/Ecommere_Test_Suite/actions/workflows/maven.yml/badge.svg)](https://github.com/ramibentaieb-qa/Ecommere_Test_Suite/actions/workflows/maven.yml)

# Ecommerce test suite

I built this project to learn test automation. It tests the demo shop at https://automationexercise.com/ using Java, Selenium and TestNG.

I'm still learning, so some parts are rough. I list them below. If you see something that could be better, please tell me.

## What it tests

- Signup, login, logout and delete account
- Negative login with a wrong email and password
- Negative signup with an invalid email and with missing fields
- Adding products to the cart and removing them
- Quantity and price checks in the cart
- Checkout: delivery and billing address, total amount, payment and the "Order Placed!" message
- Downloading the invoice and checking the customer name and total inside it

## Tools

- Java 25
- Maven
- Selenium 4.50.0
- TestNG 7.12.0
- Gson, which reads the signup test data from a JSON file
- GitHub Actions, which runs the tests on every push

## How it is organized

- `src/main`: the page objects (one class per page) and helper classes for waits, dropdowns, JavaScript, alerts and downloads.
- `src/test`: the tests, grouped in `auth` and `products`. It also has the base test that opens and closes the browser, the test data classes, and a listener that takes a screenshot when a test fails.
- `src/test/resources`: the TestNG suite files and the test data in `testdata/signup_data.json`.

I used the Page Object pattern, so the tests read like steps and the locators stay in the page classes.

## How to run

You need Java 25, Maven and Chrome. Edge is optional.

- All tests: `mvn test`
- One test class: `mvn test -Dtest=CheckoutTest`
- Without a browser window: add `-Dheadless=true`
- Chrome and Edge: `mvn test -Dsurefire.suiteXmlFiles=src/test/resources/cross-browser.xml`

In IntelliJ you can also right-click a test and run it. In Windows PowerShell, put quotes around each `-D` option that has a dot in it, like `"-Dsurefire.suiteXmlFiles=src/test/resources/cross-browser.xml"`.

Tests that need an account from `SignupTest` must run in the same run as `SignupTest`.

## Reports and CI

When a test fails, a screenshot is saved in `target/screenshots`. On GitHub Actions the same screenshots are uploaded with the failed run.

The workflow runs the whole suite in headless Chrome.

## Things I know are not great yet

- The tests are not fully independent. `LoginTest`, `ProductTest` and `DeleteAccountTest` need `SignupTest` to run first, because they use the account it creates. `DeleteAccountTest` has to run last, because it deletes that account.
- The checkout test logs in with one account I made by hand. Its email and password are in a small `TestUsers` class.
- One fixed pause is left, a 4 second wait after each test. I plan to remove it.
- The driver is shared between the page objects, so tests cannot run in parallel.
- There is no HTML test report, only the screenshots and the console output.
- Ad blocking works only in Chrome. In Edge, an ad can still get in the way.
- It tests the live website, so a change on the site can break a test.
- The account from `SignupTest` stays on the site if `DeleteAccountTest` does not run.

## What I want to do next

- Make each test run on its own.
- Remove the last fixed pause.
- Add a test report.
- Run tests in parallel.
- Add more tests: search, product details and the contact form.

## Feedback

Suggestions and code reviews are welcome. You can open an issue or message me on GitHub.