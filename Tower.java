// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Kirsten Chesley (kchesley888)
package towerofhanoi;

/**
 *
 * @author Kirsten Chesley (kchesley888)
 * @version (2020-Mar-25)
 */
public class Tower extends LinkedStack<Disk> {
    private Position position;

    /**
     * states the towers position
     * 
     * @param position the position
     */
    public Tower(Position position) {
        super();
        this.position = position;
    }


    /**
     * returns the position
     * 
     * @return returns the position
     */
    public Position position() {
        return this.position;
    }


    @Override
    public void push(Disk disk) {
        if (disk == null) {
            throw new IllegalArgumentException();
        }
        else if (this.size() >= 0) {
            super.push(disk);
            
        }
        else {
            throw new IllegalStateException();
        }
    }
}
