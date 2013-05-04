/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adsa1;

import java.awt.Dimension;
import java.util.Random;

/**
 *
 * @author Casper
 */
public class Main {

    private final static int MAXRANDOMX = 20;
    private final static int MAXRANDOMY = 20;
    private static int MAXARRAYLENGTH = (int) 20;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main m = new Main();
        Random r = new Random();
        GameObject gameObjects[] = new GameObject[MAXARRAYLENGTH];

        /**
         * **NEW WORLD 1***
         */
        // fill the game objects(random)
        
        for (int i = 0; i < gameObjects.length; i++) {
            gameObjects[i] = new GameObject(r.nextInt(MAXRANDOMX), r.nextInt(MAXRANDOMY));
        }
        //  Create the world
        World world1 = new World(gameObjects, new Dimension(MAXRANDOMX, MAXRANDOMY));
        world1.printWorld();
        long start = System.nanoTime();
        System.out.println(world1.getNumberObjectsOnLongestRow());
        long end = System.nanoTime();
        
        System.out.println((end - start));
    }
}
