//import java.util;
import java.util.Scanner;



/*
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

            }
        }
 */




public class Main {
    /*
     *   GLOBAL VARIABLES
     */
    static boolean solved = false;
    static int[][] sudoku = new int[9][9];
    //static boolean solvable = true;
    static int[][][] kleineZahlen = new int[9][9][10];


    /*
     *   -------
     *   METHODS
     *   -------
     */

    /*
     * we go through each row and check whether a single last number is missing
     */
    public static boolean lastNumberRow() {
        int missingNumber = 45;
        int numNonZeros = 0;
        int x = 0;
        int y = 0;
        boolean changed = false;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] != 0) {
                    numNonZeros++;
                    missingNumber -= sudoku[i][j];
                } else {
                    x = i;
                    y = j;
                }
            }
            if (numNonZeros == 8) {
                sudoku[x][y] = missingNumber;
                changed = true;
            }
            missingNumber = 45;
            numNonZeros = 0;
        }
        return changed;
    }

    /*
     * we go through each column and check whether a single last number is missing
     */
    public static boolean lastNumberColumn() {
        int missingNumber = 45;
        int numNonZeros = 0;
        int x = 0;
        int y = 0;
        boolean changed = false;

        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                if (sudoku[i][j] != 0) {
                    numNonZeros++;
                    missingNumber -= sudoku[i][j];
                } else {
                    x = i;
                    y = j;
                }
            }
            if (numNonZeros == 8) {
                sudoku[x][y] = missingNumber;
                changed = true;
            }
            missingNumber = 45;
            numNonZeros = 0;
        }
        return changed;
    }

    public static boolean lastNumberBlock() {
        int missingNumber = 45;
        int numNonZeros = 0;
        int x = 0;
        int y = 0;
        boolean changed = false;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i/3][j/3] != 0) {
                    numNonZeros++;
                    missingNumber -= sudoku[i/3][j/3];
                } else {
                    x = i;
                    y = j;
                }
            }
            if (numNonZeros == 8) {
                sudoku[x][y] = missingNumber;
                changed = true;
            }
            missingNumber = 45;
            numNonZeros = 0;
        }
        return changed;
    }

    public static boolean welcheZahlFehlt() {
        boolean changes = lastNumberRow();
        //changes = changes || lastNumberColumn();
        //changes = changes || lastNumberBlock();
        return changes;
    }

    /*
     *  for each empty space in the whole sudoku, delete small numbers if possible (same number in row/column/block)
     */
    public static void kleineZahlenStreichen() {
        for (int zeile = 0; zeile < 9; zeile++) {
            for (int reihe = 0; reihe < 9; reihe++) {
                if (sudoku[zeile][reihe] == 0) {
                    // reihe:
                    for (int temp = 0; temp < 9; temp++) {
                        switch (sudoku[temp][reihe]) {
                            case 0:
                                break;
                            case 1:
                                kleineZahlen[zeile][reihe][1] = 0;
                                break;
                            case 2:
                                kleineZahlen[zeile][reihe][2] = 0;
                                break;
                            case 3:
                                kleineZahlen[zeile][reihe][3] = 0;
                                break;
                            case 4:
                                kleineZahlen[zeile][reihe][4] = 0;
                                break;
                            case 5:
                                kleineZahlen[zeile][reihe][5] = 0;
                                break;
                            case 6:
                                kleineZahlen[zeile][reihe][6] = 0;
                                break;
                            case 7:
                                kleineZahlen[zeile][reihe][7] = 0;
                                break;
                            case 8:
                                kleineZahlen[zeile][reihe][8] = 0;
                                break;
                            case 9:
                                kleineZahlen[zeile][reihe][9] = 0;
                                break;
                        }
                    }

                    // zeile:
                    for (int temp = 0; temp < 9; temp++) {
                        switch (sudoku[zeile][temp]) {
                            case 0:
                                break;
                            case 1:
                                kleineZahlen[zeile][reihe][1] = 0;
                                break;
                            case 2:
                                kleineZahlen[zeile][reihe][2] = 0;
                                break;
                            case 3:
                                kleineZahlen[zeile][reihe][3] = 0;
                                break;
                            case 4:
                                kleineZahlen[zeile][reihe][4] = 0;
                                break;
                            case 5:
                                kleineZahlen[zeile][reihe][5] = 0;
                                break;
                            case 6:
                                kleineZahlen[zeile][reihe][6] = 0;
                                break;
                            case 7:
                                kleineZahlen[zeile][reihe][7] = 0;
                                break;
                            case 8:
                                kleineZahlen[zeile][reihe][8] = 0;
                                break;
                            case 9:
                                kleineZahlen[zeile][reihe][9] = 0;
                                break;
                        }
                    }

                    // block:
                    int tempReihe = reihe - (reihe % 3);
                    int tempZeile = zeile - (zeile % 3);
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            switch (sudoku[tempZeile+i][tempReihe+j]) {
                                case 0:
                                    break;
                                case 1:
                                    kleineZahlen[zeile][reihe][1] = 0;
                                    break;
                                case 2:
                                    kleineZahlen[zeile][reihe][2] = 0;
                                    break;
                                case 3:
                                    kleineZahlen[zeile][reihe][3] = 0;
                                    break;
                                case 4:
                                    kleineZahlen[zeile][reihe][4] = 0;
                                    break;
                                case 5:
                                    kleineZahlen[zeile][reihe][5] = 0;
                                    break;
                                case 6:
                                    kleineZahlen[zeile][reihe][6] = 0;
                                    break;
                                case 7:
                                    kleineZahlen[zeile][reihe][7] = 0;
                                    break;
                                case 8:
                                    kleineZahlen[zeile][reihe][8] = 0;
                                    break;
                                case 9:
                                    kleineZahlen[zeile][reihe][9] = 0;
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }

    /*
     *  we check whether in any field only one small number is left
     */
    public static void lastSmallNumberGlobal () {
        int anzNullen = 0;
        int einzutragendeZahl = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // for each cell, if empty:
                if (sudoku[i][j] == 0) {
                    // check if only one last small number remains
                    for (int k = 1; k < 10; k++) {
                        if (kleineZahlen[i][j][k] == 0) {
                            anzNullen++;
                        } else {
                            einzutragendeZahl = kleineZahlen[i][j][k];
                            x = i;
                            y = j;
                        }
                    }

                    if (anzNullen == 8) {
                        sudoku[x][y] = einzutragendeZahl;
                    }
                    anzNullen = 0;
                }
            }
        }
    }


/*
    public static int zeilenKleineZahlenPruefen(int zeile, int reihe) {
        for (int i = 1; i < 10; i++) {                          //für jede kleine zahl die bei [zeile][reihe] eingetragen ist
            if (kleineZahlen[zeile][reihe][i] == i) {           //und nicht 0 eingetragen ist
                for (int j = 0; j < 9; j++) {                   //früfe bei allen anderen kleinen Zahlen
                    if (kleineZahlen[zeile][j][i] == i) {
                        break;
                    } else {
                        if (j == 9) {
                            return i;
                        }
                    }
                }
            }
        }
        return 0;
    }
*/


    /*
     *  we try to find a small number, which is the last spot for that number in row/column/block
     */
    public static void lastSmallNumberEntry() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] == 0) {
                    for (int k = 1; k < 10; k++) {
                        if (kleineZahlen[i][j][k] != 0) {
                            // check row
                            for (int r = 0; r < 9; r++) {
                                if ((kleineZahlen[r][j][k] != 0) && (r != i)) {
                                    break;
                                }
                                if (r == 8) {
                                    sudoku[i][j] = k;
                                    System.out.println(i + j + k +"last small number entry gefunden!");
                                    return;
                                }
                            }

                            // check column
                            for (int c = 0; c < 9; c++) {
                                if ((kleineZahlen[i][c][k] != 0) && (c != j)) {
                                    break;
                                }
                                if (c == 8) {
                                    sudoku[i][j] = k;
                                    System.out.println(i + j + k +"last small number entry gefunden!");
                                    return;
                                }
                            }

                            // check block
                            int startRow = i/3 * 3;
                            int startCol = j/3 * 3;
                            for (int b_r = startRow; b_r < startRow+3; b_r++) {
                                for (int b_c = startCol; b_c < startCol+3; b_c++) {
                                    if ((kleineZahlen[b_r][b_c][k] != 0) && (b_c != j) && (b_r != i)) {
                                        break;
                                    }
                                    if (b_c == 2) {
                                        if (b_r == 2) {
                                            sudoku[i][j] = k;
                                            System.out.println(i + j + k +"last small number entry gefunden!");
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        //zahlenEintragen();
        //sudoku = [[7,0,5,9,3,1,4,6,2],[2,4,3,8,0,6,9,7,0],[6,9,1,7,2,0,0,0,3],[4,0,0,6,1,0,3,0,8],[0,6,8,5,7,3,2,1,0],[1,0,2,0,9,8,0,0,7],[3,0,0,0,8,5,1,4,6,],[0,2,4,1,0,7,8,3,9],[8,1,0,3,0,9,7,0,5]];

        // das ist von chatgpt
        // Array in einer Zeile füllen
        int[] werte = {
                /*
                7 ,0 ,9 ,6 ,0 ,3 ,8 ,4 ,5,
                4 ,1 ,3 ,0 ,5 ,7 ,6 ,2 ,9,
                8 ,5 ,0 ,4 ,0 ,9 ,0 ,1 ,7,
                6 ,8 ,4 ,3 ,7 ,5 ,2 ,0 ,1 ,
                1 ,0 ,2 ,9 ,4 ,0, 7 ,5 ,8 ,
                0 ,7 ,5 ,0 ,0 ,2 ,4, 3 ,6 ,
                0 ,9 ,7 ,2 ,3 ,8 ,1 ,6, 0 ,
                3 ,4 ,8 ,5 ,0 ,1 ,0 ,7 ,2,
                0 ,6 ,1 ,0 ,9, 0, 5, 0, 3
                */
                /*
                7 ,2 ,9 ,6 ,1 ,3 ,8 ,4 ,5,
                4 ,1 ,3 ,8 ,5 ,7 ,6 ,2 ,9,
                8 ,5 ,6 ,4 ,2 ,9 ,3 ,1 ,7,
                6 ,8 ,4 ,3 ,7 ,5 ,2 ,9 ,1 ,
                1 ,3 ,2 ,9 ,4 ,6, 7 ,5 ,8 ,
                9 ,7 ,5 ,1 ,8 ,2 ,4, 3 ,6 ,
                5 ,9 ,7 ,2 ,3 ,8 ,1 ,6, 4 ,
                3 ,4 ,8 ,5 ,6 ,1 ,9 ,7 ,2,
                2 ,6 ,1 ,7 ,9, 4, 5, 8, 3
                */
                /*
                1, 2, 0, 4, 5, 6, 0, 8, 0,
                4, 5, 6, 7, 8, 9, 1, 2, 3,
                7, 8, 9, 1, 2, 3, 4, 5, 0,
                2, 3, 1, 5, 4, 0, 6, 0, 7,
                5, 6, 0, 9, 7, 2, 3, 1, 8,
                8, 9, 7, 0, 6, 1, 0, 4, 5,
                3, 1, 0, 6, 9, 4, 8, 7, 0,
                6, 4, 5, 8, 1, 0, 9, 3, 2,
                0, 7, 8, 2, 3, 5, 0, 6, 1
                */

                5, 3, 0, 0, 7, 0, 0, 0, 0,
                6, 0, 0, 1, 9, 5, 0, 0, 0,
                0, 9, 8, 0, 0, 0, 0, 6, 0,
                8, 0, 0, 0, 6, 0, 0, 0, 3,
                4, 0, 0, 8, 0, 3, 0, 0, 1,
                7, 0, 0, 0, 2, 0, 0, 0, 6,
                0, 6, 0, 0, 0, 0, 2, 8, 0,
                0, 0, 0, 4, 1, 9, 0, 0, 5,
                0, 0, 0, 0, 8, 0, 0, 7, 9

        };

        long startTime = System.nanoTime();

        // Werte in das Sudoku-Array übertragen
        for (int i = 0; i < 9; i++) {
            System.arraycopy(werte, i * 9, sudoku[i], 0, 9);
        }

        /*
         *  filling the small numbers array
         */
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 10; k++) {
                    kleineZahlen[i][j][k] = k; // Füllt jede Zelle mit 1 bis 9
                }
            }
        }

        System.out.println("Eingegebenes Sudoku:");
        Helpers.printSudoku(sudoku);

        int iterationsCounter = 0;
        while (!Helpers.checkSolved(sudoku)) {
            kleineZahlenStreichen();
            // checke reihen/zeilen/blöcke fast voll?
            welcheZahlFehlt();

            lastSmallNumberGlobal();
            lastSmallNumberEntry();

            iterationsCounter++;
            System.out.println("The sodoku after " + iterationsCounter + "th iteration");
            Helpers.printSudoku(sudoku);

        }
        long finishTime = System.nanoTime();

        System.out.println("Gelöstes Sudoku:");
        Helpers.printSudoku(sudoku);
        Helpers.printStats(startTime, finishTime, iterationsCounter);
    }
}

