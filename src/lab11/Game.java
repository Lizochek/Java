package lab11;

public class Game {
    private int mas[][]=new int[3][3];
    private int player=1;
    private GameState gameState ;

    public Game()
    {
        resetGame();
    }
    public boolean isWin(){
        for(int i=0;i<3;i++)
        {
           if(mas[0][i]==mas[1][i] && mas[1][i]==mas[2][i] && mas[0][i]==player)
           {
               return true;
           }
            if(mas[i][0]==mas[i][1] && mas[i][1]==mas[i][2] && mas[i][0]==player)
            {
                return true;
            }
        }
        if(mas[0][0]==mas[1][1] && mas[1][1]==mas[2][2] && mas[0][0]==player)
        {
            return true;
        }
        if(mas[0][2]==mas[1][1] && mas[1][1]==mas[2][0] && mas[0][2]==player)
        {
            return true;
        }
        return false;
    }
    public boolean setCell(int x,int y) {
        if(x<0 || x>=3 || y<0 || y>=3) return  false;
        if (mas[y][x] != 0 || gameState != GameState.GAME) return false;
        mas[y][x] = player;
        if (isWin()) gameState = player == 1 ? GameState.PLAYER1_WIN : GameState.PLAYER2_WIN;
        player=2-(player+1)%2;//переключаем игрока
        checkDraw();
        return true;
    }
    public  void checkDraw(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(mas[i][j]==0) return;
            }
        }
        gameState=GameState.DRAW;

    }
    public GameState getGameState(){
        return gameState;
    }
    public int getCellState(int x,int y){
        if(x<0 || x>=3 || y<0 || y>=3) return 0;
        return mas[y][x];

    }
    //сброс игры до нач сост
    public void resetGame(){
        player=1;
        gameState=GameState.GAME;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                mas[i][j]=0;
    }
    public void doAITurn(){
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(mas[i][j]==0) {
                    setCell(j, i);
                    return;
                }
    }
}
