

public class RightTriangle {
    public int a,b,c;
    RightTriangle(int a,int b, int c) throws Exception {
        if(a*a + b*b != c*c && a*a + c*c != b*b && b*b + c*c != a*a)
        {
            throw new IllegalRightTriangleException();
        }
    }
}
