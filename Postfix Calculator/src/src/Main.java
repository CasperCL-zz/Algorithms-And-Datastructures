package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Casper
 */
public class Main {

    public static void main(String[] args) {
        String input = null, postfix;
        int ans, ansS;
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);


        while (1 == 1) { // C-Style :D

            PuzzleGen pg = new PuzzleGen();
            String puzzle = pg.getPuzzle();
            String cleanPuzzle = pg.getCleanPuzzle(puzzle);// Clean means everything is ordered
            ans = PostFixCalc.calculate(puzzle);
            cleanPuzzle += "  =?= " + ans; // Present the answer to the real puzzle
            System.out.println("Make a correct arithmetic expression: " + cleanPuzzle);

            try {
                input = br.readLine();
            } catch (IOException exc) {
                exc.printStackTrace();
            }

            postfix = InToPost.translate(input);
            ansS = PostFixCalc.calculate(postfix);
            if (ansS == ans) {
                System.out.println("Correct!\nNext puzzle:");
            } else {
                System.out.println("False.. the answer to the calculation was: " + ans);
            }
        }
    }
}
