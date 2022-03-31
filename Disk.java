

import java.awt.Color;
import java.util.Random;
import CS2114.Shape;

/**
 *
 * @author Kirsten Chesley (kchesley888)
 * @version (2020-Mar-25)
 * 
 */
public class Disk extends Shape implements Comparable<Disk> {
    
    /**
     * 
     * @param width the width of the disk
     */
    public Disk(int width) {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        Random r = new Random();
        Color c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
        this.setBackgroundColor(c);
    }


    @Override
    public String toString() {
        return "" + this.getWidth() + "";
    }


    /**
     * checks if two disks are equal
     * 
     * @param obj
     *            the object
     * @return returns true if equal width
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj == null) {
            return false;
        }
        else if (this.getClass() != obj.getClass()) {
            return false;
        }
        Disk d = (Disk)obj;

        return (this.getWidth() == d.getWidth());
    }


    /**
     * compares a disk to another
     * @param otherDisk the other disk
     * @return returns the size difference
     */
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }
        return this.getWidth() - otherDisk.getWidth();
    }

}
