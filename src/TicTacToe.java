
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) throws Exception {
        int emptySquares = 9;
        char[][] gameBoard = { { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' },
                { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' },
                { ' ', '|', ' ', '|', ' ' } };

        drawBoard(gameBoard);

        Scanner s = new Scanner(System.in);
        Random random = new Random();

        while (true) {

            System.out.print("Pick a square (1-9): ");
            int playerSquare = s.nextInt();
            if (validInput(playerSquare) && isSquareEmpty(gameBoard, playerSquare)) {
                placePiece(gameBoard, playerSquare, "player");
                emptySquares--;
                if (emptySquares == 0) {
                    break;
                }

            } else {
                System.out.println("Invalid square");
                continue;
            }
            while (true) {
                int cpuSquare = random.nextInt(9) + 1;
                if (isSquareEmpty(gameBoard, cpuSquare)) {
                    placePiece(gameBoard, cpuSquare, "cpu");
                    emptySquares--;
                    break;
                } else {
                    continue;
                }

            }

            drawBoard(gameBoard);

            if (emptySquares == 0 || weHaveAwinner(gameBoard) != ' ') {
                break;
            }

        }

        char winner = weHaveAwinner(gameBoard);

        if (winner == 'X') {
            System.out.println("****************");
            System.out.println("You won!!");
            System.out.println("****************");

        } else if (winner == 'O') {
            System.out.println("*********************");
            System.out.println("Computer won!");
            System.out.println("*********************");

        } else {
            System.out.println("***************");
            System.out.println("Tie!");
            System.out.println("***************");
        }
        drawBoard(gameBoard);

    }

    public static void drawBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placePiece(char[][] gameBoard, int square, String player) {
        char symbol = ' ';
        if (player.equals("player")) {
            symbol = 'X';
        } else if (player.equals("cpu")) {
            symbol = 'O';
        }

        switch (square) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }

    }

    public static boolean isSquareEmpty(char[][] gameBoard, int square) {
        switch (square) {
            case 1:
                return gameBoard[0][0] == ' ';
            case 2:
                return gameBoard[0][2] == ' ';
            case 3:
                return gameBoard[0][4] == ' ';
            case 4:
                return gameBoard[2][0] == ' ';
            case 5:
                return gameBoard[2][2] == ' ';
            case 6:
                return gameBoard[2][4] == ' ';
            case 7:
                return gameBoard[4][0] == ' ';
            case 8:
                return gameBoard[4][2] == ' ';
            case 9:
                return gameBoard[4][4] == ' ';
            default:
                return true;
        }
    }

    public static boolean validInput(int input) {
        return input > 0 && input <= 9;
    }

    public static char weHaveAwinner(char[][] gameBoard) {
        char[] symbols = { 'X', 'O' };
        for (char symbol : symbols) {
            if (// rows
            (gameBoard[0][0] == symbol && gameBoard[0][2] == symbol && gameBoard[0][4] == symbol)
                    || (gameBoard[2][0] == symbol && gameBoard[2][2] == symbol && gameBoard[2][4] == symbol)
                    || (gameBoard[4][0] == symbol && gameBoard[4][2] == symbol && gameBoard[4][4] == symbol)

                    // columns
                    || (gameBoard[0][0] == symbol && gameBoard[2][0] == symbol && gameBoard[4][0] == symbol)
                    || (gameBoard[0][2] == symbol && gameBoard[2][2] == symbol && gameBoard[4][2] == symbol)
                    || (gameBoard[0][4] == symbol && gameBoard[2][4] == symbol && gameBoard[4][4] == symbol)

                    // diagonal
                    || (gameBoard[0][0] == symbol && gameBoard[2][2] == symbol && gameBoard[4][4] == symbol)
                    || (gameBoard[0][4] == symbol && gameBoard[2][2] == symbol && gameBoard[4][0] == symbol)) {
                return symbol;
            }

        }
        return ' ';
    }
}