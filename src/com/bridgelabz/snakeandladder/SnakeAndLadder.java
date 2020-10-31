package com.bridgelabz.snakeandladder;

import java.util.Random;

public class SnakeAndLadder {

    static final int INITIAL_POSITION = 0;
    static final int NUMBER_OF_PLAYER = 1;
    static final int NO_PLAY = 0;
    static final int LADDER = 1;
    static final int SNAKE = 2;

    private static int rollDie() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    private static void checkNoplayLadderSnake() {
        int playerPosition = INITIAL_POSITION;
        Random random = new Random();
        int option = random.nextInt(3);
        int randomDieMove = rollDie();
        if(option == NO_PLAY) {
            playerPosition = playerPosition;
            System.out.println("Player its a foult so no changes to the current position");
        }else if(option == LADDER){
            playerPosition += randomDieMove;
            System.out.println("Congrats!! Player you advanced to: "+ randomDieMove +" positions");
        }else if(option == SNAKE){
            playerPosition -= randomDieMove;
            System.out.println("oops!! Player you step on a snake so you will go back to "+randomDieMove+" step back");
        }
    }

    public static void main(String args[]) {

        System.out.println("Welcome to Snake and Ladder");
        rollDie();
        checkNoplayLadderSnake();
    }
}
