import  java.util.Scanner;
public class HumanPlayer implements Player {

    public void playTurn(Board board, Mark mark){
        System.out.print("Enter an integer (row and col): ");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int row=Math.floorDiv(num,10);
        int col=num%10;
        board.putMark(row,col,mark);

    }
}
