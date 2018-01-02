import java.util.Scanner;
public class Driver {

    public static void main (String[]args){
        Scanner scan = new Scanner(System.in);
        int dimensions;
        
        System.out.println("You are about to play game of 15! Enter your dimensions and press enter");
        dimensions = scan.nextInt();
        
        GameOf15 game = new GameOf15(dimensions);
        
        while(game.win() != true){
            game.displayBoard();
            System.out.print("Next Move: ");
            int move = scan.nextInt();
            if(game.swap(move) == false){
                System.out.println("invalid move");
            }
        }
        game.displayBoard();
        System.out.println("You've won the game! Congratulations");
    }
}
