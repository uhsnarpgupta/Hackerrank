package behavioural.template;

/*
A high level blueprint for an algorithm to be completed by inheritors

It allows us to define the skeleton of the algorithm with concrete implementations defined in subclasses

Define an algorithm at high level
Define constituent parts as abstract methods
Inherit the algorithm class, providing necessary overrides
 */
class Creature {
    public int attack, health;

    public Creature(int attack, int health) {
        this.attack = attack;
        this.health = health;
    }
}

abstract class CardGame {
    public Creature[] creatures;

    public CardGame(Creature[] creatures) {
        this.creatures = creatures;
    }

    // return s-1 if no clear winner (both alive or both dead)
    public int combat(int creature1, int creature2) {
        Creature first = creatures[creature1];
        Creature second = creatures[creature2];
        hit(first, second);
        hit(second, first);
        boolean firstAlive = first.health > 0;
        boolean secondAlive = second.health > 0;
        if (firstAlive == secondAlive) return -1;
        return firstAlive ? creature1 : creature2;
    }

    // attacker hits other creature
    protected abstract void hit(Creature attacker, Creature other);
}

class TemporaryCardDamageGame extends CardGame {
    public TemporaryCardDamageGame(Creature[] creatures) {
        super(creatures);
    }

    @Override
    protected void hit(Creature attacker, Creature other) {
        int oldHealth = other.health;
        other.health -= attacker.attack;
        if (other.health > 0)
            other.health = oldHealth;
    }
}

class PermanentCardDamageGame extends CardGame {
    public PermanentCardDamageGame(Creature[] creatures) {
        super(creatures);
    }

    @Override
    protected void hit(Creature attacker, Creature other) {
        other.health -= attacker.attack;
    }
}

public class Template {
    public static void main(String[] args) {
        //impasse
        Creature c1 = new Creature(1, 2);
        Creature c2 = new Creature(1, 2);
        TemporaryCardDamageGame game = new TemporaryCardDamageGame(new Creature[]{c1, c2});
        System.out.println(game.combat(0, 1));
        System.out.println(game.combat(0, 1));


        //temporaryMurder
        Creature c3 = new Creature(1, 1);
        Creature c4 = new Creature(2, 2);
        TemporaryCardDamageGame game2 = new TemporaryCardDamageGame(new Creature[]{c3, c4});
        System.out.println(game2.combat(0, 1));

        //doubleMurder
        Creature c5 = new Creature(2, 2);
        Creature c6 = new Creature(2, 2);
        TemporaryCardDamageGame game3 = new TemporaryCardDamageGame(new Creature[]{c5, c6});
        System.out.println(game3.combat(0, 1));

        //permanentDamageDeath
        Creature c7 = new Creature(1, 2);
        Creature c8 = new Creature(1, 3);
        CardGame game4 = new PermanentCardDamageGame(new Creature[]{c7, c8});
        System.out.println(game4.combat(0, 1));
        System.out.println(game4.combat(0, 1));
    }
}
