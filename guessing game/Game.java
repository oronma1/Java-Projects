import java.util.Scanner;

// Represents a guessing game object. Initialize a game object and call the start method to begin playing. 
public class Game {

    private final ChosenWord word;
    private int NumOfGuss;
    private String LetterPool;
    private String CurrentWord;
    private static final int NUMB_OF_ALPHABETS = 26;
    private static final int ONE_CHAR = 1;


    public Game(){
        ChosenWord CW = new ChosenWord();
        this.word = CW;
        this.NumOfGuss = 0;
        LetterPool = "abcdefghijklmnopqrstuvwxyz";
        CurrentWord = "";
        for ( int i=0; i<CW.getLength();i++)
        {
            CurrentWord = CurrentWord.concat("_");
        }

    }

    public void StartGame(){
        boolean EndGame = false;
        boolean Win = false;
        String input;

        Scanner scan = new Scanner(System.in);
        System.out.printf("%n%nWelcome to the word guessing game. You will need to guess a random word. In each turn you will guess one character.%n");
        System.out.printf("To exit at any time, enter 'exit'%n%n");

        while (!Win && !EndGame){
            System.out.println("\nguss this word :    "+ CurrentWord);
            System.out.println("your LetterPool is :    " + getLetterPool());
            input = scan.nextLine();

            if (input.equals("exit")) {
                EndGame=true;
                continue;
            }
            if(!LegalInput(input))
                continue;

            LetterPool = UpdateLetterPool(LetterPool,input.charAt(0));
            NumOfGuss++;
            if (word.CharInWord(input))
            {
                System.out.println("Nice,this is a correct letter!!!");
                CurrentWord = UpdateCurrentWord(CurrentWord,input,word);
                if (checkIfWin(CurrentWord,word.getWord()))
                   Win = true;
            }
        }

        if (Win) {
            System.out.println("\n**** Well done, you won the game!! **** \n The word is:  " + word.getWord());
            System.out.println("Your number of attempts is:  " + NumOfGuss + "\n");
        }

    }


    public String UpdateCurrentWord(String CurWord,String ch,ChosenWord CW){
        char[] NewCurWord = CurWord.toCharArray();
        int pos = CW.getWord().indexOf(ch);

        while(pos >= 0) {
            NewCurWord[pos] = ch.charAt(0);
            if (pos==CurWord.length()-1){
                pos=-1;
            }
            else {
                pos = CW.getWord().indexOf(ch, pos + 1);
            }
        }

         CurWord = String.valueOf(NewCurWord);
            return CurWord;
    }

    public Boolean checkIfWin(String CurWord,String CW){
        return CurWord.equals(CW);
    }

    public boolean LegalInput(String input){
        boolean check = true;

        if (input.equals("")){
            System.out.println("Error:  blank character");
            check=false;
        }
        else if(input.length() > ONE_CHAR){
            System.out.println("Error: You entered more than one letter ");
            check=false;
        } else if (!(input.charAt(0) >= 'a' && input.charAt(0) <= 'z') ) {
            System.out.println("Error: Invalid character input");
            check=false;
        } else if (!LetterPool.contains(input)) {
            System.out.println("You've already tried this letter!?!?!");
            check=false;
        }

        return check;
    }

    public String UpdateLetterPool(String LetterPool, char ch){

        LetterPool = LetterPool.replace(ch,'-');

        return LetterPool;
    }
    public String getLetterPool(){
        StringBuilder NewLetterPool = new StringBuilder();
        for (int i = 0; i< NUMB_OF_ALPHABETS; i++)
        {
            if (LetterPool.charAt(i) != '-')
                NewLetterPool.append(LetterPool.charAt(i)).append(" ");
        }

        return NewLetterPool.toString();
    }



}