package towerofhanoi;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Kirsten Chesley (kchesley888)

/**
 *
 * @author Kirsten Chesley (kchesley888)
 * @version (2020-Mar-28)
 */
public class ProjectRunner {

    /**
     * constructor left empty
     */
    public ProjectRunner() {
        // left empty
    }


    /**
     * project runner
     * 
     * @param args string
     */
    public static void main(String[] args) {
        int d = 5;
        if (args.length == 1) {
            d = Integer.parseInt(args[0]);
        }
        HanoiSolver game = new HanoiSolver(d);
        PuzzleWindow window = new PuzzleWindow(game);

    }

}
