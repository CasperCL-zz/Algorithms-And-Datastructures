/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.Random;

/**
 *
 * @author Casper
 */
public class PuzzleGen {

    private Random numberG;

    public PuzzleGen() {
        numberG = new Random();
    }

    public String getPuzzle() {
        String puzzle = "";
        int i = 0;
        int nbs[] = new int[4];
        int nr;     // the number
        int op;     // the operand

        while (i < 4) {
            nr = numberG.nextInt(9);
            puzzle += nr;
            i++;
        }

        i = 0;
        while (i < 3) {
            op = numberG.nextInt(5);
            switch (op) {
                case 0:
                    puzzle += '+';
                    break;
                case 1:
                    puzzle += '-';
                    break;
                case 2:
                    puzzle += '*';
                    break;
                case 3:
                    puzzle += '/';
                    break;
                case 4:
                    puzzle += '^';
                    break;
            }
            i++;
        }

        return puzzle;
    }

    /**
     * Sort the so the answer won't be predicatable.
     *
     * @param dPuzzle
     * @return cleanPuzzle a clean puzzle
     */
    public String getCleanPuzzle(String dPuzzle) {
        char a[] = dPuzzle.toCharArray();
        String cPuzzle = "";
        char nrs[] = new char[4];
        char ops[] = new char[3];
        int nrC = 0;
        int opC = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] >= '0' && a[i] <= '9') {
                nrs[nrC] += a[i];
                nrC++;
            } else {
                ops[opC] += a[i];
                opC++;
            }
        }
        nrs = sort(nrs);
        ops = sort(ops);

        // MELT
        cPuzzle = "";
        for (char nr : nrs) {
            cPuzzle += nr;
        }
        for (char op : ops) {
            cPuzzle += op;
        }

        return cPuzzle;
    }

    /**
     * Bubble sort
     *
     * @param a
     * @return
     */
    public int[] sort(int a[]) {
        for (int out = a.length - 1; out > 1; out--) {
            for (int in = 0; in < out; in++) {
                if (a[in] > a[in + 1]) {
                    int tmp = a[in];
                    a[in] = a[in + 1];
                    a[in + 1] = tmp;
                }
            }
        }

        return a;
    }

    private char[] sort(char[] a) {
        for (int out = a.length - 1; out > 1; out--) {
            for (int in = 0; in < out; in++) {
                if (a[in] > a[in + 1]) {
                    char tmp = a[in];
                    a[in] = a[in + 1];
                    a[in + 1] = tmp;
                }
            }
        }
        return a;
    }
}
