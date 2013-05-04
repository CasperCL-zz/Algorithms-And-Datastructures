package pTools;

import java.io.PrintStream;

/**
 *
 * @author Casper
 */
public class Debugger {

    private static PrintStream ps = new PrintStream(System.out);
    private final static boolean VERBOSE = false;

    public static void println(String out) {
        if (VERBOSE) {
            ps.println(out);
        }
    }

    public static void println(int out) {
        if (VERBOSE) {
            ps.println(out);
        }
    }

    public static void println() {
        if (VERBOSE) {
            ps.println('\n');
        }
    }

    public static boolean status() {
        return VERBOSE;
    }
}
