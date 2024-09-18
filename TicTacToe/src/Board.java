public class Board {
    public static final int SIZE=5;
    public static final int WIN_STREAK=3;
    private Mark[][] board;
    public Board() {
        board= new Mark[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = Mark.BLANK; // Initialize all positions with EMPTY
            }
        }

    }
    public int getSize(){
        return SIZE;
    }

    public Mark getMark(int i, int j) {
        if (i>=0 && i<SIZE && j>=0 && j<SIZE) {
            return board[i][j];
        }
        else {
            throw new IndexOutOfBoundsException("Invalid position on the board");
        }
    }

    public boolean putMark(int i, int j, Mark mark) {
        if (i>=0 && i<SIZE && j>=0 && j<SIZE) {
            board[i][j] = mark;
            return true;
        }
        else {
            return false;
        }
    }
    // Check for win condition
    public boolean checkWin(Mark mark) {
        // Check rows, columns, and diagonals for win
        return checkRows(mark) || checkCols(mark) || checkDiagonals(mark);
    }

    private boolean checkRows(Mark mark) {
        for (int i = 0; i < SIZE; i++) {
            int count = 0;
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == mark) {
                    count++;
                    if (count == WIN_STREAK) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    private boolean checkCols(Mark mark) {
        for (int j = 0; j < SIZE; j++) {
            int count = 0;
            for (int i = 0; i < SIZE; i++) {
                if (board[i][j] == mark) {
                    count++;
                    if (count == WIN_STREAK) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonals(Mark mark) {
        // Check main diagonal
        for (int i = 0; i <= SIZE - WIN_STREAK; i++) {
            for (int j = 0; j <= SIZE - WIN_STREAK; j++) {
                if (checkDiagonal(mark, i, j, 1, 1) || checkDiagonal(mark, i, j + WIN_STREAK - 1, 1, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonal(Mark mark, int startRow, int startCol, int rowIncrement, int colIncrement) {
        int count = 0;
        for (int i = 0; i < WIN_STREAK; i++) {
            if (board[startRow + i * rowIncrement][startCol + i * colIncrement] == mark) {
                count++;
                if (count == WIN_STREAK) {
                    return true;
                }
            } else {
                break;
            }
        }
        return false;
    }

    // Check if the board is full
    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == Mark.BLANK) {
                    return false;
                }
            }
        }
        return true;
    }
}

