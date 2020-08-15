class Person2
{
    //Factory design pattern example
    public int id;
    public String name;

    public Person2(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
}

class PersonFactory
{
    private static int id=0;
    public Person2 createPerson(String name)
    {
        return new Person2(id++, name);
        // todo
    }
}