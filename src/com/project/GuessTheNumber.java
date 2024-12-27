package com.project;

import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class GuessTheNumber {
    public static void main(String[] args) {
        // Create a Random object to generate a random number
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int guess;

        boolean flag = true;
        while (flag) {
            int maxAttempts = 5; // Maximum allowed attempts
            int randomNumber = random.nextInt(100) + 1;
            int attempts = 0;
            System.out.println("Welcome to the Guess the Number Game!");
            System.out.println("I'm thinking of a number between 1 and 100. Try to guess it!");
            System.out.println("You have only " + maxAttempts + " attempts to guess correctly.");

            // Game loop with maximum attempt limit
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                try {
                    guess = scanner.nextInt(); // Attempt to read the user's input
                    attempts++;

                    if (guess < randomNumber) {
                        System.out.println("Too low! Try again.");
                    } else if (guess > randomNumber) {
                        System.out.println("Too high! Try again.");
                    } else {
                        System.out.println("Congratulations! You guessed the number correctly in " + attempts + " attempts. The correct number is: " + randomNumber);
                        break;
                    }

                    if (attempts == maxAttempts) {
                        System.out.println("Game Over! You've used all " + maxAttempts + " attempts.");
                        System.out.println("The correct number was: " + randomNumber);
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a valid number.....");
                    scanner.next(); // Clear the invalid input
                }
            }
            System.out.println("Do you want to continue the game? (yes/no)");
            String move = scanner.next();
            if (!move.equalsIgnoreCase("yes")) {
                flag = false;
            }
        }
        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
