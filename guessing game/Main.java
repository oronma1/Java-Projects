import java.util.Scanner;

public class Main {
        public static void main (String[] args){
                boolean play = true;
                String input;
                Scanner scan = new Scanner(System.in);
                while(play)
                {
                        Game game = new Game();
                        game.StartGame();
                        System.out.println("To replay press 'yes' \n to exit press on any key");
                        input = scan.nextLine();
                        if (!(input.equals("yes")))
                                play=false;
                }


        }
}