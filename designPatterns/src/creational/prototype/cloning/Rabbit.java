package creational.prototype.cloning;

public class Rabbit implements Cloneable {
    private int age;
    private Breed breed;
    private Person owner;

    public Rabbit() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(String name) {
        Person owner = new Person(name);
        this.owner = owner;
    }

    @Override
    protected Rabbit clone() {
        try {
            Rabbit rabbit = (Rabbit) super.clone();
            rabbit.owner = owner.clone();
            return rabbit;
        } catch (CloneNotSupportedException ex) {
            throw new AssertionError();
        }
    }

    public enum Breed {
        HIMALAYAN, AFRICAN, MINI_REX, LIONHEAD, DUTCH
    }
}
