import java.util.Scanner;

public class Helpers {

    public static void printSudoku(int[][] sudoku) {
        // ehrlich gesagt keine ahnung wieso ich manchmal +1 und manchmal nicht brauche vor mod, aber es klappt HAHAAHA
        //System.out.println(" ------------------------------------- ");
        System.out.println(" ─────────────────────────────────────");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (((j) % 3) == 0) {
                    System.out.print(" │ ");
                }
                System.out.print(" " + sudoku[i][j] + " ");
                if (((j+1) % 9) == 0) {
                    System.out.print(" │ ");
                    System.out.println();
                }
            }
            if (((i+1) % 3) == 0) {
                //System.out.println(" ------------------------------------- ");
                System.out.println(" ─────────────────────────────────────");

            }
        }
    }

    public static int[][] zahlenEintragen() {
        Scanner input = new Scanner(System.in);
        int[][] sudoku = new int[9][9];

        System.out.println("\nJetzt bitte die Einträge des zu lösenden Sudokus eingeben. Leere Einträge = 0");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = input.nextInt();
            }
        }

        return sudoku;
    }

    public static boolean checkSolved(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] == 0) {
                    // if anywhere is a 0 (empty) entry left, the sudoku is not solved
                    return false;
                }
            }
        }
        return true;
    }

    public static void printStats(long startTime, long finishTime, int numIterations) {
        long elapsedTime = finishTime - startTime;
        elapsedTime /= 1000;

        /*
         *  printing the stats
         */
        System.out.println(" ─────────────── ⋆⋅☆⋅⋆ ────────────────");
        System.out.println("Time elapsed: " + elapsedTime + " μs");
        System.out.println("#Algorithm iterations: " + numIterations);
    }
}