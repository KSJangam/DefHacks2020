class CardCreature
{
    //template method design pattern example
    public int attack, health;

    public CardCreature(int attack, int health)
    {
        this.attack = attack;
        this.health = health;
    }
}

abstract class CardGame
{
    public CardCreature [] creatures;

    public CardGame(CardCreature[] creatures)
    {
        this.creatures = creatures;
    }

    // returns -1 if no clear winner (both alive or both dead)
    public int combat(int creature1, int creature2)
    {
        CardCreature first = creatures[creature1];
        CardCreature second = creatures[creature2];
        int hp1=first.health;
        int hp2=second.health;
        hit(first, second);
        hit(second, first);
        if(hp1==first.health&&hp2==second.health)return -1;
        while(first.health>0&&second.health>0){
            hit(first, second);
            hit(second, first);
        }
        if(first.health==0&&second.health==0){
            return -1;
        }
        else if(first.health==0){
            return 1;
        }
        else return 2;
        // todo: determine who won and return either creature1 or creature2
    }

    // attacker hits other creature
    protected abstract void hit(CardCreature attacker, CardCreature other);
}

class TemporaryCardDamageGame extends CardGame
{
    public TemporaryCardDamageGame(CardCreature[] creatures){
        super(creatures);
    }
    protected void hit(CardCreature attacker, CardCreature other){
        if(attacker.attack>=other.health)other.health-=attacker.attack;

    }
    // todo
}

class PermanentCardDamageGame extends CardGame
{
    public PermanentCardDamageGame(CardCreature[] creatures){
        super(creatures);
    }
    // todo
    protected void hit(CardCreature attacker, CardCreature other){
        other.health-=attacker.attack;
    }
}