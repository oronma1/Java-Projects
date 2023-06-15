public class ChosenWord {

    private final String word;
    private final int length;

    public ChosenWord(){
        Vocabulary v = new Vocabulary();
        this.word = v.RandWord();
        this.length = this.word.length();
    }

    public String getWord()
    {
        return this.word;
    }

    public int getLength(){
        return this.length;
    }

    public Boolean CharInWord(String ch){
        return this.word.contains(ch);
    }


}
