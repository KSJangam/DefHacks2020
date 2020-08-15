class Person3
{
    //proxy design pattern example
    private int age;

    public Person3(int age)
    {
        this.age = age;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String drink() { return "drinking"; }
    public String drive() { return "driving"; }
    public String drinkAndDrive() { return "driving while drunk"; }
}

class ResponsiblePerson
{
    private Person3 person;

    public ResponsiblePerson(Person3 person)
    {
        this.person=person;
        // todo
    }
    public void setAge(int age)
    {
        this.person.setAge(age);
    }
    public String drink() {
        if(person.getAge()>=18)return "drinking";
        else return "too young";
    }
    public String drive() {
        if(person.getAge()>=16)return "driving";
        else return "too young";

    }
    public String drinkAndDrive() { return "dead"; }

}