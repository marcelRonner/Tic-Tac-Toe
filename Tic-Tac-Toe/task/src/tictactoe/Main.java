package tictactoe;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static boolean xWins = false;
    static boolean oWins = false;
    static boolean gameFinished = false;
    static boolean winner = false;
    static String Result = " ";


    public static void main(String[] args) {
        String[] table = new String[9];
        int playerRound = 1;

        for (int i = 0; i < 9; i++){     //init Output table
            table[i] = " ";
        }

        printBoard(table);

        while (gameFinished == false) {

            System.out.println("Enter the coordinates: ");
            String coordLine = sc.next();

            if (sc.hasNext()) {
                String coordStep = sc.next();

                if (coordLine.matches("[0-9]+") && coordStep.matches("[0-9]+")) {
                    int coordLineInt = Integer.parseInt(coordLine);
                    int coordStepInt = Integer.parseInt(coordStep);

                    if (coordLineInt > 0 && coordLineInt < 4 && coordStepInt > 0 && coordStepInt < 4) {
                        int newTableInt = ((coordLineInt - 1) * 3) + (coordStepInt - 1);

                        if (table[newTableInt].equals(" ")) {
                            playerRound++;
                            if ((playerRound & 1) == 0) {
                                table[newTableInt] = "X";
                            } else {
                                table[newTableInt] = "O";
                            }

                            checkWinner(table);
                            checkGameState(table, Result);

                            if (gameFinished){
                                printBoard(table);
                                System.out.println(Result);
                            } else {
                                printBoard(table);
                            }
                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                        }
                    } else {
                        System.out.println("Coordinates should be from 1 to 3!");
                    }
                } else {
                    System.out.println("You should enter numbers!");
                }
            } else {
                System.out.println("You should enter numbers!");
            }
        }

    }

    static void checkWinner(String[] table) {
        var player = "X";

        checkWinningCombos(table, player);
        if (winner){
            xWins = true;
        }

        player = "O";
        checkWinningCombos(table, player);
        if (winner){
            oWins = true;
        }
    }
    static void checkGameState(String[] table, String result) {
        int emptyFields = 0;
        int xAmount = 0;
        int oAmount = 0;

        for (String tableElement : table) {
            switch (tableElement) {
                case " ":
                    emptyFields++;
                    break;
                case "X":
                    xAmount++;
                    break;
                case "O":
                    oAmount++;
                    break;
            }
        }

        if (xWins && oWins || (xAmount - oAmount > 1 || oAmount - xAmount > 1)) {
            Result = "Impossible";
            gameFinished = true;

        } else if (!xWins && !oWins) {
            if (emptyFields == 0) {
                Result = "Draw";
                gameFinished = true;
            }
        } else if (xWins) {
            Result = "X wins";
            gameFinished = true;

        } else if (oWins) {
            Result = "O wins";
            gameFinished = true;
        }
    }

    static void checkWinningCombos(String[] table, String player) {
        winner = false;
        if     ((table[0].equals(player) && table[1].equals(player) && table[2].equals(player)) ||
                (table[3].equals(player) && table[4].equals(player) && table[5].equals(player)) ||
                (table[6].equals(player) && table[7].equals(player) && table[8].equals(player)) ||
                (table[0].equals(player) && table[3].equals(player) && table[6].equals(player)) ||
                (table[1].equals(player) && table[4].equals(player) && table[7].equals(player)) ||
                (table[2].equals(player) && table[5].equals(player) && table[8].equals(player)) ||
                (table[0].equals(player) && table[4].equals(player) && table[8].equals(player)) ||
                (table[2].equals(player) && table[4].equals(player) && table[6].equals(player))){
            winner = true;
        }
    }

    static void printBoard(String[] table) {
        System.out.println("---------");
        System.out.printf("| %s %s %s |%n", table[0], table[1], table[2]);
        System.out.printf("| %s %s %s |%n", table[3], table[4], table[5]);
        System.out.printf("| %s %s %s |%n", table[6], table[7], table[8]);
        System.out.println("---------");
}
}
