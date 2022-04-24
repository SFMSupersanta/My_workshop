package src;

public class RightTriangle{
    private int x;
    private int y;
    private int z;
    public RightTriangle(int x, int y, int z) throws IllegalRightTriangleException, IllegalTriangleException
    {
        if(!(x + y > z && y + z > x && z + x > y)) 
            throw new IllegalTriangleException();
        else if(! (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) == Math.sqrt(Math.pow(z, 2)) || Math.sqrt(Math.pow(x, 2) + Math.pow(z, 2)) == Math.sqrt(Math.pow(y, 2))
         || Math.sqrt(Math.pow(z, 2) + Math.pow(y, 2)) == Math.sqrt(Math.pow(x, 2))))
            throw new IllegalRightTriangleException();
        else this.x = x; this.y = y; this.z = z;
    }
    public RightTriangle(){}
    public int getX() { return x; }
    public int getY() { return y; }
    public int getZ() { return z; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setZ(int z) { this.z = z; }
}