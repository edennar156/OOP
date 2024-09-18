public class Game {
    Player playerX;
    Player playerO;
    Renderer renderer;
    public Game(Player playerX, Player playerO, Renderer renderer){
        this.playerX = playerX;
        this.playerO = playerO;
        this.renderer = renderer;

    }
    public Mark run(){
        Board board = new Board();
        renderer.renderBoard(board);
        Player currentPlayer = playerX;
        Mark mark=Mark.X;
        while(true){
            currentPlayer.playTurn(board,mark);
            renderer.renderBoard(board);

            // Check for win
            if (board.checkWin(mark)) {
                System.out.println("Player " + mark + " wins!");
                return mark;
            }

            // Check for tie
            if (board.isFull()) {
                System.out.println("The game is a tie!");
                return Mark.BLANK;
            }
            if (currentPlayer == playerX){
                currentPlayer = playerO;
                mark = Mark.O;
            }
            else {
                currentPlayer = playerX;
                mark = Mark.X;
            }

        }

    }

}
