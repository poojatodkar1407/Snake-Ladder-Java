package com.bridgelabz.snakeandladder;

import java.util.Random;

public class SnakeAndLadder {

    static final int INITIAL_POSITION = 0;
    static final int NUMBER_OF_PLAYER = 1;
    static final int NO_PLAY = 0;
    static final int LADDER = 1;
    static final int SNAKE = 2;
    static final int WIN_POSITION = 4;

    private static int rollDie() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    private static int moveCondition(int playerPosition, int randomDieMove) {
        if (playerPosition <= 0) {
            playerPosition = INITIAL_POSITION;
        } else if (playerPosition == WIN_POSITION) {
            System.out.println("Player Win : "+playerPosition);
        } else if (playerPosition >= WIN_POSITION) {
            playerPosition = playerPosition - randomDieMove;
        }
        return playerPosition;
    }

    private static void repeatTillPlayerReachGoal() {

        Random random = new Random();
        int playerPosition = INITIAL_POSITION;
        while (playerPosition <= WIN_POSITION) {
            int option = random.nextInt(3);
            int randomDieMove = rollDie();
            if (option == NO_PLAY) {
                playerPosition = playerPosition;
                System.out.println("Player its a foult so no changes to the current position");
            } else if (option == LADDER) {
                playerPosition += randomDieMove;
                System.out.println("Congrats!! Player you advanced to: " + randomDieMove + " positions");
            } else if (option == SNAKE) {
                if (playerPosition > randomDieMove) {
                    playerPosition -= randomDieMove;
                } else {
                    playerPosition = 0;
                }
                System.out.println("oops!! Player you step on a snake so you will go back to " + randomDieMove + " step back");
            }
            playerPosition = moveCondition(playerPosition, randomDieMove);
            if (playerPosition == WIN_POSITION) {
                break;
            }
        }
    }

    public static void main(String args[]) {

        System.out.println("Welcome to Snake and Ladder");
        rollDie();
        repeatTillPlayerReachGoal();
    }
}
