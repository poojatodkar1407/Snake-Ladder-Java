package com.bridgelabz.snakeandladder;

import java.util.Random;

public class SnakeAndLadder {

    private static int rollDie() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public static void main(String args[]) {
        int INITIAL_POSITION = 0;
        int NUMBER_OF_PLAYER = 1;
        System.out.println("Welcome to Snake and Ladder");
        int randomDieMove = rollDie();
    }
}
