class Square
{
    //Adapter design pattern example
    public int side;

    public Square(int side)
    {
        this.side = side;
    }
}

interface Rectangle
{
    int getWidth();
    int getHeight();

    default int getArea()
    {
        return getWidth() * getHeight();
    }
}

class SquareToRectangleAdapter implements Rectangle
{
    private int width;
    private int height;
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public SquareToRectangleAdapter(Square square)
    {
        this.height=square.side;
        this.width=square.side;
        // todo
    }
}