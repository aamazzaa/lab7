import java.util.Arrays;

public class Automaton {
    private final int numberOfCells;
    private int[] state;

    /**
     * Create a 1D automaton consisting of the given number of cells.
     * @param numberOfCells The number of cells in the automaton.
     */
    public Automaton(int numberOfCells) {
        this.numberOfCells = numberOfCells;
        state = new int[numberOfCells];
        // Seed the automaton with multiple 'on' cells in the middle.
        for (int i = numberOfCells / 2 - 1; i <= numberOfCells / 2 + 1; i++) {
            state[i] = 1;
        }
    }

    /**
     * Print the current state of the automaton.
     */
    public void print() {
        for (int cellValue : state) {
            if (cellValue == 1) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    /**
     * Update the automaton to its next state.
     */
    public void update() {
        // Build the new state in a separate array.
        int[] nextState = new int[state.length];
        // Naively update the state of each cell based on the state of its two neighbors.
        for (int i = 0; i < state.length; i++) {
            int left = (i == 0) ? 0 : state[i - 1];
            int center = state[i];
            int right = (i + 1 < state.length) ? state[i + 1] : 0;
            nextState[i] = (left + center + right) % 2;
        }
        state = nextState;
    }

    /**
     * Reset the automaton to its initial state.
     */
    public void reset() {
        Arrays.fill(state, 0);
        // Seed the automaton with multiple 'on' cells in the middle.
        for (int i = numberOfCells / 2 - 1; i <= numberOfCells / 2 + 1; i++) {
            state[i] = 1;
        }
    }

    /**
     * Calculate the next state for a given cell.
     * @param left The state of the left neighbor.
     * @param center The state of the current cell.
     * @param right The state of the right neighbor.
     * @return The next state of the cell.
     */
    public int calculateNextState(int left, int center, int right) {
        return (left + center + right) % 2;
    }
}
