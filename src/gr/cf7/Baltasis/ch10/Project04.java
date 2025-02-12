package gr.cf7.Baltasis.ch10;

import java.util.Scanner;

public class Project04 {

    public static char[][] gameBoard = new char[3][3];
    public static char gamePlayer = 'X';

    public static void main(String[] args) {

            gameMenu();
    }
    //Δημιουργια menu
    public static void gameMenu() {
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.println("Welcome to TicTacToe Game");
            System.out.println("1. Start Play");
            System.out.println("2. Exit");

            int choice = in.nextInt();

            switch (choice) {

                case 1:
                    playTicTacToe();
                    break;
                case 2:
                    System.out.println("The game system is closing");
                    in.close();
                    return;

                default:
                    System.out.println("Wrong entry. \n" +
                            "Please make a selection.");

            }
        }
    }


    public static void playTicTacToe() {
        //Η διαδικασία του παιχνιδιού στην οποία καλούμε τα methods
        //που έχουμε δημιουργήσει.
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {

                gameBoard[i][j] = ' ';
            }
        } while (true) {
            printGameBoard();

            System.out.println("Player: " + gamePlayer +" Please make your move [row][col]!");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (!isTheMoveValid(row, col)) {
                System.out.println("Your move is not valid. Please try again");
                continue;
            }

            gameBoard[row][col] = gamePlayer;

            if (playerWin(gamePlayer)) {
                printGameBoard();
                System.out.println("The player: " + gamePlayer + " won the game!");
                break;
            } else if (gameDraw()) {
                printGameBoard();
                System.out.println("The game is tie!");
                break;
            }
            gamePlayer = (gamePlayer == 'X') ? 'O' : 'X';
        }
        scanner.close();

    }
    public static void printGameBoard() {

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                System.out.print(gameBoard[i][j]);
                if (j < gameBoard.length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < gameBoard.length - 1) {
                System.out.println("----------");
            }
        }
    }
    public static boolean playerWin(char player) {

        for (char[] chars : gameBoard) {
            for (int j = 0; j < gameBoard.length; j++) {
                if (chars[0] == player && chars[1] == player && chars[2] == player) {
                    return true;
                } else if (gameBoard[0][j] == player && gameBoard[1][j] == player && gameBoard[2][j] == player) {
                    return true;
                } else if (gameBoard[0][0] == player && gameBoard[1][1] == player && gameBoard[2][2] == player) {
                    return true;
                } else if (gameBoard[0][2] == player && gameBoard[1][1] == player && gameBoard[2][0] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean gameDraw() {

        for (char[] chars : gameBoard) {
            for (int j = 0; j < gameBoard.length; j++) {
                if (chars[j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isTheMoveValid(int row, int col) {

        return row >= 0 && row < gameBoard.length && col >= 0 && col < gameBoard.length && gameBoard[row][col] == ' ';
    }
}

