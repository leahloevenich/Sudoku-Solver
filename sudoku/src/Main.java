//import java.util;
import java.util.Scanner;
import helpers.java;


/*
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

            }
        }
 */




public class Main {
    // globale Variablen
    static boolean solved = false;
    static int[][] sudoku = new int[9][9];
    static boolean solvable = true;
    static int[][][] smallNumbers = new int[9][9][10];


    // methoden
    public static int welcheZahlFehltReihe(int zeile, int reihe) {
        int fehlendeZahl = 0;

        // reihe:
        for (int temp = 0; temp < 9; temp++) {
            if (sudoku[temp][reihe] != 0) {
                fehlendeZahl = fehlendeZahl + sudoku[temp][reihe];
                if (temp == 8) {
                    return 45 - fehlendeZahl;
                }
            } else {
                if (temp == zeile) {
                } else {
                    break;
                }
            }
        }
        fehlendeZahl = 0;
    }

        public static int welcheZahlFehlt(int zeile, int reihe) {
            int fehlendeZahl = 0;

            // reihe:
            for (int temp = 0; temp < 9; temp++) {
                if (sudoku[temp][reihe] != 0) {
                    fehlendeZahl = fehlendeZahl + sudoku[temp][reihe];
                    if (temp == 8) {
                        return 45-fehlendeZahl;
                    }
                } else {
                    if (temp == zeile) {
                    } else {
                        break;
                    }
                }
            }
            fehlendeZahl = 0;

    public static int welcheZahlFehlt(int zeile, int reihe) {
        int fehlendeZahl = 0;

        // reihe: 
        for (int temp = 0; temp < 9; temp++) {
            if (sudoku[temp][reihe] != 0) {
                fehlendeZahl = fehlendeZahl + sudoku[temp][reihe];
                if (temp == 8) {
                    return 45-fehlendeZahl;
                }
            } else {
                if (temp == zeile) {
                } else {
                    break;
                }
            }
        }
        fehlendeZahl = 0;

        // zeile:
        for (int temp = 0; temp < 9; temp++) {
            if (sudoku[zeile][temp] != 0) {
                fehlendeZahl = fehlendeZahl + sudoku[zeile][temp];
                if (temp == 8) {
                    return 45-fehlendeZahl;
                }
            } else {
                if (temp == reihe) {
                } else {
                    break;
                }
            }
        }
        fehlendeZahl = 0;

        // block:
        int tempReihe = reihe - (reihe % 3);
        int tempZeile = zeile - (zeile % 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudoku[tempZeile+i][tempReihe+j] != 0) {
                    fehlendeZahl = fehlendeZahl + sudoku[tempZeile+i][tempReihe+j];
                    if ((i == 2) && (j == 2)) {
                        return 45-fehlendeZahl;
                    }
                } else {
                    if ((tempZeile+i == zeile) && (tempReihe+j == reihe)) {
                    } else {
                        return 0;
                        // wollte hier eigentlich break benutzen aber das ging nicht??
                    }
                }
            }
        }
        return 0;
    }

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

    public static int letzteKleineZahl (int zeile, int reihe) {
        int anzNullen = 0;
        int einzutragendeZahl = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                for (int k = 0; k < 10; k++) {
                    if (kleineZahlen[i][j][k] == 0) {
                        anzNullen++;
                    } else {
                        einzutragendeZahl = kleineZahlen[i][j][k];
                    }
                }

                if (anzNullen == 9) {
                    return einzutragendeZahl;
                }
            }
        }
        return 0;
    }

    public static void printSudoku() {
        // ehrlich gesagt keine ahnung wieso ich manchmal +1 und manchmal nicht brauche vor mod, aber es klappt HAHAAHA
        System.out.println(" ------------------------------------- ");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (((j) % 3) == 0) {
                    System.out.print(" | ");
                }
                System.out.print(" " + sudoku[i][j] + " ");
                if (((j+1) % 9) == 0) {
                    System.out.print(" | ");
                    System.out.println();
                }
            }
            if (((i+1) % 3) == 0) {
                System.out.println(" ------------------------------------- ");
            }
        }
    }

    public static void zahlenEintragen() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nJetzt bitte die Einträge des zu lösenden Sudokus eingeben. Leere Einträge = 0");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = input.nextInt();
            }
        }
    }

    public static void checkGeloest() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] == 0) {
                    return;
                }
            }
        }
         geloest = true;
    }

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


    public static void main(String[] args) {

        //zahlenEintragen();


        //sudoku = [[7,0,5,9,3,1,4,6,2],[2,4,3,8,0,6,9,7,0],[6,9,1,7,2,0,0,0,3],[4,0,0,6,1,0,3,0,8],[0,6,8,5,7,3,2,1,0],[1,0,2,0,9,8,0,0,7],[3,0,0,0,8,5,1,4,6,],[0,2,4,1,0,7,8,3,9],[8,1,0,3,0,9,7,0,5]];

        // das ist von chatgpt
        // Array in einer Zeile füllen
        int[] werte = {

                7 ,0 ,9 ,6 ,0 ,3 ,8 ,4 ,5,
                4 ,1 ,3 ,0 ,5 ,7 ,6 ,2 ,9,
                8 ,5 ,0 ,4 ,0 ,9 ,0 ,1 ,7,
                6 ,8 ,4 ,3 ,7 ,5 ,2 ,0 ,1 ,
                1 ,0 ,2 ,9 ,4 ,0, 7 ,5 ,8 ,
                0 ,7 ,5 ,0 ,0 ,2 ,4, 3 ,6 ,
                0 ,9 ,7 ,2 ,3 ,8 ,1 ,6, 0 ,
                3 ,4 ,8 ,5 ,0 ,1 ,0 ,7 ,2,
                0 ,6 ,1 ,0 ,9, 0, 5, 0, 3

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

                /*
                5, 3, 0, 0, 7, 0, 0, 0, 0,
                6, 0, 0, 1, 9, 5, 0, 0, 0,
                0, 9, 8, 0, 0, 0, 0, 6, 0,
                8, 0, 0, 0, 6, 0, 0, 0, 3,
                4, 0, 0, 8, 0, 3, 0, 0, 1,
                7, 0, 0, 0, 2, 0, 0, 0, 6,
                0, 6, 0, 0, 0, 0, 2, 8, 0,
                0, 0, 0, 4, 1, 9, 0, 0, 5,
                0, 0, 0, 0, 8, 0, 0, 7, 9
                */
        };
        // Werte in das Sudoku-Array übertragen
        for (int i = 0; i < 9; i++) {
            System.arraycopy(werte, i * 9, sudoku[i], 0, 9);
        }

        // kleine Zahlen füllen
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 10; k++) {
                    kleineZahlen[i][j][k] = k; // Füllt jede Zelle mit 1 bis 9
                }
            }
        }

        System.out.println(kleineZahlen[1][1][9]);



        System.out.println("Eingegebenes Sudoku:");
        printSudoku();

        geloest = false;
        while (!geloest) {
            kleineZahlenStreichen();
            // checke reihen/zeilen/blöcke fast voll?
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (sudoku[i][j] == 0) {
                        sudoku[i][j] = welcheZahlFehlt(i, j);
                    }
                }
            }

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (sudoku[i][j] == 0) {
                        sudoku[i][j] = letzteKleineZahl(i, j);
                    }
                }
            }

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (sudoku[i][j] == 0) {
                        sudoku[i][j] = zeilenKleineZahlenPruefen(i, j);
                    }
                }
            }
            


            // checke kleine Zahlen nur noch eine übrig?

            printSudoku();
            checkGeloest();
        }

        System.out.println("Gelöstes Sudoku:");
        printSudoku();
    }
}

