

public class StringTrans {
    private String string;
    public StringTrans() {}
    public StringTrans(String string) {
        this.string = string.trim();
    }
    public String getString() {
        return string;
    }
    public void setString(String string) {
        this.string = string;
    }
    public String capFirst() {
        String[] words = string.split(" ");
        String ret = "";
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0,1).toUpperCase() + words[i].substring(1).toLowerCase();
            if(i != 0) ret = ret + " " + words[i].trim();
            else ret = ret + words[i].trim();
        }
        return ret;
    }
    public String upper() { 
        return string.toUpperCase();
    }
    public String lower() {
        return string.toLowerCase();
    }

    public void displayOccurrences() {
        int charMap[] = new int[256];
        for(int i = 0; i < string.length(); i++) {
            charMap[string.charAt(i)] += 1;
        }
        for(int i = 0; i < 256; i++) {
            if (charMap[i] != 0)
            {
                System.out.println("The character (" + (char)i + ")'s occurrences: " + charMap[i]);
            }
        }
    }
    public void displayConsonantOccurrences() {
        int charMap[] = new int[256];
        String newString = string.toLowerCase();
        for(int i = 0; i < newString.length(); i++) {
            charMap[newString.charAt(i)] += 1;
        }
        String vowels = "aiueo";
        String consonants = "bcdfghjklmnpqrstvwxyz";
        System.out.println("Your string: " + string);
        for(int i = 0; i < 256; i++) {
            if (charMap[i] != 0)
            {
                if(vowels.indexOf(i) != -1) 
                {
                    System.out.println("Vowels (" + (char)i + "/" + (char)(i-32) + ")" +  "occurrences: " + (charMap[i]));
                }
                if(consonants.indexOf(i) != -1) 
                {
                    System.out.println("Consonant (" + (char)i + "/" + (char)(i-32) + ")" +  "occurrences: " + (charMap[i]));
                }
            }
        }
    }
    public String toString() {
        return string;
    }
}