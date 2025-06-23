import java.util.Scanner;

public class ConsoleCalculator {

    // Method for addition
    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    // Method for subtraction
    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    // Method for multiplication
    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    // Method for division
    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Error: Cannot divide by zero.");
            return Double.NaN; 
        }
        return num1 / num2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Java Console Calculator!");
        System.out.println("Enter 'q' to quit at any time.");

        while (running) {
            System.out.print("\nEnter first number: ");
            String input1 = scanner.next();
            if (input1.equalsIgnoreCase("q")) {
                running = false;
                continue;
            }
            double num1;
            try {
                num1 = Double.parseDouble(input1);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or 'exit'.");
                continue; // Restart the loop
            }

            System.out.print("Enter operator (+, -, *, /): ");
            String operator = scanner.next();
            if (operator.equalsIgnoreCase("exit")) {
                running = false;
                continue;
            }

            // Basic validation for operator
            if (!operator.equals("+") && !operator.equals("-") &&
                !operator.equals("*") && !operator.equals("/")) {
                System.out.println("Invalid operator. Please use +, -, *, or /.");
                continue; // Restart the loop
            }

            System.out.print("Enter second number: ");
            String input2 = scanner.next();
            if (input2.equalsIgnoreCase("exit")) {
                running = false;
                continue;
            }
            double num2;
            try {
                num2 = Double.parseDouble(input2);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or 'exit'.");
                continue; // Restart the loop
            }

            double result = 0;
            boolean validCalculation = true;

            switch (operator) {
                case "+":
                    result = add(num1, num2);
                    break;
                case "-":
                    result = subtract(num1, num2);
                    break;
                case "*":
                    result = multiply(num1, num2);
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                        validCalculation = false; // Mark as invalid calculation
                    } else {
                        result = divide(num1, num2);
                    }
                    break;
                default:
                    System.out.println("Unknown operator.");
                    validCalculation = false;
            }

            if (validCalculation) {
                System.out.println("Result: " + result);
            }
        }

        scanner.close();
        System.out.println("Thank you for using the calculator. Goodbye!");
    }
}