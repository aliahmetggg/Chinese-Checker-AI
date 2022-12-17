
import java.util.Scanner;

public class AIProject 
{

    public static void main(String[] args) 
    {
        ChineseCheckerState board = new ChineseCheckerState(5);
        board.setStones();
        Scanner in = new Scanner(System.in);
        //board.printBoard();
        
        board.moveRight(1, 1);
        
        //board.printBoard();

        int playerIndex = 1;
        
        while (true)
        {
            playerIndex++;

            if (playerIndex % 2 == 0)
            {
                System.out.println("Player 1");
                board.printPlayer1Board();
            }
            else if (playerIndex % 1 == 1)
            {
                System.out.println("Player 2");
            }

            if (board.isComplete() == 1)
            {
                System.out.println("Player 2 wins");
            }
            else if (board.isComplete() == 2)
            {
                System.out.println("Player 1 wins");
            }
        }
    }
    
}
