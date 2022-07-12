
public class ToDemical {
    private String hex;

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    ToDemical() {
        hex = null;
    }

    ToDemical(String hex) {
        this.hex = hex;
    }

    public int toDemical() {
        boolean status = true;
        int result = 0;
        for (int i = 0; i < hex.length(); i++) {
            int value;
            if (hex.charAt(i) == '0')
                value = 0;
            else if (hex.charAt(i) == '1')
                value = 1;
            else if (hex.charAt(i) == '2')
                value = 2;
            else if (hex.charAt(i) == '3')
                value = 3;
            else if (hex.charAt(i) == '4')
                value = 4;
            else if (hex.charAt(i) == '5')
                value = 5;
            else if (hex.charAt(i) == '6')
                value = 6;
            else if (hex.charAt(i) == '7')
                value = 7;
            else if (hex.charAt(i) == '8')
                value = 8;
            else if (hex.charAt(i) == '9')
                value = 9;
            else if (Character.toLowerCase(hex.charAt(i)) == 'a')
                value = 10;
            else if (Character.toLowerCase(hex.charAt(i)) == 'b')
                value = 11;
            else if (Character.toLowerCase(hex.charAt(i)) == 'c')
                value = 12;
            else if (Character.toLowerCase(hex.charAt(i)) == 'd')
                value = 13;
            else if (Character.toLowerCase(hex.charAt(i)) == 'e')
                value = 14;
            else if (Character.toLowerCase(hex.charAt(i)) == 'f')
                value = 15;
            else {
                status = false;
                i = hex.length();
                continue;
            }
            result += value * Math.pow(16, i);
        }
        if (status)
            return result;
        else
            return -1;
    }

    public int toDemical(String hex) {
        boolean status = true;
        int result = 0;
        for (int i = hex.length() - 1; i >= 0; i--) {
            int value;
            if (hex.charAt(i) == '0')
                value = 0;
            else if (hex.charAt(i) == '1')
                value = 1;
            else if (hex.charAt(i) == '2')
                value = 2;
            else if (hex.charAt(i) == '3')
                value = 3;
            else if (hex.charAt(i) == '4')
                value = 4;
            else if (hex.charAt(i) == '5')
                value = 5;
            else if (hex.charAt(i) == '6')
                value = 6;
            else if (hex.charAt(i) == '7')
                value = 7;
            else if (hex.charAt(i) == '8')
                value = 8;
            else if (hex.charAt(i) == '9')
                value = 9;
            else if (Character.toLowerCase(hex.charAt(i)) == 'a')
                value = 10;
            else if (Character.toLowerCase(hex.charAt(i)) == 'b')
                value = 11;
            else if (Character.toLowerCase(hex.charAt(i)) == 'c')
                value = 12;
            else if (Character.toLowerCase(hex.charAt(i)) == 'd')
                value = 13;
            else if (Character.toLowerCase(hex.charAt(i)) == 'e')
                value = 14;
            else if (Character.toLowerCase(hex.charAt(i)) == 'f')
                value = 15;
            else {
                status = false;
                i = -1;
                continue;
            }
            result += value * Math.pow(16, (hex.length() - i - 1));
        }
        if (status)
            return result;
        else
            return -1;
    }
}
