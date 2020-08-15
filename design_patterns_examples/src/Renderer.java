//bridge design pattern

interface Renderer{
    public String whatToRenderAs();
}

class VectorRenderer implements Renderer{
    public String whatToRenderAs(){
        return "lines";
    }
}

class RasterRenderer implements Renderer{
    public String whatToRenderAs(){
        return "pixels";
    }
}

abstract class Shape
{

    public abstract String getName();
}

class Triangle extends Shape
{
    Renderer r;

    public Triangle(Renderer r) {
        this.r = r;
    }
    @Override
    public String getName()
    {
        return "Triangle";
    }

    @Override
    public String toString()
    {
        return "Drawing " + getName() + " as " + r.whatToRenderAs();
    }
}
class Square2 extends Shape
{

    Renderer r;

    public Square2(Renderer r) {
        this.r = r;
    }

    @Override
    public String getName()
    {
        return "Square";
    }

    @Override
    public String toString()
    {
        return "Drawing " + getName() + " as " + r.whatToRenderAs();
    }
}


// imagine VectorTriangle and RasterTriangle are here too