package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int counter = 1;
        int counter1;
        int xCounter = 0;
        int oCounter = 0;
        int xPos = 0;
        int yPos = 0;

        boolean trueCoordinates = false;
        boolean xWins = false;
        boolean oWins = false;
        boolean fullBoard = false;

        char[][] cells = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};

        System.out.println("---------");
        for (char[] cell : cells) {
            System.out.print("| ");
            for (char c : cell) {
                System.out.print(c + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");



        while (!fullBoard) {

            while (!trueCoordinates) {
                System.out.print("Enter the coordinates: ");
                String coordinates = scanner.nextLine();
                String x = coordinates.substring(0, 1);
                String y = coordinates.substring(2, 3);

                if (!coordinates.matches("\\d +\\d")) {
                    System.out.println("You should enter numbers!");
                    xPos = 0;
                    yPos = 0;
                } else {
                    xPos = Integer.parseInt(x);
                    yPos = Integer.parseInt(y);
                }

                if (xPos != 0 && yPos != 0) {
                    if (xPos > 3 || yPos > 3) {
                        System.out.println("Coordinates should be from 1 to 3!");
                    } else if (cells[3 - yPos][xPos - 1] == 'X' || cells[3 - yPos][xPos - 1] == 'O') {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        trueCoordinates = true;
                    }
                }
            }

            if (counter % 2 != 0) {
                cells[3 - yPos][xPos - 1] = 'X';
                xCounter++;
            } else {
                cells[3 - yPos][xPos - 1] = 'O';
                oCounter++;
            }
            counter++;

            if (xCounter + oCounter == 9) {
                fullBoard = true;
            } else {
                trueCoordinates = false;
            }

            System.out.println("---------");
            for (char[] cell : cells) {
                System.out.print("| ");
                for (char c : cell) {
                    System.out.print(c + " ");
                }
                System.out.println("|");
            }
            System.out.println("---------");

            for (char[] cell : cells) {
                for (char c : cell) {
                    sum += c;
                    if (sum == 264) {
                        xWins = true;
                    } else if (sum == 237) {
                        oWins = true;
                    }
                }
                sum = 0;
            }

            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[i].length; j++) {
                    sum += cells[j][i];
                    if (sum == 264) {
                        xWins = true;
                    } else if (sum == 237) {
                        oWins = true;
                    }
                }
                sum = 0;
            }

            for (int i = 0; i < cells.length; i++) {
                sum += cells[i][i];
                if (sum == 264) {
                    xWins = true;
                } else if (sum == 237) {
                    oWins = true;
                }
            }
            sum = 0;

            counter1 = 0;
            for (int i = 2; i >= 0; i--) {
                sum += cells[i][counter1];
                counter1++;
                if (sum == 264) {
                    xWins = true;
                } else if (sum == 237) {
                    oWins = true;
                }
            }
            sum = 0;

            if (xWins || oWins) {
                fullBoard = true;
            }
        }

        if (xWins) {
            System.out.println("X wins");
        } else if (oWins) {
            System.out.println("O wins");
        } else {
            System.out.println("Draw");
        }
    }
}
