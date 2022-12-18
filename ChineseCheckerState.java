

public class ChineseCheckerState 
{
    final int boardSize;
    private final int boardState[][];

    public ChineseCheckerState(int boardSize) 
    {
        boardState = new int[boardSize][boardSize];
        this.boardSize = boardSize;
        
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
        for (int y=0; y<boardSize-(boardSize/2 + 1); y++) 
        {			
            for (int x=0; x<boardSize-(boardSize/2 + 1); x++) 
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
    
    public void printBoard()
    {
        for (int y=0; y<this.boardState.length; y++) 
        {
            for (int x=0; x<this.boardState.length; x++) 
            {
                System.out.print(boardState[y][x] + " ");
            }
            System.out.println();
        }
        System.out.println("\n\n");
    }
    
    public void printPlayer1Board()
    {
        int counter = 1;
        System.out.println("Oynamak istediğiniz taşı tuşlayın!");
        for (int y=0; y<this.boardState.length; y++) 
        {
            for (int x=0; x<this.boardState.length; x++) 
            {
                if (boardState[y][x] == 1)
                {
                    System.out.print(counter + " ");
                    counter++;
                }
                else if (boardState[y][x] == 2)
                {
                    System.out.print("* ");
                }
                else
                {
                    System.out.print(boardState[y][x] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("\n\n");
    }
    
    public void printPlayer2Board()
    {
        int counter = 1;
        System.out.println("Oynamak istediğiniz taşı tuşlayın!");
        for (int y=0; y<this.boardState.length; y++) 
        {
            for (int x=0; x<this.boardState.length; x++) 
            {
                if (boardState[y][x] == 2)
                {
                    System.out.print(counter + " ");
                    counter++;
                }
                else if (boardState[y][x] == 1)
                {
                    System.out.print("* ");
                }
                else
                {
                    System.out.print(boardState[y][x] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("\n\n");
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
    
    public void moveRight(int posX, int posY)
    {
        if (posY >=this.boardState.length-1) 
        {
            System.out.println("Invalid movement!");
        }
        else{
            if (this.boardState[posX][posY+1] != 0) 
            {
                System.out.println("Invalid movement there is a stone!");
            }
            else
            {
                int taraf = this.boardState[posX][posY];
                this.boardState[posX][posY] = 0;
                this.boardState[posX][posY+1] = taraf;
            }
        }
    }
    
    public void moveLeft(int posX, int posY){
        if (posY <=0) {
            System.out.println("Invalid movement!");
        }
        else{
            if (this.boardState[posX][posY-1] != 0) {
                System.out.println("Invalid movement there is a stone!");
            }
            else{
                int taraf = this.boardState[posX][posY];
                this.boardState[posX][posY] = 0;
                this.boardState[posX][posY-1] = taraf;
            }
        }
    }
    
    public void moveUp(int posX, int posY)
    {
        if (posX <=0) 
        {
            System.out.println("Invalid movement!");
        }
        else{
            if (this.boardState[posX-1][posY] != 0) 
            {
                System.out.println("Invalid movement there is a stone!");
            }
            else
            {
                int taraf = this.boardState[posX][posY];
                this.boardState[posX][posY] = 0;
                this.boardState[posX-1][posY] = taraf;
            }
        }
    }
    public void moveDown(int posX, int posY)
    {
        if (posX >=this.boardState.length-1) 
        {
            System.out.println("Invalid movement!");
        }
        else
        {
            if (this.boardState[posX+1][posY] != 0) 
            {
                System.out.println("Invalid movement there is a stone!");
            }
            else
            {
                int taraf = this.boardState[posX][posY];
                this.boardState[posX][posY] = 0;
                this.boardState[posX+1][posY] = taraf;
            }
        }
    }
    
    public void jumpUp(int posX, int posY){
        if (posX <= 1) {
            System.out.println("Movement Out of map!");
        }
        else{
            if ((this.boardState[posX-1][posY] != 0 && this.boardState[posX-2][posY] == 0)) {
                int taraf = this.boardState[posX][posY];
                this.boardState[posX][posY] = 0;
                this.boardState[posX-2][posY] = taraf;
            }
            else{
                System.out.println("Invalid jump!");
            }
        }
    }
    public void jumpDown(int posX, int posY){
        if (posX >=this.boardState.length-2) {
            System.out.println("Movement Out of map!");
        }
        else{
            if ((this.boardState[posX+1][posY] != 0 && this.boardState[posX+2][posY] == 0)) {
                int taraf = this.boardState[posX][posY];
                this.boardState[posX][posY] = 0;
                this.boardState[posX+2][posY] = taraf;
            }
            else{
                System.out.println("Invalid jump!");
            }
        }
    }
    public void jumpRight(int posX, int posY){
        if (posY >=this.boardState.length-2) {
            System.out.println("Movement Out of map!");
        }
        else{
            if ((this.boardState[posX][posY+1] != 0 && this.boardState[posX][posY+2] == 0)) {
                int taraf = this.boardState[posX][posY];
                this.boardState[posX][posY] = 0;
                this.boardState[posX][posY+2] = taraf;
            }
            else{
                System.out.println("Invalid jump!");
            }
        }
    }
    public void jumpLeft(int posX, int posY){
        if (posY <= 1) {
            System.out.println("Movement Out of map!");
        }
        else{
            if ((this.boardState[posX][posY-1] != 0 && this.boardState[posX][posY-2] == 0)) {
                int taraf = this.boardState[posX][posY];
                this.boardState[posX][posY] = 0;
                this.boardState[posX][posY-2] = taraf;
            }
            else{
                System.out.println("Invalid jump!");
            }
        }
    }
    
}
