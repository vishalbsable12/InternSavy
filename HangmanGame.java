package org.example;

import java.util.Scanner;
import java.util.Random;

public class HangmanGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"hangman", "computer", "java", "internship","Sholay", "Eclipse", "BMW", "Cricket", "Google"};
        String wordToGuess = words[new Random().nextInt(words.length)];
        int maxAttempts = 5;
        int attempts = 0;
        StringBuilder guessedWord = new StringBuilder();
        for (int i = 0; i < wordToGuess.length(); i++) {
            guessedWord.append("_");
        }

        StringBuilder guessedLetters = new StringBuilder();

        while (attempts < maxAttempts && guessedWord.toString().contains("_")) {
            displayHangman(attempts, guessedWord.toString());
            System.out.println("Guessed word: " + guessedWord);
            System.out.println("Guessed letters: " + guessedLetters);
            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);

            if (guessedLetters.indexOf(String.valueOf(guess)) != -1) {
                System.out.println("You already guessed that letter!");
                continue;
            }

            guessedLetters.append(guess);

            boolean guessedCorrectly = false;

            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    guessedWord.setCharAt(i, guess);
                    guessedCorrectly = true;
                }
            }

            if (!guessedCorrectly) {
                attempts++;
            }
        }

        displayHangman(attempts , guessedWord.toString () );
        System.out.println("Guessed word: " + guessedWord);

        if (guessedWord.toString().equals(wordToGuess)) {
            System.out.println("Congratulations! You guessed the word: " + wordToGuess);
        } else {
            System.out.println("Sorry, you're out of attempts. The word was: " + wordToGuess);
        }

        scanner.close();
    }

    public static void displayHangman ( int attempts , String string ) {
        String[] hangman = {
                "   _____",
                "   |   |",
                "       |",
                "       |",
                "       |",
                "       |",
                "========="
        };

        switch (attempts) {
            case 1:
                hangman[2] = "   O   |";
                break;
            case 2:
                hangman[3] = "   |   |";
                break;
            case 3:
                hangman[3] = "  /|   |";
                break;
            case 4:
                hangman[3] = "  /|\\  |";
                break;
            case 5:
                hangman[4] = "  /    |";
                break;
            default:
                break;
        }

        for (String line : hangman) {
            System.out.println(line);
        }

        if (attempts == 0) {
            if ("hangman".equals(getCurrentWord())) {
                System.out.println("Game");
            } else if ("computer".equals(getCurrentWord())) {
                System.out.println("Guess the devices");
            }
            else if ("java".equals(getCurrentWord())) {
                System.out.println("Guess the Programming Language");
            }
            else if ("internship".equals(getCurrentWord())) {
                System.out.println("Guess the Certificate");
            }
            else if ("Sholay".equals(getCurrentWord())) {
                System.out.println("Guess the devices");
            }
            else if ("Eclipse".equals(getCurrentWord())) {
                System.out.println("Guess the IDE");
            }
            else if ("BMW".equals(getCurrentWord())) {
                System.out.println("Guess the Car");
            }
            else if ("Cricket".equals(getCurrentWord())) {
                System.out.println("Guess the Indian Popular Game");
            }
            else if ("Google".equals(getCurrentWord())) {
                System.out.println("Guess the Search Engine");
            }
        }
    }

    public static String getCurrentWord ( ) {
        String[] words = {"hangman", "computer", "java", "internship","Sholay", "Software", "Farrari", "Runner", "Google"};
        return words[new Random().nextInt(words.length)];

    }
}
