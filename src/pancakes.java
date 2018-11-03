// --------------------------------------
// pancakes.java
// Jeremy Campbell
// Practice using a Breadth First Search
// --------------------------------------
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class pancakes {

    public static class PancakeStackState {
        PancakeStackState(String stack, int numHops) {
            state = stack;
            numHopsToState = numHops;
        }
        public String state;
        public int numHopsToState;
    }

    public static class PancakeStackManager {

        private String pancakeStack;
        private String solution;

        public void inputPancakes(String lineOfPancakes) {
            pancakeStack = lineOfPancakes;
            char[] c = pancakeStack.toUpperCase().toCharArray();
            Arrays.sort(c);
            solution = new String(c);
        }

        // Implements a Breadth First Search
        public int createBestDisplayArrangement() {
            LinkedList<PancakeStackState> pQueue = new LinkedList<>();
            Set<String> pSet = new HashSet<>();
            int numFlips = 0;

            // Mark and insert the initial configuration into the queue
            pSet.add(pancakeStack);
            pQueue.add(new PancakeStackState(pancakeStack, numFlips));

            while (!pQueue.isEmpty()) {
                PancakeStackState currentStackState = pQueue.peek(); pQueue.remove();
                if (!currentStackState.state.equals(solution)) {
                    // Find new solutions and push them on the queue if they are not marked
                    for (int i = 0; i < currentStackState.state.length(); i++) {
                        String newStack = findNewStack(currentStackState.state, i);
                        if (!pSet.contains(newStack)) {
                            pQueue.add(new PancakeStackState(newStack, currentStackState.numHopsToState + 1));
                            pSet.add(newStack);
                        }
                    }
                } else {
                    numFlips = currentStackState.numHopsToState;
                    pQueue.clear();
                }
            }
            return numFlips;
        }

        private String findNewStack(String currentStack, int indexToFlip) {
            String firstPart = currentStack.substring(0, indexToFlip);
            StringBuilder sb = new StringBuilder(currentStack.substring(indexToFlip));
            sb.reverse();
            char[] ca = sb.toString().toCharArray();

            for (int i = 0; i < sb.length(); i++) {
                if (Character.isLowerCase(ca[i])) {
                    ca[i] = Character.toUpperCase(ca[i]);
                } else {
                    ca[i] = Character.toLowerCase(ca[i]);
                }
            }
            String newStack = firstPart + new String(ca);
            return newStack;
        }

    }


    public static void main(String[] args) throws IOException {
        Scanner fin = new Scanner(new File("pancakes.in"));
        PrintWriter fout = new PrintWriter(new File("pancakes.out"));

        String line = fin.nextLine();
        while (line != null && !line.equals("0")) {
            PancakeStackManager psm = new PancakeStackManager();
            psm.inputPancakes(line);
            int numFlips = psm.createBestDisplayArrangement();
            fout.print(numFlips);

            line = fin.nextLine();
            if (!line.equals("0"))
                fout.println();
        }

        fin.close();
        fout.close();
    }

}
