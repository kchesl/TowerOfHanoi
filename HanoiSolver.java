

import java.util.Observable;

/**
 *
 * @author Kirsten Chesley (kchesley888)
 * @version (2020-Mar-25)
 */
@SuppressWarnings("deprecation")
public class HanoiSolver extends Observable {
    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;

    /**
     * constructor
     * 
     * @param numDisks the number of disks
     */
    public HanoiSolver(int numDisks) {
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
        this.numDisks = numDisks;
    }


    /**
     * returns the number of disks
     * 
     * @return the number of disks
     */
    public int disks() {
        return numDisks;
    }


    /**
     * returns the towers position
     * 
     * @param position the position
     * @return returns the position
     * 
     */
    public Tower getTower(Position position) {
        switch (position) {
            case LEFT:
                return left;
            case MIDDLE:
                return middle;
            case RIGHT:
                return right;
            default:
                return middle;
        }
    }


    /**
     * the toString
     * @return returns a string
     */
    public String toString() {
        StringBuilder string = new StringBuilder("");
        string.append(left.toString());
        string.append(middle.toString());
        string.append(right.toString());
        return string.toString();

    }


    /**
     * moves the disks
     * 
     * @param source
     * @param destination
     */
    private void move(Tower source, Tower destination) {
        Disk disk = source.pop();
        destination.push(disk);

        this.setChanged();
        this.notifyObservers(destination.position());

    }


    /**
     * solves the puzzle
     * 
     * @param currentDisks
     * @param start
     * @param temp
     * @param end
     */
    private void solveTowers(int currentDisks, Tower startPole, 
        Tower tempPole, Tower endPole) {
        if (currentDisks == 1) {
            this.move(startPole, endPole);
        }
        else if (currentDisks > 1) {
            this.solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            this.solveTowers(1, startPole, tempPole, endPole);
            this.solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }


    /**
     * recursion for solving the towers
     */
    public void solve() {
        this.solveTowers(this.numDisks, this.right, this.middle, this.left);
    }

}
