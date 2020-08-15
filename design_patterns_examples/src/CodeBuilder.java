class CodeBuilder
{
    //builder example
    private String s;
    public CodeBuilder(String className)
    {
        this.s="public class "+className+"\n{\n";
        // todo

    }

    public CodeBuilder addField(String name, String type)
    {
        s+="public "+type+ " "+name;
        // todo
        return this;
    }

    @Override
    public String toString()
    {

        return s+"}";
        // todo
    }
}