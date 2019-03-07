package creational.prototype.cloning;

public class Test {
    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit();
        rabbit.setOwner("Sally");
        rabbit.setAge(8);
        Rabbit rabbitCopy = rabbit.clone();
        System.out.println("Name of first owner: " + rabbit.getOwner().getName());
        System.out.println("Name of second owner: " + rabbitCopy.getOwner().getName());

        rabbitCopy.getOwner().setName("Steve");

        System.out.println("Name of first owner: " + rabbit.getOwner().getName());
        System.out.println("Name of second owner: " + rabbitCopy.getOwner().getName());

        System.out.println("Age of first rabbit: " + rabbit.getAge());
        System.out.println("Age of second rabbit: " + rabbitCopy.getAge());

    }
}
