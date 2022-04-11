public class DictionaryWord {
    public static int no = 0;
    private String word;
    private String meaning;
    private int num;
    public DictionaryWord(String word, String meaning, int num)
    {
        this.word = word;
        this.meaning = meaning;
        this.num = num;
        no = no + 1;
    }
    public DictionaryWord() {}
    public String getWord()
    {
        return word;
    }
    public void setWord(String word)
    {
        this.word = word;
    }
    public String getMeaning()
    {
        return meaning;
    }
    public void setMeaning(String meaning)
    {
        this.meaning = meaning;
    }
    public String toString()
    {
        return (num+1) + "." + word + "\n" + meaning + "\n";
    }
}
