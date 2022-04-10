

public class Anagram {
    private String str1;
    private String str2;
    Anagram()
    {
        str1 = null;
        str2 = null;
    }
    Anagram(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }
    public String getString1()
    {
        return str1;
    }
    public String getString2()
    {
        return str2;
    }
    public void setString1(String str)
    {
        str1 = str;
    }
    public void setString2(String str)
    {
        str2 = str;
    }
    public boolean isAnagram()
    {
        str2 = str2.replaceAll(" ", "");
        boolean inLoopStatus, status = true;
        for(int i = 0; i < str1.length(); i++)
        {
            if(str1.charAt(i) != ' ')
            {
                inLoopStatus = false;
                for(int j = 0; j < str2.length(); j++)
                {
                    if(str1.charAt(i) == str2.charAt(j)) 
                    {
                        inLoopStatus = true;
                        str2 = str2.substring(0, j) + str2.substring(j+1);
                        j = str2.length();
                    }
                }
                if(inLoopStatus == false) status = false;
            }
           
        }
        if(!str2.equals("")) status = false;
        return status;
    }
    public boolean isAnagram(String str1, String str2)
    {
        str2 = str2.replaceAll(" ", "");
        boolean inLoopStatus, status = true;
        for(int i = 0; i < str1.length(); i++)
        {
            if(str1.charAt(i) != ' ')
            {
                inLoopStatus = false;
                for(int j = 0; j < str2.length(); j++)
                {
                    if(str1.charAt(i) == str2.charAt(j)) 
                    {
                        inLoopStatus = true;
                        str2 = str2.substring(0, j) + str2.substring(j+1);
                        j = str2.length();
                    }
                }
                if(inLoopStatus == false) status = false;
            }
           
        }
        if(!str2.equals("")) status = false;
        return status;
    }
}
