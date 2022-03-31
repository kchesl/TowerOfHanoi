package towerofhanoi;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Kirsten Chesley (kchesley888)

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import CS2114.Button;
import CS2114.Shape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 *
 * @author Kirsten Chesley (kchesley888)
 * @version (2020-Mar-28)
 */
@SuppressWarnings("deprecation")
public class PuzzleWindow implements Observer {

    private HanoiSolver game;
    private Shape left;
    private Shape middle;
    private Shape right;
    private Window window;

    public static final int DISK_GAP = 0;
    public static final int DISK_HEIGHT = 10;
    public static final int WIDTH_FACTOR = 100;

    /**
     * constructor for the game
     * 
     * @param game
     *            the game
     */
    public PuzzleWindow(HanoiSolver game) {
        this.game = game;
        game.addObserver(this);
        window = new Window("Tower of Hanoi");
        left = new Shape(200, 150, 5, 100, new Color(50, 50, 50));
        middle = new Shape(300, 150, 5, 100, new Color(50, 50, 50));
        right = new Shape(400, 150, 5, 100, new Color(50, 50, 50));

        for (int i = 0; i < game.disks(); i++) {
            game.getTower(Position.RIGHT).push(new Disk(10 * game.disks() - 
                (10 * i)));
            window.addShape(game.getTower(Position.RIGHT).peek());
            moveDisk(Position.RIGHT);
        }

        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);

        Button solve = new Button("Solve");
        window.addButton(solve, WindowSide.SOUTH);
        solve.onClick(this, "clickedSolve");

    }


    /**
     * sleep method
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }


    /**
     * solves the game
     * 
     * @param button
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }


    /**
     * moves the disks
     * 
     * @param position
     */
    private void moveDisk(Position position) {
        Disk currentDisk = game.getTower(position).peek();
        Shape currentPole;
        switch (position) {
            case LEFT:
                currentPole = left;
                break;
            case MIDDLE:
                currentPole = middle;
                break;
            case RIGHT:
                currentPole = right;
                break;
            default:
                currentPole = middle;
                break;

        }
        int x = currentPole.getX();
        int y = currentPole.getY();
        int width = currentPole.getWidth() / 2;
        int height = currentPole.getHeight();
        int size = game.getTower(position).size() * DISK_HEIGHT;
        
        currentDisk.moveTo(x - currentDisk.getWidth() / 2 + width, 
            y + height - size);
    }


    @Override
    public void update(Observable o, Object arg) {
        if (arg.getClass() == Position.class) {
            moveDisk((Position)arg);

        }
        sleep();

    }

}
