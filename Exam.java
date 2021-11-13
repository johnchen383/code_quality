import java.util.Vector;

/**
 * Refactoring question from 2021 exam
 */
public class Exam {

    private static boolean isInside(int x, int y, int z) {
        return false;
    }

    /**
     * ORIGINAL
     */

    // Given: position of Knight, target position, N (chessboard size N x N)
    // Return: minimum steps a Knight will take to reach the target position.
    // static int minStepToReachTargetBad(int knightPos[], int targetPos[], int N) {
    //     // x and y direction, where a knight can move
    //     int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
    //     int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
    //     // queue for storing states of knight in board
    //     Vector<cell> q = new Vector<>();
    //     // push starting position of knight with 0 distance
    //     q.add(new cell(knightPos[0], knightPos[1], 0));
    //     cell t;
    //     int x, y;
    //     boolean visit[][] = new boolean[N + 1][N + 1];
    //     // make all cell unvisited
    //     for (int i = 1; i <= N; i++)
    //         for (int j = 1; j <= N; j++)
    //             visit[i][j] = false;
    //     // visit starting state
    //     visit[knightPos[0]][knightPos[1]] = true;
    //     // loop until we have one element in queue
    //     while (!q.isEmpty()) {
    //         t = q.firstElement();
    //         q.remove(0);
    //         // if current cell is equal to target cell,
    //         // return its distance
    //         if (t.x == targetPos[0] && t.y == targetPos[1])
    //             return t.dis;
    //         // loop for all reachable states
    //         for (int i = 0; i < 8; i++) {
    //             x = t.x + dx[i];
    //             y = t.y + dy[i];
    //             // If reachable state is not yet visited and
    //             // inside board, push that state into queue
    //             if (isInside(x, y, N) && !visit[x][y]) {
    //                 visit[x][y] = true;
    //                 q.add(new cell(x, y, t.dis + 1));
    //             }
    //         }
    //     }
    //     return Integer.MAX_VALUE;
    // }

    /**
     * REFACTOR
     */

    /**
     * @param knightPos
     * @param targetPos
     * @param boardLength
     * @return minimum steps a Knight will take to reach the target position OR
     *         Integer.MAX_VALUE if no such path
     */
    static int findMinStepsForKnightToReachTarget(int knightPos[], int targetPos[], int boardLength) {
        // x and y direction, where a knight can move
        int deltaX[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int deltaY[] = { -1, -2, -2, -1, 1, 2, 2, 1 };

        // queue for storing states of knight in board
        Vector<Cell> queue = new Vector<>();
        boolean visit[][] = new boolean[boardLength + 1][boardLength + 1];

        initialiseBoard(queue, knightPos, boardLength, visit);

        return findMinStepsToReachTarget(queue, visit, deltaX, deltaY, targetPos);
    }

    /**
     * @param deltaX
     * @param deltaY
     * @param boardLength
     * @param piecePos
     * @param targetPos
     * @return minimum steps a piece will take to reach the target position OR
     *         Integer.MAX_VALUE if no such path
     */
    private static int findMinStepsToReachTarget(Vector<Cell> queue, boolean visit[][], int deltaX[], int deltaY[], int targetPos[]) {
        while (!queue.isEmpty()) {
            Cell selected = queue.firstElement();
            queue.remove(0);

            // if current cell is equal to target cell, return its distance
            if (selected.x == targetPos[0] && selected.y == targetPos[1]){
                return selected.dist;
            }

            updateBoardState(queue, selected, deltaX, deltaY, visit);
        }

        //no way to reach target cell, return infinity
        return Integer.MAX_VALUE;
    }

    /**
     * Update the board state (queue) when attempting to find minimum steps
     * @param queue
     * @param selected
     * @param deltaX
     * @param deltaY
     * @param visit
     */
    private static void updateBoardState(Vector<Cell> queue, Cell selected, int deltaX[], int deltaY[], boolean[][] visit){
        int boardLength = visit.length - 1;
        // loop for all reachable states
        for (int i = 0; i < deltaX.length; i++) {
            int x = selected.x + deltaX[i];
            int y = selected.y + deltaY[i];

            // If reachable state is not yet visited and
            // inside board, push that state into queue
            if (isInside(x, y, boardLength) && !visit[x][y]) {
                visit[x][y] = true;
                queue.add(new Cell(x, y, selected.dist + 1));
            }
        }
    }

    /**
     * Initialise the board for procuring minimum steps
     * 
     * @param queue
     * @param piecePos
     * @param boardLength
     * @param visit
     */
    private static void initialiseBoard(Vector<Cell> queue, int piecePos[], int boardLength, boolean visit[][]) {
        // push starting position of knight with 0 distance
        queue.add(new Cell(piecePos[0], piecePos[1], 0));

        // make all cell unvisited
        for (int i = 1; i <= boardLength; i++) {
            for (int j = 1; j <= boardLength; j++) {
                visit[i][j] = false;
            }
        }

        // visit starting state
        visit[piecePos[0]][piecePos[1]] = true;
    }

}


