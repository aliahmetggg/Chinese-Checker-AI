
package aı.project;

public class AIProject 
{

    public static void main(String[] args) 
    {
        ChineseCheckerState board = new ChineseCheckerState();
        board.setStones();
        
        for (int y=0; y<board.boardSize; y++) 
        {
            for (int x=0; x<board.boardSize; x++) 
            {
                System.out.print(board.getBoardState()[y][x] + " ");
            }
            System.out.println();
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
