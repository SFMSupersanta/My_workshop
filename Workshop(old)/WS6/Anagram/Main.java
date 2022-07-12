import src.Anagram;

public class Main {
    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        System.out.println("1st test is : " + anagram.isAnagram("software", "swear oft"));
        Anagram anagram2 = new Anagram("praliament", "partial men");
        System.out.println("2nd test is : " + anagram2.isAnagram());
    }
}
