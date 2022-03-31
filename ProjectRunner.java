
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
