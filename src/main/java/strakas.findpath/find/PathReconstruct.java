package strakas.findpath.find;

import strakas.findpath.maze.Node;

import java.util.ArrayList;
import java.util.List;

class PathReconstruct {

    /**
     * Reconstructs the path from the target node back to the start.
     * @param endNode the target node
     * @return a string representing the sequence of moves.
     */
    public String reconstruct(Node endNode) {
        List<String> path = new ArrayList<>();
        Node current = endNode;
        while (current.getPrev() != null) {
            path.add(String.valueOf(current.getMove()));
            current = current.getPrev();
        }
        return String.join(",", path.reversed());
    }
}
