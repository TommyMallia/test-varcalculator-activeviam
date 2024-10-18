# VaR Calculator

**Description:**

A Java application to calculate Value at Risk (VaR) for single trades and portfolios. VaR is a measure of potential losses over a specified period, given a certain confidence level. This application is built specifically for the historical method with room to add other methods.

**Technologies:**

- Java
- Maven (for project management and dependency management)
- JUnit (for unit testing)

**Installation:**

1. **Clone the repository:** </br>
git clone <https://github.com/TommyMallia/test-varcalculator-activeviam>

2. **Build the project:** </br>
cd var-calculator </br>
mvn clean install

3. **Run the application:** </br>
java -jar target/var-calculator.jar

**Usage:**

The application will prompt you for the following input:

Confidence level: Enter the desired confidence level (e.g. 95, 97, 99). </br>
Trade number: Enter which trade you want to calculate the VaR for (1, 2 or 3). </br>
The application will then calculate and display the VaR for both the individual trade and the entire portfolio.


Tommy Mallia
