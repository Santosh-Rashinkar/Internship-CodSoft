package com.codsoft.task1;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class NumberGame {

    // Maximum chances for each player
    static final int MAX_CHANCES = 5;
    static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("!!! Welcome To Our Guessing the Number Game !!!");
        System.out.println("\nRules : \n\t1) Each Player will get 5 chances to guess the number."
                + "\n\t2) For the last 2 chances, player will get 4 options to choose."
                + "\n\t3) Score will be posted after the final round.");

        System.out.println("\n\n<---------------------------- Let's Start The Game ---------------------------->");

        int roundsTaken = guessTheNumber(generateRandomNumber());

        System.out.println("\nYour Score is: " + calculateScore(roundsTaken));
        scan.close();
    }

    public static int guessTheNumber(int number) {
        int round = 1;
        int roundsTaken = 0;
        System.out.print("Enter your " + round + " guess: ");
        int guess;
        while (round <= MAX_CHANCES) {
            guess = getUserInput();
            if (round <= MAX_CHANCES - 2) {
                if (guess == number) {
                    System.out.println("!!!!!! Hurray! You guessed the right number.");
                    roundsTaken = round;
                    break;
                } else {
                    System.out.println("Oops! Wrong guess.\n");
                }
            } else {
                Set<Integer> options = generateOptions(number);
                System.out.println("Options for your next round are:");
                for (Integer n : options) {
                    System.out.println(" -> " + n);
                }
                if (guess == number) {
                    System.out.println("!!!!!! Hurray! You guessed the right number.");
                    roundsTaken = round;
                    break;
                } else {
                    System.out.println("Oops! Wrong guess.\n");
                }
            }
            round++;
            if (round <= MAX_CHANCES) {
                System.out.print("Enter your " + round + " guess: ");
            }
        }
        return roundsTaken;
    }

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1; // Generates a number between 1 and 100
    }

    public static Set<Integer> generateOptions(int number) {
        Set<Integer> options = new HashSet<>();
        options.add(number);
        Random random = new Random();
        while (options.size() < 4) {
            int randNum = random.nextInt(100) + 1;
            if (randNum != number) {
                options.add(randNum);
            }
        }
        return options;
    }

    public static int getUserInput() {
        while (true) {
            try {
                return Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }

    public static int calculateScore(int roundsTaken) {
        if (roundsTaken == 0) {
            return 0;
        }
        // Score calculation example: 100 - (roundsTaken * 10)
        return 100 - (roundsTaken * 10);
    }
}
