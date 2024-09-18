import java.util.Random;

public class Tournament {
    private final Player player1;
    private final Player player2;
    private final int rounds;
    private final Renderer rend;
    public Tournament(Player player1, Player player2, Renderer renderer, int rounds) {
        this.player1=player1;
        this.player2=player2;
        this.rounds=rounds;
        this.rend=renderer;
    }
    public int[] playTournament(){
        int [] score={0,0,0};
        for (int i=0;i<rounds;i++){
            Game game=new Game(this.player1,this.player2,this.rend);
            Mark mark=game.run();
            if (mark==Mark.X){ score[0]+=1; }
            if (mark==Mark.O){ score[1]+=1; }
            if (mark==Mark.BLANK){ score[2]+=1; }
            System.out.printf("player1 scored: %d, player2 scored: %d. Draws: %d\r",score[0],score[1],score[2]);
        }
        return score;


    }
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

    }
}
