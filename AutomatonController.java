public class AutomatonController {
    private Automaton auto;

    /**
     * Create an AutomatonController with a specified number of cells.
     * @param numberOfCells The number of cells in the automaton.
     */
    public AutomatonController(int numberOfCells) {
        auto = new Automaton(numberOfCells);
        auto.print();
    }

    /**
     * Create an AutomatonController with the default number of cells (50).
     */
    public AutomatonController() {
        this(50);
    }

    /**
     * Run the automaton for the given number of steps.
     * @param numSteps The number of steps to run.
     */
    public void run(int numSteps) {
        for (int step = 1; step <= numSteps; step++) {
            step();
        }
    }

    /**
     * Run the automaton for a single step.
     */
    public void step() {
        auto.update();
        auto.print();
    }

    /**
     * Reset the automaton to its initial state.
     */
    public void reset() {
        auto.reset();
        auto.print();
    }
}
