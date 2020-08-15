class Creature {
    //chain of command design pattern example
    public String name;
    public int attack, defense;

    public Creature(String name, int attack, int defense) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                ", attack=" + attack +
                ", defense=" + defense +
                '}';
    }

}
class CreatureModifier
{
    protected Creature creature;
    protected CreatureModifier next;

    public CreatureModifier(Creature creature) {
        this.creature = creature;
    }
    public void add(CreatureModifier cm)
    {
        if(next!=null){
            next.add(cm);
        }
        else next=cm;
    }

    public void handle()
    {
        if(next!=null) next.handle();
    }

}

class DoubleAttackModifier extends CreatureModifier
{

    public DoubleAttackModifier(Creature creature) {
        super(creature);
    }
    @Override
    public void handle()
    {
        System.out.println("Doubling "+creature.name+"'s attack");
        creature.attack*=2;
        super.handle();
    }
}

class IncreaseDefenseModifier extends CreatureModifier
{

    public IncreaseDefenseModifier(Creature creature) {
        super(creature);
    }

    @Override
    public void handle()
    {
        System.out.println("Increasing "+creature.name+"'s defense");
        creature.defense+=3;
        super.handle();
    }
}

class ChainDemo
{
    public static void main(String [] args)
    {
        Creature lizard = new Creature("Lizard", 3, 7);
        System.out.println(lizard);
        CreatureModifier root = new CreatureModifier(lizard);
        root.add(new DoubleAttackModifier(lizard));
        root.add(new IncreaseDefenseModifier(lizard));
        root.handle();
        System.out.println(lizard);
    }
}
