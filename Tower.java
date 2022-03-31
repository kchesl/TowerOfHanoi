
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
