package src;

public class Book{
    private String title;
    private int page;
    private double cost;
    private boolean fiction;
    public Book()
    {
        title = null;
        page = 0;
        cost = 0.0;
        fiction = false;
    }
    public Book(String title, int page, double cost, boolean fiction)
    {
        this.title = title;
        this.page = page;
        this.cost = cost;
        this.fiction = fiction;
    }
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public int getPage()
    {
        return page;
    }
    public void setPage(int page)
    {
        this.page = page;
    }
    public double getCost()
    {
        return cost;
    }
    public void setCost(double cost)
    {
        this.cost = cost;
    }
    public boolean getFiction()
    {
        return fiction;
    }
    public void setFiction(boolean fiction)
    {
        this.fiction = fiction;
    }
    public void dump()
    {
        System.out.println(title + "\t" + page + "\t" + cost + "\t" + getFiction());
    }
}