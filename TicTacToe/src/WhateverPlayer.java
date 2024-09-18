import java.util.ArrayList;
import java.util.Random;
public class WhateverPlayer implements Player {
    private Board board;

    @Override
    public void playTurn(Board board, Mark mark) {
        ArrayList<ArrayList<Integer>> dynamic2DArray = new ArrayList<>();
        for (int i = 0; i < board.getSize(); i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getMark(i, j) == Mark.BLANK) {
                    row.add(i);
                    row.add(j);
                }
            }
            if (!row.isEmpty()) {
                dynamic2DArray.add(row);
            }
        }
        Random rand = new Random();
        int randomIndex = rand.nextInt(dynamic2DArray.size());
        int row=dynamic2DArray.get(randomIndex).get(0);
        int col=dynamic2DArray.get(randomIndex).get(1);
        board.putMark(row, col, mark);

    }
}
