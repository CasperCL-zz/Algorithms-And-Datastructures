/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adsa1;

import java.awt.Dimension;

/**
 *
 * @author Casper
 */
public class World {

    private GameObject gObjs[];
    private Dimension dim; // The dimensions of the world

    public World(GameObject objs[], Dimension dim) {
        gObjs = objs;
        this.dim = dim;
    }

    /**
     * Calculate the possible collision with 1 or more objects on a tile.
     *
     * @return multipleCollisons
     */
    public double calculateCollision() {
        double noDouble = 1;
        double multipleCollisons;
        double unique = -1;
        double x = dim.getWidth();
        double y = dim.getHeight();
        double tiles;
        final double tilesMAX = x * y;


        // Calculate the chance of no double
        for (tiles = x * y; tiles >= (tilesMAX - gObjs.length + 1); tiles--) {
            unique = (tiles / tilesMAX);
            noDouble *= unique;
        }
        multipleCollisons = 1 - noDouble;
        return multipleCollisons;
    }

    /**
     * Calculates the amount of objects on the lower part of the world
     *
     * @return amount of objects.
     */
    public int getAmountLowerPart() {
        int amount = -1;
        // Initialize the lower part
        double lowerPart = (dim.getHeight() / 2);

        for (GameObject obj : gObjs) {
            if (obj.getY() < lowerPart) {
                amount++;
            }
        }

        return amount;
    }

    /**
     * Calculates the amount of GameObjects on the same row (Y-axis)
     *
     * @return
     */
    public int getAmountSameRow() {
        int amount = -1;

        for (GameObject obj : gObjs) {
            for (GameObject obj1 : gObjs) {
                if (obj.getY() == obj1.getY()) {
                    amount++;
                }
            }
        }

        return amount;
    }

    public int getAmountOfCollisions() {
        int amount = -1;

        for (GameObject obj : gObjs) {
            for (GameObject obj1 : gObjs) {
                if ((obj.getY() == obj1.getY()) && (obj.getX() == obj1.getX())) {
                    amount++;
                }
            }
        }

        return amount;
    }

    /**
     * Calculates the empty tiles in the world
     *
     * @return
     */
    public int getEmptyTiles() {
        int amount;
        int tiles = (int) (dim.getHeight() * dim.getWidth()); // Cast is safe because it will always result into an int anyway
        int full = 0;

        for (int x = 0; x < dim.getHeight(); x++) {
            for (int y = 0; y < dim.getWidth(); y++) {
                for (GameObject obj : gObjs) {
                    if (obj.getX() == x && obj.getY() == y) {
                        full++;
                        break;
                    }
                }
            }
        }
        amount = tiles - full;

        return amount;
    }

    /**
     * Calculates the row with the first item
     *
     * @return an Array of the tile locations of time Dimension
     */
    public Dimension[] getLeftRowFirstItem() {
        Dimension rows[] = new Dimension[(int) dim.getHeight()];
        boolean found = false;

        // Go over every column
        for (int y = 0; y < dim.getHeight(); y++) {
            for (int x = 0; x < dim.getWidth(); x++) {
                for (GameObject obj : gObjs) {
                    if (obj.getX() == x && obj.getY() == y) {
                        rows[x] = new Dimension(obj.getX(), obj.getY());
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    rows[x] = new Dimension(0, 0);
                }
                found = false;
            }
        }

        return rows;
    }

    /**
     * Calculates the largest amount of objects on a row
     *
     * @return nrObjects
     */
    public int getNumberObjectsOnLongestRow() {
        int objectsLastRow = -1;
        int objectsThisRow = 0;

        for (int y = 0; y < dim.getHeight(); y++) {
            for (int x = 0; x < dim.getWidth(); x++) {
                for (GameObject obj : gObjs) { // Search for an object on this coordinates
                    if ((obj.getX() == y && obj.getY() == x)) {
                        objectsThisRow++;
                    }
                }
                if (objectsThisRow > objectsLastRow) {
                    objectsLastRow = objectsThisRow;
                }
                objectsThisRow = 0;
            }
        }
        return objectsLastRow;
    }

    /**
     * Prints out the world whereas a 1 respresents an object and a 0 an empty
     * tile.
     *
     */
    public void printWorld() {
        boolean found = false;
        System.out.println("----- START OF WORLD -----");
        for (int x = 0; x < dim.getHeight(); x++) {
            for (int y = 0; y < dim.getWidth(); y++) {
                for (GameObject obj : gObjs) { // Search for an object on this coordinates
                    if ((obj.getX() == x && obj.getY() == y)) {
                        System.out.print("1");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.print("0");
                }
                found = false;
            }
            System.out.print("\n");
        }
        System.out.println("------ END OF WORLD ------");
    }
}
