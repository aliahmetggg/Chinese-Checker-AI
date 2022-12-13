package aı.project;

public class ChineseCheckerState 
{
    final int boardSize = 8;
    private final int boardState[][];

    public ChineseCheckerState() 
    {
        boardState = new int[boardSize][boardSize];
        
        for (int y=0; y<boardSize; y++) 
        {			
            for (int x=0; x<boardSize; x++) 
            {
                this.boardState[y][x] = 0;
            }
	}
    }
    
    public int[][] setStones()
    {
        for (int y=0; y<boardSize-5; y++) 
        {			
            for (int x=0; x<boardSize-5; x++) 
            {
                this.boardState[y][x] = 1;
                this.boardState[boardSize-y-1][boardSize-x-1] = 2;
            }
	}
        
        return boardState;
    }

    public int[][] getBoardState() 
    {
        return boardState;
    }
    
    public int isComplete()
    {
        int counter1 = 0;
        int counter2 = 0;
        for (int y=0; y<boardSize-5; y++) 
        {			
            for (int x=0; x<boardSize-5; x++) 
            {
                if (this.boardState[y][x] == 2)
                {
                    counter1++;
                }
                if (this.boardState[boardSize-y-1][boardSize-x-1] == 1)
                {
                    counter2++;
                }
            }
	}
        
        if (counter1 == 9)
        {
            return 1;
        }
        else if (counter2 == 9)
        {
            return 2;
        }
        return 0;
    }
    
    
}
