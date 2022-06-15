

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
        if(Character.isLetter(string.charAt(0)))
            string = string.substring(0, 1).toUpperCase() + string.substring(1);
        
        for(int i = 1; i < string.length()-1; i++)
        {
            
            if(string.charAt(i) == '.')
            {
                while(string.charAt(i+1) == ' ') i++;
                i++;
                string = string.substring(0, i) + string.substring(i, i+ 1).toUpperCase() + string.substring(i+1); 
            }
        }
        return string;
    }
    public String upper() { 
        while(string.indexOf("Vietnam") != -1)
        {
            string = string.substring(0, string.indexOf("Vietnam")) + string.substring(string.indexOf("Vietnam"), string.indexOf("Vietnam")+ 7).toUpperCase() + string.substring(string.indexOf("Vietnam") + 7);
        }
        return string;
    }
    public String rmBlank() {
        while(string.indexOf("  ") != -1)
        {
            int i = string.indexOf("  ");
            string = string.substring(0, i) + string.substring(i, i+1) + string.substring(i+2);
        }
        return string;
    }
    public String findFinancing() {
        while(string.indexOf("Financing Promoting Technology") != -1)
        {
            int i = string.indexOf("Financing Promoting Technology");
            string = string.substring(0, i) + "FPT University" + string.substring(i+"financing Promoting Technology".length());
        }
        return string;
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
        String String = string.toLowerCase();
        for(int i = 0; i < String.length(); i++) {
            charMap[String.charAt(i)] += 1;
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

            }
            
        }
        for(int i = 0; i < 256; i++) {
            if (charMap[i] != 0)
            {
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