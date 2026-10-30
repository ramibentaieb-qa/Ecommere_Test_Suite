[![Selenium Java CI with Maven](https://github.com/ramibentaieb-qa/Ecommere_Test_Suite/actions/workflows/maven.yml/badge.svg)](https://github.com/ramibentaieb-qa/Ecommere_Test_Suite/actions/workflows/maven.yml)

# Ecommerce test suite

I built this project to learn test automation. It tests the demo shop at https://automationexercise.com/ using Java, Selenium and TestNG.

I'm still learning, so some parts are rough. I list those below. If you see something that could be better, please tell me.

## What it tests

- Signup, login, logout and delete account
- Negative login with a wrong email and password
- Negative signup with an invalid email and with missing fields
- Adding products to the cart and removing them
- Quantity and price checks in the cart
- Checkout: delivery and billing address, total amount, payment and the "Order Placed!" message

## Tools

- Java 25
- Maven
- Selenium 4.50.0
- TestNG 7.12.0
- Gson (reads the signup test data from a JSON file)

## How it is organized

- `src/main`: the page objects (one class per page) and a few helper classes for waits, dropdowns, JavaScript and alerts.
- `src/test`: the tests, grouped in `auth` and `products`, plus the base test that opens and closes Chrome.
- `src/test/resources`: `testng.xml` and the test data in `testdata/signup_data.json`.

I used the Page Object pattern, so the tests read like steps and the locators stay in the page classes.

## How to run

You need Java 25, Maven and Chrome.

1. Clone the repo.
2. Open `src/test/resources/testng.xml` and list the test classes you want to run.
3. Run `mvn test`, or right-click a test in IntelliJ and press run.

## Things I know are not great yet

- The tests are not fully independent. `LoginTest`, `DeleteAccountTest` and `ProductTest` need `SignupTest` to run first, because they use the account it creates.
- The checkout test logs in with one account I made by hand. The email and password are written inside the test.
- A few places still use fixed waits (`delay`) instead of proper waits.
- The driver is shared between the page objects, so tests cannot run in parallel.
- It only runs on Chrome.
- There are no screenshots on failure and no test report.
- It checks the site's live data, so a change on the website can break a test.
- The delete account test is the only one that cleans up after itself. The other tests leave accounts on the site.

## What I want to do next

- Make each test run on its own.
- Replace the fixed waits.
- Add screenshots on failure and a report.
- Run on Chrome and Edge, and in parallel.
- Add more tests: search, product details and the contact form.
- Run the suite on GitHub Actions.

## Feedback

Suggestions and code reviews are welcome. You can open an issue or message me on GitHub.