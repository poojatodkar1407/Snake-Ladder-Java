package com.bridgelabz.snakeandladder;

import java.util.Random;

public class SnakeAndLadder {
    static final int INITIAL_POSITION = 0;
    static final int NO_PLAY = 0;
    static final int LADDER = 1;
    static final int SNAKE = 2;
    static final int WIN_POSITION = 3;
    static int playerPosition = INITIAL_POSITION;

    static int turn = 0;
    static int rollDieCounter = 0;
    static int firstPlayerPosition = INITIAL_POSITION;
    static int secondPlayerPosition = INITIAL_POSITION;

    private static int rollDie() {

        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    private static void repeatTillPlayerReachGoal() {

        Random random = new Random();
        int option = random.nextInt(3);
        int randomDieMove = rollDie();
        rollDieCounter++;
        if (option == NO_PLAY) {
            playerPosition = playerPosition;
            System.out.println("Player its a foult so no changes to the current position" + playerPosition);
        } else if (option == LADDER) {
            playerPosition += randomDieMove;
            System.out.println("Congrats!! Player you advanced to: " + randomDieMove + " positions" + playerPosition);
        } else if (option == SNAKE) {
            if (playerPosition > randomDieMove) {
                playerPosition -= randomDieMove;
            } else {
                playerPosition = 0;
            }
            System.out.println("oops!! Player you step on a snake so you will go back to " + randomDieMove + " step back" + playerPosition);
        }
        System.out.println("The total number of dice rolled is: " + rollDieCounter);
    }

    private static void playGame() {

        while (playerPosition != WIN_POSITION) {
            if (turn == 0) {
                playerPosition = firstPlayerPosition;
                repeatTillPlayerReachGoal();
                firstPlayerPosition = playerPosition;
                turn = 1;
            } else {
                playerPosition = secondPlayerPosition;
                repeatTillPlayerReachGoal();
                secondPlayerPosition = playerPosition;
                turn = 0;
            }
        }
        checkWinner();
    }

    private static void checkWinner() {

        if (firstPlayerPosition == WIN_POSITION) {
            System.out.println("Player one Win");
        } else {
            System.out.println("Player two Win");
        }
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Snake and Ladder");
        playGame();
    }

}
