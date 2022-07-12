import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        ArrayList<DictionaryWord> dictionarylist = new ArrayList<DictionaryWord>();
        DictionaryWord dictionary1 = new DictionaryWord("bank robber", "Steals money from a bank", DictionaryWord.no);
        DictionaryWord dictionary2 = new DictionaryWord("burglar", "Breaks into a home to steal things",
                DictionaryWord.no);
        DictionaryWord dictionary3 = new DictionaryWord("forger", "Makes an illegal copy of something",
                DictionaryWord.no);
        DictionaryWord dictionary4 = new DictionaryWord("hacker", "Breaks into a computer system", DictionaryWord.no);
        DictionaryWord dictionary5 = new DictionaryWord("hijacker", "Takes control of an airplane", DictionaryWord.no);
        DictionaryWord dictionary6 = new DictionaryWord("mugger", "Attacks and steals money from someone",
                DictionaryWord.no);
        DictionaryWord dictionary7 = new DictionaryWord("kidnapper", "Holds someone for ransom money",
                DictionaryWord.no);
        DictionaryWord dictionary8 = new DictionaryWord("murderer", "Kills another person", DictionaryWord.no);
        dictionarylist.add(dictionary1);
        dictionarylist.add(dictionary2);
        dictionarylist.add(dictionary3);
        dictionarylist.add(dictionary4);
        dictionarylist.add(dictionary5);
        dictionarylist.add(dictionary6);
        dictionarylist.add(dictionary7);
        dictionarylist.add(dictionary8);
        for (DictionaryWord dictionary : dictionarylist) {
            System.out.println(dictionary);
        }

    }
}
