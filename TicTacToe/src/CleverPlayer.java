public class CleverPlayer implements Player {
    public void playTurn(Board board, Mark mark) {
        for (int row = 0; row < board.SIZE; row++) {
            for (int col = 0; col < board.SIZE; col++) {
                if (board.getMark(row, col) == Mark.BLANK) {
                    board.putMark(row, col, mark);
                    return;
                }
            }

        }
    }
}
