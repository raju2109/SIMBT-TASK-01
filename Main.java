import java.lang.*;
import java.util.Scanner;

 class TicTacToe{
    static char[][] board=new char[3][3];
    static char currentPlayer='x';

    public static void main(String[] args){
        initializeBoard();
        printBoard();
        playGame();
    }

    public static void initializeBoard(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                board[i][j] = '-';
            }
        }
    }

    public static void printBoard(){
        System.out.println("-------------");
        for(int i=0; i<3; i++){
            System.out.print("| ");
            for(int j=0; j<3; j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    public static void playGame(){
        boolean gameFinished = false;
        while(!gameFinished){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter row (0-2) for " + currentPlayer + ": ");
            int row=scanner.nextInt();
            System.out.print("Enter row (0-2) for " + currentPlayer + ": ");
            int col=scanner.nextInt();

            if(row<0 || row>2 || col<0 || col>2)
            {
                System.out.println("Invalid row or column");
                continue;
            }

            if(board[row][col] != '-')
            {
                System.out.println("That spot is already taken");
                continue;
            }

            board[row][col] = currentPlayer;
            printBoard();

            if(checkForWin())
            {
                System.out.println(currentPlayer + " wins");
                gameFinished = true;
            }
            else if(checkForTie())
            {
                System.out.println("it's a tie!");
            }
            else {
                currentPlayer = (currentPlayer == 'X') ? '0' : 'X';
            }
        }
    }

    public static boolean checkForWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
            if (board[0][i] != '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2])
        {
            return true;
        }
        if  (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0])
        {
            return true;
        }
        return false;
    }

     public static boolean checkForTie() {
         for (int i = 0; i < 3; i++) {
             for (int j = 0; j < 3; j++) {
                 if (board[i][j] == '-') {
                     return false;
                 }
             }
         }
         return true;
     }
}